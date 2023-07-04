package uk.gov.justice.laa.crime.microservice.sqstester.model;

import jakarta.validation.constraints.NotBlank;

public class Session {
    @NotBlank(message = "You must provide the session court location.")
    private String courtLocation;
    @NotBlank(message = "You must provide the session date of hearing.")
    private String dateOfHearing;

    public String getCourtLocation() {
        return courtLocation;
    }

    public void setCourtLocation(String courtLocation) {
        this.courtLocation = courtLocation;
    }

    public String getDateOfHearing() {
        return dateOfHearing;
    }

    public void setDateOfHearing(String dateOfHearing) {
        this.dateOfHearing = dateOfHearing;
    }
}
