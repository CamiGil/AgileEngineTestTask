package com.agileengine.AgileEngineTestTask.model;

import com.agileengine.AgileEngineTestTask.model.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transaction {

    private TransactionType type;
    private BigDecimal amount;
    private LocalDateTime effectiveDate;

    public Transaction(TransactionType transactionType, BigDecimal amount) {
        this.type = transactionType;
        this.amount = amount;
        this.effectiveDate = LocalDateTime.now();
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(LocalDateTime effectiveDate) {
        this.effectiveDate = effectiveDate;
    }
}
