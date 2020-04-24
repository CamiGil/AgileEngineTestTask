package com.agileengine.AgileEngineTestTask.service;


import com.agileengine.AgileEngineTestTask.exception.TransactionRQInvalidException;
import com.agileengine.AgileEngineTestTask.model.TransactionRQ;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransactionValidatorTest {

    TransactionValidator transactionValidator = new TransactionValidator();

    @Test
    void validateNotOK() {
        TransactionRQ transactionRQ = new TransactionRQ();

        assertThrows(TransactionRQInvalidException.class,
                () -> transactionValidator.validate(transactionRQ));
    }

}