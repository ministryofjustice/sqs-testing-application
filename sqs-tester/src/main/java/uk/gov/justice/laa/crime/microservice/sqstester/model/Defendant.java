package uk.gov.justice.laa.crime.microservice.sqstester.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

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
