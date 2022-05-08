package com.want.want.exception.advice;

import com.want.want.common.WantResBody;
import com.want.want.exception.UnauthorizedAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MemberControllerAdvice {

    @ExceptionHandler(value = {UnauthorizedAccessException.class})
    public ResponseEntity<WantResBody> unauthorizedAccessExceptionHandler(UnauthorizedAccessException e) {
        return new ResponseEntity<>(new WantResBody("error", e.getMessage()), HttpStatus.UNAUTHORIZED);
    }
}
