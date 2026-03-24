//package com.hackerrank.restcontrolleradvice.exception;
//
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
//
//@RestControllerAdvice
//public class FizzBuzzExceptionHandler extends ResponseEntityExceptionHandler {
//
//  //TODO:: implement handler methods for FizzException, BuzzException and FizzBuzzException
//}


package com.hackerrank.restcontrolleradvice.exception;

import com.hackerrank.restcontrolleradvice.dto.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class FizzBuzzExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(FizzException.class)
  public ResponseEntity<GlobalError> handleFizzException(FizzException ex) {
    GlobalError error = new GlobalError(ex.getMessage(), ex.getErrorReason());
    return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR); // 
  }

  @ExceptionHandler(BuzzException.class)
  public ResponseEntity<GlobalError> handleBuzzException(BuzzException ex) {
    GlobalError error = new GlobalError(ex.getMessage(), ex.getErrorReason());
    return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST); // 4
  }

  @ExceptionHandler(FizzBuzzException.class)
  public ResponseEntity<GlobalError> handleFizzBuzzException(FizzBuzzException ex) {
    GlobalError error = new GlobalError(ex.getMessage(), ex.getErrorReason());
    return new ResponseEntity<>(error, HttpStatus.INSUFFICIENT_STORAGE); // 5
  }
}