package com.example.atm.data.dtos;

import com.example.atm.data.entities.AccountEntity;
import lombok.Value;
import java.time.Instant;

@Value
public class UpdateTransactionSenderRequest {

    AccountEntity senders;
    Instant start;

}
