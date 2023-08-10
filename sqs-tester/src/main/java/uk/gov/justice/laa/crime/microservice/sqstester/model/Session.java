package uk.gov.justice.laa.crime.microservice.sqstester.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Session {
    @NotBlank(message = "You must provide the session court location.")
    private String courtLocation;
    @NotBlank(message = "You must provide the session date of hearing.")
    private String dateOfHearing;
}
