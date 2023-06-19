package uk.gov.justice.laa.crime.microservice.sqstester.model;

import java.util.List;

public class Defendant {
    private String defendantId;
    private String forename;
    private String surname;
    private String dateOfBirth;
    private String nino;
    private List<Offence> offences;
}
