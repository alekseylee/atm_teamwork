package com.example.atm.services.flows;

import com.example.atm.data.dtos.*;
import com.example.atm.data.entities.TransactionEntity;
import com.example.atm.data.repositories.TransactionRepository;
import com.example.atm.services.exceptions.TransactionException;
import com.example.atm.services.mappers.TransactionMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TransactionServiceImpl implements TransactionService {

    private TransactionRepository transactionRepository;
    private TransactionMapper transactionMapper;

    public TransactionServiceImpl(TransactionRepository repository, TransactionMapper mapper){
        this.transactionRepository = repository;
        this.transactionMapper = mapper;
    }

    @Override
    public Long createTrans(CreateTransactionRequest request) throws TransactionException {
        TransactionEntity entity = transactionMapper.toEntity(request);
        TransactionEntity updated = transactionRepository.save(entity);
        return updated.getId();
    }

    @Override
    public Long updateTransReceiver(UpdateTransactionReceiverRequest request) throws TransactionException {
        TransactionEntity entity = transactionMapper.toEntity(request);
        TransactionEntity updated = transactionRepository.save(entity);
        return updated.getId();
    }

    @Override
    public Long updateTransSender(UpdateTransactionSenderRequest request) throws TransactionException {
        TransactionEntity entity = transactionMapper.toEntity(request);
        TransactionEntity updated = transactionRepository.save(entity);
        return updated.getId();
    }

    @Override
    public Long updateTransAmount(UpdateTransactionAmountRequest request) throws TransactionException {
        TransactionEntity entity = transactionMapper.toEntity(request);
        TransactionEntity updated = transactionRepository.save(entity);
        return updated.getId();
    }

    @Override
    public Long deleteTrans(DeleteTransactionRequest request) throws TransactionException {
        TransactionEntity entity = transactionMapper.toEntity(request);
        TransactionEntity updated = transactionRepository.save(entity);
        return updated.getId();
    }

    @Override
    public List<TransactionResponse> getAllTransactions() {
        return transactionRepository.findAll().stream().map(transactionMapper::toResponse).collect(Collectors.toUnmodifiableList());
    }

    @Override
    public Optional<TransactionResponse> getTransById(Long id) {
        TransactionEntity entity = transactionRepository.getReferenceById(id);
        return Optional.of(transactionMapper.toResponse(entity));
    }
}
