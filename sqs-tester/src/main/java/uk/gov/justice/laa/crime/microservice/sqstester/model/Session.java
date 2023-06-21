package uk.gov.justice.laa.crime.microservice.sqstester.model;

public class Session {
    private String courtLocation;
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
