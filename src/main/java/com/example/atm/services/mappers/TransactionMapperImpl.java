package com.example.atm.services.mappers;

import com.example.atm.data.dtos.*;
import com.example.atm.data.entities.TransactionEntity;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;
@Component
public class TransactionMapperImpl implements TransactionMapper{

    @Override
    public TransactionEntity toEntity(CreateTransactionRequest req) {
      TransactionEntity entity=new TransactionEntity();
      entity.setAmount(req.getAmount());
      entity.setEnd(req.getEnd());
      entity.setTransactionType(req.getTransactionType());
      entity.setReceivers(req.getReceivers());
      entity.setStart(req.getStart());
      entity.setSenders(req.getSenders());
      return entity;

    }

    @Override
    public TransactionEntity toEntity(UpdateTransactionAmountRequest req) {
        TransactionEntity entity=new TransactionEntity();
        entity.setAmount(req.getAmount());
        return entity;
    }

    @Override
    public TransactionEntity toEntity(UpdateTransactionReceiverRequest req) {
        TransactionEntity entity=new TransactionEntity();
        entity.setReceivers(req.getReceivers());
        return entity;
    }

    @Override
    public TransactionEntity toEntity(UpdateTransactionSenderRequest req) {
        TransactionEntity entity=new TransactionEntity();
        entity.setSenders(req.getSenders());
        return entity;
    }

    @Override
    public TransactionEntity toEntity(DeleteTransactionRequest req) {
        TransactionEntity entity=new TransactionEntity();
        entity.setId(req.getId());
        return entity;
    }

    @Override
    public TransactionResponse toResponse(TransactionEntity ent) {
        TransactionResponse  response=new TransactionResponse(
                ent.getId(),
                ent.getAmount(),
                ent.getStart(),
                ent.getEnd(),
                ent.getTransactionType(),
                ent.getReceivers(),
                ent.getSenders()
        );
        return response;
    }

    @Override
    public List<TransactionResponse> toResponses(List<TransactionEntity> entities) {
        return entities.stream().map(this::toResponse).collect(Collectors.toUnmodifiableList());
    }
}
