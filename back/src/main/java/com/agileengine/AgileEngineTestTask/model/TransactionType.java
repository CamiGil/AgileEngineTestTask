package com.agileengine.AgileEngineTestTask.model;

public enum TransactionType {

    DEBIT("debit"), CREDIT("credit");

    private String code;

    TransactionType(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }
}
