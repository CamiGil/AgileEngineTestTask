package com.agileengine.AgileEngineTestTask.exception;

public class TransactionNotFoundException extends RuntimeException {

    public TransactionNotFoundException(String id) {
        super("Transaction with id: " + id + " was not found.");
    }
}
