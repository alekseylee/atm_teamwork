package com.example.atm.data.dtos;

import com.example.atm.data.entities.AccountEntity;
import lombok.Value;

@Value
public class UpdateTransactionAmountRequest {

    Double amount;
    AccountEntity senders;



}
