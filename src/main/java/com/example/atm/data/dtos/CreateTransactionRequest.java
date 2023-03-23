package com.example.atm.data.dtos;

import com.example.atm.data.TransactionType;
import com.example.atm.data.entities.AccountEntity;
import lombok.Value;
import java.time.Instant;

@Value
public class CreateTransactionRequest {

    Double amount;
    Instant start;
    Instant end;
    TransactionType transactionType;
    AccountEntity receivers;
    AccountEntity senders;

}
