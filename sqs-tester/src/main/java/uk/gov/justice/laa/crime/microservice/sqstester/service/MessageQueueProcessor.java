package uk.gov.justice.laa.crime.microservice.sqstester.service;

import io.awspring.cloud.messaging.core.QueueMessagingTemplate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
@Configuration
public class MessageQueueProcessor {

    @Value("${cloud-platform.aws.sqs.queue.config.messageDelayDuration}")
    private Integer messageDelayDuration;

    @Autowired
    private QueueMessagingTemplate queueMessagingTemplate;

    public boolean execute(String queueName, String message) {
        queueMessagingTemplate.send(queueName, new GenericMessage<>(message));

        log.info("A message has been published to the Queue {} with time delay of {} seconds.",
                queueName, messageDelayDuration);

        return true;
    }
}
