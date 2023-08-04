package uk.gov.justice.laa.crime.microservice.sqstester.service;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.GetQueueUrlResult;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.amazonaws.services.sqs.model.SendMessageResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import uk.gov.justice.laa.crime.microservice.sqstester.message_queue.AmazonSQSConfig;

@Slf4j
@RequiredArgsConstructor
@Component
@Configuration
public class MessageQueueProcessor {
    private final AmazonSQSConfig amazonSQSConfig;

    @Value("${cloud-platform.aws.sqs.queue.config.messageDelayDuration}")
    private Integer messageDelayDuration;

    public SendMessageResult execute(String queueName, String message) {

        AmazonSQS amazonSQS = amazonSQSConfig.awsSqsClient();
        GetQueueUrlResult getQueueUrlResult = amazonSQS.getQueueUrl(queueName);

        SendMessageRequest request = new SendMessageRequest()
                .withQueueUrl(getQueueUrlResult.getQueueUrl())
                .withMessageBody(message)
                .withDelaySeconds(messageDelayDuration);

        log.info("A message has been published to the Queue {} with time delay of {} seconds.",
                queueName, messageDelayDuration);

        return amazonSQS.sendMessage(request);
    }
}
