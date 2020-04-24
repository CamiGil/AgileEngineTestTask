package com.agileengine.AgileEngineTestTask.repository;

import com.agileengine.AgileEngineTestTask.exception.TransactionNotFoundException;
import com.agileengine.AgileEngineTestTask.model.TransactionResponse;
import com.agileengine.AgileEngineTestTask.model.TransactionType;
import com.agileengine.AgileEngineTestTask.model.Transaction;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Repository
public class TransactionRepository {

    private ConcurrentHashMap<String, Transaction> transactions;

    public TransactionRepository() {
        this.transactions = new ConcurrentHashMap<>();
    }

    public List<TransactionResponse> getAll() {
        
        return transactions
                .entrySet()
                .stream()
                .map( e -> transformDAOToTransaction(e.getKey(), e.getValue()))
                .collect(Collectors.toList());
    }

    public TransactionResponse getTransaction(String id) {

        Transaction transaction = transactions.get(id);
        if(transaction == null) {
            throw new TransactionNotFoundException(id);
        }
        return transformDAOToTransaction(id, transaction);
    }

    public TransactionResponse addNewTransactionAndGetIt(TransactionType transactionType, BigDecimal amount) {
        Transaction transaction = new Transaction(transactionType, amount);
        String id = UUID.randomUUID().toString();
        transactions.put(id, transaction);

        return transformDAOToTransaction(id, transaction);
    }

    private TransactionResponse transformDAOToTransaction(String id, Transaction transaction) {
        return new TransactionResponse(id, transaction);
    }
}
