package com.twuc.shopping.component;

import com.twuc.shopping.exception.ProductNotValidException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.twuc.shopping.exception.Error;

@ControllerAdvice
public class Handler {
    private static final Logger LOGGER = LoggerFactory.getLogger(Handler.class);

    @ExceptionHandler({ProductNotValidException.class})
    public ResponseEntity<Error> rsExceptionHandler(Exception e){
        String errorMessage= e.getMessage();
        LOGGER.error("=======" + e.getMessage() + "=======");
        Error error = new Error();
        error.setError(errorMessage);
        return ResponseEntity.badRequest().body(error);
    }
}
