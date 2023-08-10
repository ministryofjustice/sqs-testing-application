package uk.gov.justice.laa.crime.microservice.sqstester.model.requests;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.gov.justice.laa.crime.microservice.sqstester.model.MetaData;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UnlinkRequest {
    @NotBlank(message = "You must provide the defendant ID.")
    private String defendantId;

    @NotBlank(message = "You must provide the MAAT ID.")
    private String maatId;

    @NotBlank(message = "You must provide the user ID.")
    private String userId;

    @NotBlank(message = "You must provide the reason ID.")
    private String reasonId;

    private String otherReasonText;

    @Valid
    @NotNull(message = "You must provide the metadata.")
    private MetaData metadata;
}
