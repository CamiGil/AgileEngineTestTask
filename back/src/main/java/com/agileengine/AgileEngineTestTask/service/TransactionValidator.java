package com.agileengine.AgileEngineTestTask.service;

import com.agileengine.AgileEngineTestTask.exception.TransactionRQInvalidException;
import com.agileengine.AgileEngineTestTask.model.TransactionRQ;
import org.springframework.stereotype.Service;

@Service
public class TransactionValidator {

    public void validate(TransactionRQ transactionRQ) {

        if(transactionRQ == null){
            throw new TransactionRQInvalidException("transactionRQ");
        } else if(transactionRQ.getAmount() == null){
            throw new TransactionRQInvalidException("amount");
        } else if (transactionRQ.getType() == null) {
            throw new TransactionRQInvalidException("type");
        }
    }
}
