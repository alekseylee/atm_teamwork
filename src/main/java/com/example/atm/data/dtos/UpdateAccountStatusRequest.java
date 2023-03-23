package com.example.atm.data.dtos;

import com.example.atm.data.AccountStatus;
import com.example.atm.data.entities.CustomerEntity;
import lombok.Value;

@Value
public class UpdateAccountStatusRequest {

    AccountStatus status;
    CustomerEntity owner;

}
