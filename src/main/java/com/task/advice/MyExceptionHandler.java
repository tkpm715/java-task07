package com.task.advice;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class MyExceptionHandler extends ResponseEntityExceptionHandler {
  @ExceptionHandler(MyException.class)
  public ResponseEntity<Object> handleMyException(MyException exception, WebRequest request) {
    HttpHeaders headers = new HttpHeaders();

    return super.handleExceptionInternal(exception,
        createErrorResponseBody(exception, request),
        headers,
        HttpStatus.BAD_REQUEST,
        request);
  }

  private Object createErrorResponseBody(MyException exception, WebRequest request) {
    ErrorResponseBody errorResponseBody = new ErrorResponseBody();
    int responseCode = HttpStatus.BAD_REQUEST.value();
    String responseErrorMessage = HttpStatus.BAD_REQUEST.getReasonPhrase();
    String uri = ((ServletWebRequest) request).getRequest().getRequestURI();


    errorResponseBody.setStatus(responseCode);
    errorResponseBody.setError(responseErrorMessage);
    errorResponseBody.setMessage(exception.getMessage());

    return errorResponseBody;
  }
  }

