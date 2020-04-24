package com.agileengine.AgileEngineTestTask.exception;

public class TransactionTypeInvalidException extends RuntimeException {

    public TransactionTypeInvalidException(String type) {
        super(type + " is not a valid transaction type.");
    }
}
