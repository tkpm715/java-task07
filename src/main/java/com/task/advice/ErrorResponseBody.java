package com.task.advice;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorResponseBody {

  @JsonProperty("status")
  private int status;
  @JsonProperty("error")
  private String error;
  @JsonProperty("message")
  private String message;

  public void setStatus(int status) {
    this.status = status;
  }

  public void setError(String error) {
    this.error = error;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
