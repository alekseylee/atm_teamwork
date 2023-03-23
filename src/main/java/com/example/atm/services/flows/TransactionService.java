package com.example.atm.services.flows;

import com.example.atm.data.dtos.*;
import com.example.atm.services.exceptions.TransactionException;
import java.util.List;
import java.util.Optional;

public interface TransactionService {
    Long createTrans(CreateTransactionRequest request) throws TransactionException;

    Long updateTransSender(UpdateTransactionSenderRequest request) throws TransactionException;

    Long updateTransReceiver(UpdateTransactionReceiverRequest request) throws TransactionException;

    Long updateTransAmount(UpdateTransactionAmountRequest request) throws TransactionException;

    Long deleteTrans(DeleteTransactionRequest request) throws TransactionException;

    List<TransactionResponse> getAllTransactions();

    Optional<TransactionResponse> getTransById(Long id);
}
