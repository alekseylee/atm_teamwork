package com.example.atm.services.flows;

import com.example.atm.data.dtos.*;
import com.example.atm.data.entities.AccountEntity;
import com.example.atm.data.repositories.AccountRepository;
import com.example.atm.services.exceptions.AccountException;
import com.example.atm.services.mappers.AccountMapper;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository AccountRepository;

    private AccountMapper AccountMapper;

    public AccountServiceImpl(AccountRepository repository, AccountMapper mapper){
        this.AccountRepository = repository;
        this.AccountMapper = mapper;
    }

    @Override
    public Long createAccount(CreateAccountRequest request) throws AccountException {
        AccountEntity entity = AccountMapper.toEntity(request);
        AccountEntity updated = AccountRepository.save(entity);
        return updated.getId();
    }


    @Override
    public Long updateAccountName(UpdateAccountUserNameRequest request) throws AccountException {
        AccountEntity entity = AccountMapper.toEntity(request);
        AccountEntity updated = AccountRepository.save(entity);
        return updated.getId();
    }

    @Override
    public Long updateAccountStatus (UpdateAccountStatusRequest request) throws AccountException {
        AccountEntity entity = AccountMapper.toEntity(request);
        AccountEntity updated = AccountRepository.save(entity);
        return updated.getId();
    }

    @Override
    public Long updateAccountNumber(UpdateAccountNumberRequest request) throws AccountException {
        AccountEntity entity = AccountMapper.toEntity(request);
        AccountEntity updated = AccountRepository.save(entity);
        return updated.getId();
    }

    @Override
    public Long updateAccountBalance(UpdateAccountBalanceRequest request) throws AccountException {
        AccountEntity entity = AccountMapper.toEntity(request);
        AccountEntity updated = AccountRepository.save(entity);
        return updated.getId();
    }

    @Override
    public Long deleteAccount(DeleteAccountRequest request) throws AccountException {
        AccountEntity entity = AccountMapper.toEntity(request);
        AccountRepository.delete(entity);
        return entity.getId();
    }

    @Override
    public List<AccountResponse> getAllAccounts() {
        return AccountRepository.findAll().stream().map(AccountMapper::toResponse).collect(Collectors.toUnmodifiableList());
    }

    @Override
    public Optional<AccountResponse> getAccountById(Long id) {
        AccountEntity entity = AccountRepository.getReferenceById(id);
        return Optional.of(AccountMapper.toResponse(entity));
    }
}
