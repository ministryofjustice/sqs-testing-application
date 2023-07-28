package uk.gov.justice.laa.crime.microservice.sqstester.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import uk.gov.justice.laa.crime.microservice.sqstester.logging.MethodLogger;
import uk.gov.justice.laa.crime.microservice.sqstester.model.requests.LinkRequest;
import uk.gov.justice.laa.crime.microservice.sqstester.service.MessageQueueProcessor;

@RestController
@Slf4j
public class SqsController {

    @Autowired
    MessageQueueProcessor messageQueueProcessor;

    @Value("${cloud-platform.aws.sqs.queue.link}")
    private String sqsQueueLink;

    /**
     *
     * @param request The data we receive in JSON format
     * @return A string with a 200 'OK' status code
     */
    @PostMapping("/send-message/link")
    @MethodLogger()
    @Operation(summary = "Send a request off to the 'link' message queue.")
    public ResponseEntity sendMessageToLinkQueue(@Valid @RequestBody LinkRequest request) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String messageBody = objectMapper.writeValueAsString(request);
            messageQueueProcessor.execute(sqsQueueLink, messageBody);
        } catch (JsonProcessingException exception) {
            log.warn(exception.getMessage());
        }

        return ResponseEntity.ok(HttpStatus.OK);
    }
}
