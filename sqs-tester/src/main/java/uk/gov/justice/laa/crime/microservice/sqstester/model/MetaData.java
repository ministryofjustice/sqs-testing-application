package uk.gov.justice.laa.crime.microservice.sqstester.model;

import jakarta.validation.constraints.NotBlank;

public class MetaData {
    @NotBlank(message = "You must provide the metadata LAA Transaction ID.")
    private String laaTransactionId;

    public String getLaaTransactionId() {
        return laaTransactionId;
    }

    public void setLaaTransactionId(String laaTransactionId) {
        this.laaTransactionId = laaTransactionId;
    }

    @Override
    public String toString() {
        return "MetaData{" +
                "laaTransactionId='" + laaTransactionId + '\'' +
                '}';
    }
}
