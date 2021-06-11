package com.quasar.fire.config;

import com.quasar.fire.utilities.exception.TopSecretException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Created by Carlos Restrepo on 6/8/2021.
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(TopSecretException.class)
  protected ResponseEntity<Object> handleTopSecretException(TopSecretException e) {
    return new ResponseEntity<>(e.getMessage(), e.getHttpStatus());
  }
}
