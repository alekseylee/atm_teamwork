package com.example.atm.controllers;

import com.example.atm.data.dtos.*;
import com.example.atm.services.exceptions.AccountException;
import com.example.atm.services.flows.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/intecbank/account")
public class AccountController {
    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountResponse>  getAccountById(@PathVariable Long id) {
    Optional<AccountResponse> response = accountService.getAccountById(id);
    if(response.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<AccountResponse>(response.get(), HttpStatus.FOUND);
    }

    @GetMapping("/all")
    public ResponseEntity<List<AccountResponse>> getAll() {
        List<AccountResponse> response = accountService.getAllAccounts();
        if (response.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }

    @PostMapping("/create")
    public ResponseEntity<Long> createAccount(@RequestBody CreateAccountRequest request) {
        System.out.println(request);
        try {
            Long response = accountService.createAccount(request);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (AccountException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/name")
    public ResponseEntity<Long> updateName(@RequestBody UpdateAccountUserNameRequest request) {
        try {
            Long response = accountService.updateAccountName(request);
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        } catch (AccountException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/number")
    public ResponseEntity<Long> updateNumber(@RequestBody UpdateAccountNumberRequest request) {
        try {
            Long response = accountService.updateAccountNumber(request);
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        } catch (AccountException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/status")
    public ResponseEntity<Long> updateStatus(@RequestBody UpdateAccountStatusRequest request) {
        try {
            Long response = accountService.updateAccountStatus(request);
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        } catch (AccountException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/balance")
    public ResponseEntity<Long> updateBalance(@RequestBody UpdateAccountBalanceRequest request) {
        try {
            Long response = accountService.updateAccountBalance(request);
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        } catch (AccountException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/delete")
    public ResponseEntity<Long> delete(@RequestBody DeleteAccountRequest request) {
        try {
            Long response = accountService.deleteAccount(request);
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        } catch (AccountException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}


