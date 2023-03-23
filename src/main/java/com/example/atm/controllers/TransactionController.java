package com.example.atm.controllers;

import com.example.atm.data.dtos.*;
import com.example.atm.services.exceptions.CustomerException;
import com.example.atm.services.flows.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/intecbank/transactions")
public class TransactionController {
    private final TransactionService transactionService;
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionResponse> getTransactionById(@PathVariable Long id) {
        Optional<TransactionResponse> response = transactionService.getTransById(id);
        return response.map(rep -> new ResponseEntity<>(rep, HttpStatus.FOUND)).orElseGet(()
                -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/all")
    public ResponseEntity<List<TransactionResponse>> getAll() {
        List<TransactionResponse> response = transactionService.getAllTransactions();
        if (response.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }

    @PostMapping("/create")
    public ResponseEntity<Long> createTransaction(@RequestBody CreateTransactionRequest request) {
        try {
            Long response = transactionService.createTrans(request);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (CustomerException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/amount")
    public ResponseEntity<Long> updateAmount(@RequestBody UpdateTransactionAmountRequest request) {
        try {
            Long response = transactionService.updateTransAmount(request);
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        } catch (CustomerException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/receiver")
    public ResponseEntity<Long> updateReceiver(@RequestBody UpdateTransactionReceiverRequest request) {
        try {
            Long response = transactionService.updateTransReceiver(request);
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        } catch (CustomerException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/sender")
    public ResponseEntity<Long> updateSender(@RequestBody UpdateTransactionSenderRequest request) {
        try {
            Long response = transactionService.updateTransSender(request);
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        } catch (CustomerException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/delete")
    public ResponseEntity<Long> delete(@RequestBody DeleteTransactionRequest request) {
        try {
            Long response = transactionService.deleteTrans(request);
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        } catch (CustomerException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}


