package com.agileengine.AgileEngineTestTask.exception;

public class NegativeAccountAmountException extends RuntimeException {

    public NegativeAccountAmountException() {
        super("Insufficient balance. Operation cancelled.");
    }
}
