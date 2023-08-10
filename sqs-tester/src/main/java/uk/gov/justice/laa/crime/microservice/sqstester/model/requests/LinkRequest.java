package uk.gov.justice.laa.crime.microservice.sqstester.model.requests;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.gov.justice.laa.crime.microservice.sqstester.model.Defendant;
import uk.gov.justice.laa.crime.microservice.sqstester.model.MetaData;
import uk.gov.justice.laa.crime.microservice.sqstester.model.Session;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LinkRequest {
    @NotBlank(message = "You must provide the MAAT ID.")
    private String maatId;
    @NotBlank(message = "You must provide the case URN.")
    private String caseUrn;
    @NotBlank(message = "You must provide the ASN.")
    private String asn;
    @NotBlank(message = "You must provide the CJS area code.")
    private String cjsAreaCode;
    @NotBlank(message = "You must provide the created user.")
    private String createdUser;
    @NotBlank(message = "You must provide the CJS location.")
    private String cjsLocation;
    @NotBlank(message = "You must provide the doc language.")
    private String docLanguage;
    private Boolean isActive;
    @Valid
    @NotNull(message = "You must provide the defendant.")
    private Defendant defendant;
    @Valid
    @NotNull(message = "You must provide the session(s).")
    private List<Session> sessions;
    @Valid
    @NotNull(message = "You must provide the metadata.")
    private MetaData metadata;
}