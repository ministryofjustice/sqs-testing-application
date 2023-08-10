package uk.gov.justice.laa.crime.microservice.sqstester.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Defendant {
    @NotBlank(message = "You must provide the defendant's ID.")
    private String defendantId;
    @NotBlank(message = "You must provide the defendant's forename.")
    private String forename;
    @NotBlank(message = "You must provide the defendant's surname.")
    private String surname;
    @NotBlank(message = "You must provide the defendant's date of birth.")
    private String dateOfBirth;
    @NotBlank(message = "You must provide the defendant's national insurance number.")
    private String nino;
    @Valid
    @NotNull(message = "You must provide the defendant's offences.")
    private List<Offence> offences;
}
