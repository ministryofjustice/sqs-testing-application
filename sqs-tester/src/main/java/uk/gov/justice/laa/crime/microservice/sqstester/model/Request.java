package uk.gov.justice.laa.crime.microservice.sqstester.model;

import java.util.List;

public class Request {
    private String maatId;
    private String caseUrn;
    private String asn;
    private String cjsAreaCode;
    private String createdUser;
    private String cjsLocation;
    private String docLanguage;
    private Boolean isActive;
    private Defendant defendant;
    private List<Session> sessions;
    private MetaData metadata;
}