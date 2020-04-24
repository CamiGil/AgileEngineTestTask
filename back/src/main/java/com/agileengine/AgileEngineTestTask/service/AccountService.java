package com.agileengine.AgileEngineTestTask.service;

import com.agileengine.AgileEngineTestTask.exception.NegativeAccountAmountException;
import com.agileengine.AgileEngineTestTask.exception.TransactionNotFoundException;
import com.agileengine.AgileEngineTestTask.model.TransactionRQ;
import com.agileengine.AgileEngineTestTask.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import static com.agileengine.AgileEngineTestTask.model.TransactionType.CREDIT;
import static com.agileengine.AgileEngineTestTask.model.TransactionType.DEBIT;

@Service
public class AccountService {

    private AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void updateAccountValue(TransactionRQ transactionRQ) {

        BigDecimal valueTransaction = getRealValue(transactionRQ);
        synchronized (this) {
            BigDecimal newAccountValue = valueTransaction.add(accountRepository.getAccountAmount());
            if (isNegative(newAccountValue)) {
                throw new NegativeAccountAmountException();
            }
            accountRepository.updateAccountAmount(valueTransaction);
        }
    }

    BigDecimal getRealValue(TransactionRQ transactionRQ) {

        if(DEBIT.getCode().equals(transactionRQ.getType())) {
            return transactionRQ.getAmount().negate();
        }
        return transactionRQ.getAmount();
    }

    public static boolean isNegative(BigDecimal number) {
        return number.signum() == -1;
    }
}
