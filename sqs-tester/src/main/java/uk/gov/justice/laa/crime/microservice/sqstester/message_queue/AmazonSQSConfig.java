package uk.gov.justice.laa.crime.microservice.sqstester.message_queue;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import io.awspring.cloud.messaging.core.QueueMessagingTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AmazonSQSConfig {
    private final SqsProperties sqsProperties;

    @Bean
    @Primary
    public AmazonSQS awsSqsClient() {
        return AmazonSQSClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(
                        new BasicAWSCredentials(sqsProperties.getAccesskey(), sqsProperties.getSecretkey())))
                .withRegion(Regions.fromName(sqsProperties.getRegion()))
                .build();
    }
}
