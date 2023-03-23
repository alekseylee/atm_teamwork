package com.example.atm.data.dtos;

import com.example.atm.data.entities.AccountEntity;
import lombok.Value;
import javax.validation.constraints.NotEmpty;
import java.time.Instant;

@Value
public class UpdateTransactionReceiverRequest {

    @NotEmpty
    AccountEntity receivers;

    Instant end;



}
