package com.example.atm.controllers;

import com.example.atm.data.dtos.*;
import com.example.atm.services.exceptions.CustomerException;
import com.example.atm.services.flows.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/intecbank/customer")
public class CustomerController {
    private final CustomerService customerService;
    public CustomerController(CustomerService customerService) {
        this.customerService =  customerService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> getCustomerById(@PathVariable Long id) {
        Optional<CustomerResponse> response = customerService.getCustomerById(id);
        return response.map(rep -> new ResponseEntity<>(rep, HttpStatus.FOUND)).orElseGet(()
                -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/all")
    public ResponseEntity<List<CustomerResponse>> getAll() {
        List<CustomerResponse> response = customerService.getAllCustomers();
        if (response.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }

    @PostMapping("/create")
    public ResponseEntity<Long> createCustomer(@RequestBody CreateCustomerRequest request) {
        try {
            Long response = customerService.createCustomer(request);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (CustomerException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/email")
    public ResponseEntity<Long> updateEmail(@RequestBody UpdateCustomerEmailRequest request) {
        try {
            Long response = customerService.updateCustomerEmail(request);
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        } catch (CustomerException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/name")
    public ResponseEntity<Long> updateName(@RequestBody UpdateCustomerNameRequest request) {
        try {
            Long response = customerService.updateCustomerName(request);
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        } catch (CustomerException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/pincode")
    public ResponseEntity<Long> updatePinCode(@RequestBody UpdateCustomerPinCodeRequest request) {
        try {
            Long response = customerService.updateCustomerPinCode(request);
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        } catch (CustomerException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/gender")
    public ResponseEntity<Long> updateGender(@RequestBody UpdateCustomerGenderRequest request) {
        try {
            Long response = customerService.updateCustomerGender(request);
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        } catch (CustomerException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/delete")
    public ResponseEntity<Long> delete(@RequestBody DeleteCustomerRequest request) {
        try {
            Long response = customerService.deleteCustomer(request);
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        } catch (CustomerException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}


