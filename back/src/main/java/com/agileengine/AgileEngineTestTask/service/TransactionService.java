package com.agileengine.AgileEngineTestTask.service;

import com.agileengine.AgileEngineTestTask.model.Transaction;
import com.agileengine.AgileEngineTestTask.model.dao.TransactionDAO;
import com.agileengine.AgileEngineTestTask.exception.TransactionNotFoundException;
import com.agileengine.AgileEngineTestTask.exception.TransactionTypeInvalidException;
import com.agileengine.AgileEngineTestTask.model.TransactionRQ;
import com.agileengine.AgileEngineTestTask.model.TransactionType;
import com.agileengine.AgileEngineTestTask.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    private TransactionRepository transactionRepository;
    private TransactionValidator transactionValidator;
    private AccountService accountService;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository,
                              TransactionValidator transactionValidator,
                              AccountService accountService) {
        this.transactionRepository = transactionRepository;
        this.transactionValidator = transactionValidator;
        this.accountService = accountService;
    }

    public List<Transaction> getAll() {
        return transactionRepository.getAll();
    }

    public Transaction getTransaction(String id) {
        return transactionRepository.getTransaction(id);
    }

    public Transaction addNewTransaction(TransactionRQ transactionRQ) {

        this.transactionValidator.validate(transactionRQ);
        this.accountService.updateAccountValue(transactionRQ);

        TransactionType transactionType = getTransactionType(transactionRQ.getType());
        return this.transactionRepository.addNewTransactionAndGetIt(transactionType, transactionRQ.getAmount());
    }

    TransactionType getTransactionType(String type) {

        if(TransactionType.DEBIT.getCode().equals(type)){
            return TransactionType.DEBIT;
        } else if(TransactionType.CREDIT.getCode().equals(type)){
            return TransactionType.CREDIT;
        }
        throw new TransactionTypeInvalidException(type);
    }

}
