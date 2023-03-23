package com.example.atm.services.mappers;

import com.example.atm.data.dtos.*;
import com.example.atm.data.entities.TransactionEntity;

import java.util.List;

public interface TransactionMapper {

    TransactionEntity toEntity(CreateTransactionRequest req);
    TransactionEntity toEntity(UpdateTransactionAmountRequest req);
    TransactionEntity toEntity(UpdateTransactionReceiverRequest req);
    TransactionEntity toEntity(UpdateTransactionSenderRequest req);
    TransactionEntity toEntity(DeleteTransactionRequest req);
    TransactionResponse toResponse(TransactionEntity ent);
    List<TransactionResponse> toResponses(List<TransactionEntity> entities);

}
