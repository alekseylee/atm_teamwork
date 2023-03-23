package com.example.atm.services.flows;

import com.example.atm.data.dtos.*;
import com.example.atm.services.exceptions.CustomerException;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    Long createCustomer(CreateCustomerRequest request) throws CustomerException;

    Long updateCustomerName(UpdateCustomerNameRequest request) throws CustomerException;

    Long updateCustomerEmail(UpdateCustomerEmailRequest request) throws CustomerException;

    Long updateCustomerPinCode(UpdateCustomerPinCodeRequest request) throws CustomerException;
    Long updateCustomerGender(UpdateCustomerGenderRequest request) throws CustomerException;

    Long deleteCustomer(DeleteCustomerRequest request) throws CustomerException;

    List<CustomerResponse> getAllCustomers();

    Optional<CustomerResponse> getCustomerById(Long id);
}



