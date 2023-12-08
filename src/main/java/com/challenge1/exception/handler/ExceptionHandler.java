package com.challenge1.exception.handler;

import com.challenge1.exception.ThirdPartyServiceException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@Log4j2
@ControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(ThirdPartyServiceException.class)
    public ResponseEntity<String> handleThirdPartyServiceException(ThirdPartyServiceException ex) {
        log.info("Error calling Lob Service: " + ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Service down, please contact support team");
    }
}
