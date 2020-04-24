package com.agileengine.AgileEngineTestTask.controller;

import com.agileengine.AgileEngineTestTask.exception.NegativeAccountAmountException;
import com.agileengine.AgileEngineTestTask.exception.TransactionNotFoundException;
import com.agileengine.AgileEngineTestTask.exception.TransactionRQInvalidException;
import com.agileengine.AgileEngineTestTask.exception.TransactionTypeInvalidException;
import com.agileengine.AgileEngineTestTask.model.AppError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionController.class);

    @ExceptionHandler(NegativeAccountAmountException.class)
    public ResponseEntity<AppError> handleNegativeAccountAmountException(Exception ex) {
        LOGGER.error(ex.getMessage(), ex);
        AppError body = new AppError(ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

    @ExceptionHandler(TransactionNotFoundException.class)
    public ResponseEntity<AppError> handleTransactionNotFoundException(Exception ex) {
        LOGGER.error(ex.getMessage(), ex);
        AppError body = new AppError(ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }

    @ExceptionHandler(TransactionTypeInvalidException.class)
    public ResponseEntity<AppError> handleTransactionTypeInvalidException(Exception ex) {
        LOGGER.error(ex.getMessage(), ex);
        AppError body = new AppError(ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

    @ExceptionHandler(TransactionRQInvalidException.class)
    public ResponseEntity<AppError> handleTransactionRQInvalidException(Exception ex) {
        LOGGER.error(ex.getMessage(), ex);
        AppError body = new AppError(ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

}
