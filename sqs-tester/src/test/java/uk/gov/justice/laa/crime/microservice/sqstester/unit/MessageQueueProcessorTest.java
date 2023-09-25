package uk.gov.justice.laa.crime.microservice.sqstester.unit;

import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.AmazonSQSAsyncClientBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.testcontainers.junit.jupiter.Testcontainers;
import uk.gov.justice.laa.crime.microservice.sqstester.LocalstackConfig;
import uk.gov.justice.laa.crime.microservice.sqstester.service.MessageQueueProcessor;
import uk.gov.justice.laa.crime.microservice.sqstester.testutils.FileUtils;

import static org.testcontainers.containers.localstack.LocalStackContainer.Service.SQS;

@Testcontainers
@SpringBootTest
public class MessageQueueProcessorTest extends LocalstackConfig {

//    @Autowired
//    private MessageQueueProcessor messageQueueProcessor;
//
//    @TestConfiguration
//    static class AwsTestConfig {
//        @Bean
//        public AmazonSQSAsync amazonSQS() {
//            return AmazonSQSAsyncClientBuilder.standard()
//                    .withCredentials(localStack.getDefaultCredentialsProvider())
//                    .withEndpointConfiguration(localStack.getEndpointConfiguration(SQS))
//                    .build();
//        }
//    }

//    @Test
//    void givenQueueAndMessage_whenExecuteIsCalled_thenReturnValidResult() {
//        String json = FileUtils.readFileToString("data/sqstester/link_example.json");
//
//        Assertions.assertTrue(messageQueueProcessor.execute(QUEUE_NAME, json));
//    }
}
