package uk.gov.justice.laa.crime.microservice.sqstester;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.util.WebUtils;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Handle all exceptions generated by the controller.
    @ExceptionHandler({ MethodArgumentNotValidException.class, HttpMessageNotReadableException.class })
    public final ResponseEntity<ApiError> handleException(Exception ex, WebRequest request) {
        if (ex instanceof MethodArgumentNotValidException) {
            HttpHeaders headers = new HttpHeaders();
            HttpStatus status = HttpStatus.BAD_REQUEST;

            return handleMethodArgumentNotValidException((MethodArgumentNotValidException) ex, headers, status, request);
        } else if (ex instanceof HttpMessageNotReadableException) {
            HttpHeaders headers = new HttpHeaders();
            HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

            return handleHttpMessageNotReadableException((HttpMessageNotReadableException) ex, headers, status, request);
        }

        HttpHeaders headers = new HttpHeaders();
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        return handleExceptionInternal(ex, null, headers, status, request);
    }

    // Customize the response for MethodArgumentNotValidException.
    protected ResponseEntity<ApiError> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<ProblemDetail> problemList = new ArrayList<ProblemDetail>();

        for (ObjectError error : ex.getAllErrors()) {
            ProblemDetail problemDetail = ProblemDetail.forStatus(status);
            problemDetail.setTitle("Value invalid.");
            problemDetail.setInstance(URI.create(((ServletWebRequest) request).getRequest().getRequestURL().toString()));
            problemDetail.setDetail(error.getDefaultMessage());
            problemList.add(problemDetail);
        }

        return handleExceptionInternal(ex, new ApiError(problemList), headers, status, request);
    }

    // Customize the response for HttpMessageNotReadableException.
    protected ResponseEntity<ApiError> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ProblemDetail problemDetail = ProblemDetail.forStatus(status);
        problemDetail.setTitle("JSON cannot be parsed.");
        problemDetail.setInstance(URI.create(((ServletWebRequest) request).getRequest().getRequestURL().toString()));
        problemDetail.setDetail("Invalid JSON format. Please check you are passing through all required values of the correct type.");

        return handleExceptionInternal(ex, new ApiError(problemDetail), headers, status, request);
    }

    // Customize the body of all Exception types.
    protected ResponseEntity<ApiError> handleExceptionInternal(Exception ex, ApiError body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        if (HttpStatus.INTERNAL_SERVER_ERROR.equals(status)) {
            request.setAttribute(WebUtils.ERROR_EXCEPTION_ATTRIBUTE, ex, WebRequest.SCOPE_REQUEST);
        }

        return new ResponseEntity<>(body, headers, status);
    }
}
