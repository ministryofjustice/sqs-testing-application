package uk.gov.justice.laa.crime.microservice.sqstester.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import uk.gov.justice.laa.crime.microservice.sqstester.model.Request;

@RestController
public class SqsController {

    @PostMapping("/send-message")
    //@PreAuthorize("hasAnyAuthority('ROLE_CRIMEAPPS')")
    public ResponseEntity sendMessageToQueue(@RequestBody Request request) {
        // Will do something with this data in an upcoming story
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
