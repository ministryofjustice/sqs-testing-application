package uk.gov.justice.laa.crime.microservice.sqstester;

import java.util.List;

public class ApiError {
    private List<String> errors;

    public ApiError(List<String> errors) {
        this.errors = errors;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
