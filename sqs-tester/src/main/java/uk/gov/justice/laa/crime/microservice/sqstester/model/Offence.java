package uk.gov.justice.laa.crime.microservice.sqstester.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Offence {
    @NotBlank(message = "You must provide the offence ID.")
    private String offenceId;
    @NotBlank(message = "You must provide the offence code.")
    private String offenceCode;
    @NotNull
    private Integer asnSeq;
    @NotBlank(message = "You must provide the offence classification.")
    private String offenceClassification;
    @NotBlank(message = "You must provide the offence date.")
    private String offenceDate;
    @NotBlank(message = "You must provide the offence short title.")
    private String offenceShortTitle;
    @NotBlank(message = "You must provide the offence wording.")
    private String offenceWording;
}
