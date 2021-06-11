package com.quasar.fire.utilities.exception;

import org.springframework.http.HttpStatus;

/**
 * Created by Carlos Restrepo on 6/8/2021.
 */
public class TopSecretException extends Exception {

  private HttpStatus httpStatus;

  public TopSecretException(HttpStatus httpStatus, String message) {
    super(message);
    this.httpStatus = httpStatus;
  }

  public HttpStatus getHttpStatus() {
    return httpStatus;
  }

  public void setHttpStatus(HttpStatus httpStatus) {
    this.httpStatus = httpStatus;
  }
}
