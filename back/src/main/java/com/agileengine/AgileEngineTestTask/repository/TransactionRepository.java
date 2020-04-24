package com.agileengine.AgileEngineTestTask.repository;

import com.agileengine.AgileEngineTestTask.exception.TransactionNotFoundException;
import com.agileengine.AgileEngineTestTask.model.Transaction;
import com.agileengine.AgileEngineTestTask.model.TransactionType;
import com.agileengine.AgileEngineTestTask.model.dao.TransactionDAO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Service
public class TransactionRepository {

    private ConcurrentHashMap<String, TransactionDAO> transactions;

    public TransactionRepository() {
        this.transactions = new ConcurrentHashMap<>();
    }

    public List<Transaction> getAll() {
        
        return transactions
                .entrySet()
                .stream()
                .map( e -> transformDAOToTransaction(e.getKey(), e.getValue()))
                .collect(Collectors.toList());
    }

    public Transaction getTransaction(String id) {

        TransactionDAO transactionDAO = transactions.get(id);
        if(transactionDAO == null) {
            throw new TransactionNotFoundException(id);
        }
        return transformDAOToTransaction(id, transactionDAO);
    }

    public Transaction addNewTransactionAndGetIt(TransactionType transactionType, BigDecimal amount) {
        TransactionDAO transactionDAO = new TransactionDAO(transactionType, amount);
        String id = UUID.randomUUID().toString();
        transactions.put(id, transactionDAO);

        return transformDAOToTransaction(id, transactionDAO);
    }

    private Transaction transformDAOToTransaction(String id, TransactionDAO transactionDAO) {
        return new Transaction(id, transactionDAO);
    }
}
