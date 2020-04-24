package com.agileengine.AgileEngineTestTask.controller;

import com.agileengine.AgileEngineTestTask.model.Transaction;
import com.agileengine.AgileEngineTestTask.model.TransactionRQ;
import com.agileengine.AgileEngineTestTask.service.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TransactionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionController.class);
    private TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @RequestMapping(value = "/transactions", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<Transaction>> getAllTransactions() {

        LOGGER.info("GetAllTransactions request received");
        List<Transaction> response = transactionService.getAll();
        LOGGER.info("GetAllTransactions response finished");
        return ResponseEntity.ok(response);
    }

    @RequestMapping(value = "/transactions", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Transaction> addTransaction(@RequestBody TransactionRQ transactionRQ) {

        LOGGER.info("addTransaction request received");
        Transaction response = transactionService.addNewTransaction(transactionRQ);
        LOGGER.info("addTransaction response finished with id: " + response.getId());
        return ResponseEntity.ok(response);
    }

    @RequestMapping(value = "/transactions/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Transaction> getTransaction(@PathVariable String id) {

        LOGGER.info("getTransaction request  with id: " + id);
        Transaction response = transactionService.getTransaction(id);
        LOGGER.info("getTransaction response finished");
        return ResponseEntity.ok(response);
    }

}
