package com.agileengine.AgileEngineTestTask.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionResponse {

    private String id;
    private TransactionType type;
    private BigDecimal amount;
    private LocalDateTime effectiveDate;

    public TransactionResponse(String id, Transaction transaction) {
        this.id = id;
        this.type = transaction.getType();
        this.amount = transaction.getAmount();
        this.effectiveDate = transaction.getEffectiveDate();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
