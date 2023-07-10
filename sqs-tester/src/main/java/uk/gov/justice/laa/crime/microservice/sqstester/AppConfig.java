package uk.gov.justice.laa.crime.microservice.sqstester;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import uk.gov.justice.laa.crime.microservice.sqstester.logging.MethodLoggingAspect;

@Configuration
@EnableAspectJAutoProxy
public class AppConfig {

    @Bean
    public MethodLoggingAspect methodLoggingAspect() {
        return new MethodLoggingAspect();
    }
}
