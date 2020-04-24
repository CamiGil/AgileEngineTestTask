package com.agileengine.AgileEngineTestTask.exception;

public class TransactionRQInvalidException extends RuntimeException {

    public TransactionRQInvalidException(String field) {
        super(field + " can not be null.");
    }
}
