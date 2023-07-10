package uk.gov.justice.laa.crime.microservice.sqstester.logging;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import java.util.Arrays;

@Slf4j
@Aspect
public class MethodLoggingAspect {

    @After("@annotation(methodLogger)")
    public void logMethod(JoinPoint jp, MethodLogger methodLogger) throws Throwable {
        log.info("Method called: " + String.valueOf(jp.getSignature()));
        log.info("Params: " + Arrays.toString(jp.getArgs()));
    }
}
