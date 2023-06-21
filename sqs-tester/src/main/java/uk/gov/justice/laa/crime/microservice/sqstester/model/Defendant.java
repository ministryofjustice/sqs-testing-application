package uk.gov.justice.laa.crime.microservice.sqstester.model;

import java.util.List;

public class Defendant {
    private String defendantId;
    private String forename;
    private String surname;
    private String dateOfBirth;
    private String nino;
    private List<Offence> offences;

    public String getDefendantId() {
        return defendantId;
    }

    public void setDefendantId(String defendantId) {
        this.defendantId = defendantId;
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getNino() {
        return nino;
    }

    public void setNino(String nino) {
        this.nino = nino;
    }

    public List<Offence> getOffences() {
        return offences;
    }

    public void setOffences(List<Offence> offences) {
        this.offences = offences;
    }
}
