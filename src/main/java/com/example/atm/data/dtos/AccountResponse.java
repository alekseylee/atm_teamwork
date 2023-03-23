package com.example.atm.data.dtos;

import com.example.atm.data.AccountStatus;
import com.example.atm.data.entities.CustomerEntity;
import lombok.Value;

@Value
public class AccountResponse {
    Long id;
    Double balance;
    String userName;
    String accountNumber;
    AccountStatus status;
    CustomerEntity owner;

}
