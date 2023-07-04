package uk.gov.justice.laa.crime.microservice.sqstester;

import org.springframework.http.ProblemDetail;

import java.util.ArrayList;
import java.util.List;

public class ApiError {
    private List<ProblemDetail> errors = new ArrayList<>();

    public ApiError(List<ProblemDetail> errors) {
        this.errors = errors;
    }

    public ApiError(ProblemDetail error) {
        this.errors.add(error);
        //this.errors.set(0, error);
    }
    public List<ProblemDetail> getErrors() {
        return errors;
    }

    public void setErrors(List<ProblemDetail> errors) {
        this.errors = errors;
    }
}
