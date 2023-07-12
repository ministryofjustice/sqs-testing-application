package uk.gov.justice.laa.crime.microservice.sqstester.controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import uk.gov.justice.laa.crime.microservice.sqstester.logging.MethodLogger;
import uk.gov.justice.laa.crime.microservice.sqstester.model.Request;

@RestController
public class SqsController {
    /**
     *
     * @param request The data we receive in JSON format
     * @return A string with a 200 'OK' status code
     */
    @PostMapping("/send-message")
    @MethodLogger()
    @Operation(summary = "Send a request off to the message queue.")
    public ResponseEntity sendMessageToQueue(@Valid @RequestBody Request request) {
        // Will do something with this data in an upcoming story
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
