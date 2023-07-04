package uk.gov.justice.laa.crime.microservice.sqstester.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

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

    public String getOffenceId() {
        return offenceId;
    }

    public void setOffenceId(String offenceId) {
        this.offenceId = offenceId;
    }

    public String getOffenceCode() {
        return offenceCode;
    }

    public void setOffenceCode(String offenceCode) {
        this.offenceCode = offenceCode;
    }

    public int getAsnSeq() {
        return asnSeq;
    }

    public void setAsnSeq(Integer asnSeq) {
        this.asnSeq = asnSeq;
    }

    public String getOffenceClassification() {
        return offenceClassification;
    }

    public void setOffenceClassification(String offenceClassification) {
        this.offenceClassification = offenceClassification;
    }

    public String getOffenceDate() {
        return offenceDate;
    }

    public void setOffenceDate(String offenceDate) {
        this.offenceDate = offenceDate;
    }

    public String getOffenceShortTitle() {
        return offenceShortTitle;
    }

    public void setOffenceShortTitle(String offenceShortTitle) {
        this.offenceShortTitle = offenceShortTitle;
    }

    public String getOffenceWording() {
        return offenceWording;
    }

    public void setOffenceWording(String offenceWording) {
        this.offenceWording = offenceWording;
    }
}
