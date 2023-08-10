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
public class MetaData {
    @NotBlank(message = "You must provide the metadata LAA Transaction ID.")
    private String laaTransactionId;
}
