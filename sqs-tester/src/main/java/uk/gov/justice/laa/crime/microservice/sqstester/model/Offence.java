package uk.gov.justice.laa.crime.microservice.sqstester.model;

public class Offence {
    private String offenceId;
    private String offenceCode;
    private Integer asnSeq;
    private String offenceClassification;
    private String offenceDate;
    private String offenceShortTitle;
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
