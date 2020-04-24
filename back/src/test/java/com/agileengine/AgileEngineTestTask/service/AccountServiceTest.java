package com.agileengine.AgileEngineTestTask.service;

import com.agileengine.AgileEngineTestTask.exception.NegativeAccountAmountException;
import com.agileengine.AgileEngineTestTask.model.TransactionRQ;
import com.agileengine.AgileEngineTestTask.model.TransactionType;
import com.agileengine.AgileEngineTestTask.repository.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AccountServiceTest {

    AccountRepository accountRepository;
    AccountService accountService;

    @BeforeEach
    void setUp() {
        this.accountRepository = mock(AccountRepository.class);
        this.accountService = new AccountService(accountRepository);
    }

    @Test
    void updateAccountValueDebitOK() {

        when(this.accountRepository.getAccountAmount()).thenReturn(BigDecimal.valueOf(100));

        TransactionRQ transactionRQ = new TransactionRQ();
        transactionRQ.setAmount(BigDecimal.TEN);
        transactionRQ.setType(TransactionType.DEBIT.getCode());

        accountService.updateAccountValue(transactionRQ);
        verify(accountRepository).updateAccountAmount(BigDecimal.TEN.negate());
    }

    @Test
    void updateAccountValueCreditOK() {

        when(this.accountRepository.getAccountAmount()).thenReturn(BigDecimal.ZERO);

        TransactionRQ transactionRQ = new TransactionRQ();
        transactionRQ.setAmount(BigDecimal.TEN);
        transactionRQ.setType(TransactionType.CREDIT.getCode());

        accountService.updateAccountValue(transactionRQ);
        verify(accountRepository).updateAccountAmount(BigDecimal.TEN);
    }

    @Test
    void updateAccountValueNotEnoughMoney() {

        when(this.accountRepository.getAccountAmount()).thenReturn(BigDecimal.ZERO);

        TransactionRQ transactionRQ = new TransactionRQ();
        transactionRQ.setAmount(BigDecimal.TEN);
        transactionRQ.setType(TransactionType.DEBIT.getCode());

        assertThrows(NegativeAccountAmountException.class,
                () -> accountService.updateAccountValue(transactionRQ));
    }

    @Test
    void getRealValueDebit() {

        TransactionRQ transactionRQ = new TransactionRQ();
        transactionRQ.setType(TransactionType.DEBIT.getCode());
        transactionRQ.setAmount(BigDecimal.TEN);

        assertEquals(BigDecimal.TEN.negate(),
                accountService.getRealValue(transactionRQ));
    }

    @Test
    void getRealValueCredit() {

        TransactionRQ transactionRQ = new TransactionRQ();
        transactionRQ.setType(TransactionType.CREDIT.getCode());
        transactionRQ.setAmount(BigDecimal.TEN);

        assertEquals(BigDecimal.TEN,
                accountService.getRealValue(transactionRQ));
    }

    @Test
    void isNegative() {
        assertTrue(AccountService.isNegative(BigDecimal.TEN.negate()));
    }

    @Test
    void isNotNegative() {
        assertFalse(AccountService.isNegative(BigDecimal.TEN));
    }

}