package com.example.atm.controllers;

import com.example.atm.data.dtos.*;
import com.example.atm.services.exceptions.BankException;
import com.example.atm.services.flows.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/intecbank/bank")
public class BankController {

    private final BankService bankService;

    @Autowired
    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<BankResponse> getAtmById(@PathVariable Long id) {
        Optional<BankResponse> response = bankService.getBankById(id);
        if(response.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<BankResponse>(response.get(), HttpStatus.FOUND);
    }

    @GetMapping("/all")
    public ResponseEntity<List<BankResponse>> getAll() {
        List<BankResponse> response = bankService.getAllBanks();
        if (response.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }

    @PostMapping("/create")
    public ResponseEntity<Long> createBank(@RequestBody CreateBankRequest request) {
        System.out.println(request);
        try {
            Long response = bankService.createBank(request);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (BankException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/email")
    public ResponseEntity<Long> updateEmail(@RequestBody UpdateBankEmailRequest request) {
        try {
            Long response = bankService.updateBankEmail(request);
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        } catch (BankException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/phone")
    public ResponseEntity<Long> updatePhone(@RequestBody UpdateBankPhoneRequest request) {
        try {
            Long response = bankService.updateBankPhone(request);
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        } catch (BankException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/title")
    public ResponseEntity<Long> updateTitle(@RequestBody UpdateBankTitleRequest request) {
        try {
            Long response = bankService.updateBankTitle(request);
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        } catch (BankException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/delete")
    public ResponseEntity<Long> delete(@RequestBody DeleteBankRequest request) {
        try {
            Long response = bankService.deleteBank(request);
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        } catch (BankException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
