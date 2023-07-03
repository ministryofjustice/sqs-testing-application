package uk.gov.justice.laa.crime.microservice.sqstester.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class Request {
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

    public String getMaatId() {
        return maatId;
    }

    public void setMaatId(String maatId) {
        this.maatId = maatId;
    }

    public String getCaseUrn() {
        return caseUrn;
    }

    public void setCaseUrn(String caseUrn) {
        this.caseUrn = caseUrn;
    }

    public String getAsn() {
        return asn;
    }

    public void setAsn(String asn) {
        this.asn = asn;
    }

    public String getCjsAreaCode() {
        return cjsAreaCode;
    }

    public void setCjsAreaCode(String cjsAreaCode) {
        this.cjsAreaCode = cjsAreaCode;
    }

    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    public String getCjsLocation() {
        return cjsLocation;
    }

    public void setCjsLocation(String cjsLocation) {
        this.cjsLocation = cjsLocation;
    }

    public String getDocLanguage() {
        return docLanguage;
    }

    public void setDocLanguage(String docLanguage) {
        this.docLanguage = docLanguage;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Defendant getDefendant() {
        return defendant;
    }

    public void setDefendant(Defendant defendant) {
        this.defendant = defendant;
    }

    public List<Session> getSessions() {
        return sessions;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }

    public MetaData getMetadata() {
        return metadata;
    }

    public void setMetadata(MetaData metadata) {
        this.metadata = metadata;
    }
}