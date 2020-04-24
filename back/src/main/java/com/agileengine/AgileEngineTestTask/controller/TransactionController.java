package com.agileengine.AgileEngineTestTask.controller;

import com.agileengine.AgileEngineTestTask.model.TransactionResponse;
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
    public ResponseEntity<List<TransactionResponse>> getAllTransactions() {

        LOGGER.info("GetAllTransactions request received");
        List<TransactionResponse> response = transactionService.getAll();
        LOGGER.info("GetAllTransactions response finished");
        return ResponseEntity.ok(response);
    }

    @RequestMapping(value = "/transactions", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<TransactionResponse> addTransaction(@RequestBody TransactionRQ transactionRQ) {

        LOGGER.info("addTransaction request received");
        TransactionResponse response = transactionService.addNewTransaction(transactionRQ);
        LOGGER.info("addTransaction response finished with id: " + response.getId());
        return ResponseEntity.ok(response);
    }

    @RequestMapping(value = "/transactions/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<TransactionResponse> getTransaction(@PathVariable String id) {

        LOGGER.info("getTransaction request  with id: " + id);
        TransactionResponse response = transactionService.getTransaction(id);
        LOGGER.info("getTransaction response finished");
        return ResponseEntity.ok(response);
    }

}
