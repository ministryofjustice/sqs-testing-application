package uk.gov.justice.laa.crime.microservice.sqstester.message_queue;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@ConfigurationProperties(prefix = "cloud-platform.aws.sqs")
@Component
public class SqsProperties {

    private String region;
    private String accesskey;
    private String secretkey;
}
