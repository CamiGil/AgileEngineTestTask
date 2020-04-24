package com.agileengine.AgileEngineTestTask.model;

import com.agileengine.AgileEngineTestTask.model.dao.TransactionDAO;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transaction {

    private String id;
    private TransactionType type;
    private BigDecimal amount;
    private LocalDateTime effectiveDate;

    public Transaction(String id, TransactionDAO transactionDAO) {
        this.id = id;
        this.type = transactionDAO.getType();
        this.amount = transactionDAO.getAmount();
        this.effectiveDate = transactionDAO.getEffectiveDate();
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
