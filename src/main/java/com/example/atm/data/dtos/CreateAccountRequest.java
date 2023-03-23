package com.example.atm.data.dtos;

import com.example.atm.data.AccountStatus;
import lombok.Value;
@Value
public class CreateAccountRequest {

    Double balance;
    String userName;
    String accountNumber;
    CreateCustomerRequest owner;
    AccountStatus status;


}
