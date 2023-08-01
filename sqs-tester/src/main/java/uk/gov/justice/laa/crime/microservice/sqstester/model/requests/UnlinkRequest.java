package uk.gov.justice.laa.crime.microservice.sqstester.model.requests;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import uk.gov.justice.laa.crime.microservice.sqstester.model.MetaData;

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

    public String getDefendantId() {
        return defendantId;
    }

    public void setDefendantId(String defendantId) {
        this.defendantId = defendantId;
    }

    public String getMaatId() {
        return maatId;
    }

    public void setMaatId(String maatId) {
        this.maatId = maatId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getReasonId() {
        return reasonId;
    }

    public void setReasonId(String reasonId) {
        this.reasonId = reasonId;
    }

    public String getOtherReasonText() {
        return otherReasonText;
    }

    public void setOtherReasonText(String otherReasonText) {
        this.otherReasonText = otherReasonText;
    }

    public MetaData getMetadata() {
        return metadata;
    }

    public void setMetadata(MetaData metadata) {
        this.metadata = metadata;
    }

    @Override
    public String toString() {
        return "UnlinkRequest{" +
                "defendantId='" + defendantId + '\'' +
                ", maatId='" + maatId + '\'' +
                ", userId='" + userId + '\'' +
                ", reasonId='" + reasonId + '\'' +
                ", otherReasonText='" + otherReasonText + '\'' +
                ", metadata=" + metadata +
                '}';
    }
}
