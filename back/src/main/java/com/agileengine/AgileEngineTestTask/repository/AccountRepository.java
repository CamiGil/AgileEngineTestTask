package com.agileengine.AgileEngineTestTask.repository;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Repository
public class AccountRepository {

    BigDecimal accountAmount;

    public AccountRepository() {
        this.accountAmount =BigDecimal.ZERO;
    }

    public BigDecimal getAccountAmount() {
        return accountAmount;
    }

    public void updateAccountAmount(BigDecimal transactionAmount) {
        this.accountAmount = accountAmount.add(transactionAmount);
    }
}
