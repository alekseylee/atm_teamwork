package com.example.atm.data.dtos;

import com.example.atm.data.entities.CustomerEntity;
import lombok.Value;

@Value
public class UpdateAccountBalanceRequest {

     Double balance;

     CustomerEntity owner;

}
