package com.agileengine.AgileEngineTestTask.service;

import com.agileengine.AgileEngineTestTask.exception.TransactionTypeInvalidException;
import com.agileengine.AgileEngineTestTask.model.TransactionType;
import com.agileengine.AgileEngineTestTask.repository.TransactionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class TransactionServiceTest {

    TransactionRepository transactionRepository;
    TransactionService transactionService;
    TransactionValidator transactionValidator;
    AccountService accountService;

    @BeforeEach
    void setUp() {
        this.transactionRepository = mock(TransactionRepository.class);
        this.transactionValidator = mock(TransactionValidator.class);
        this.accountService = mock(AccountService.class);
        this.transactionService = new TransactionService(transactionRepository, transactionValidator, accountService);
    }

    @Test
    void getTransactionTypeNotOK() {

        assertThrows(TransactionTypeInvalidException.class,
                () -> transactionService.getTransactionType("invalid"));
    }

    @Test
    void getTransactionTypeOK() {

        assertEquals(TransactionType.DEBIT, transactionService.getTransactionType("debit"));
    }
}