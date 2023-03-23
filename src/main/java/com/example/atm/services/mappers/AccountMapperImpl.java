package com.example.atm.services.mappers;

import com.example.atm.data.dtos.*;
import com.example.atm.data.entities.AccountEntity;
import com.example.atm.data.entities.CustomerEntity;
import com.example.atm.data.repositories.AccountRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class AccountMapperImpl implements AccountMapper{

    @Override
    public AccountEntity toEntity(CreateAccountRequest req) {
        AccountEntity entity =new AccountEntity();
        entity.setUserName(req.getUserName());
        entity.setAccountNumber(req.getAccountNumber());
        entity.setBalance(req.getBalance());
        entity.setStatus(req.getStatus());
        return  entity;
    }

    @Override
    public AccountEntity toEntity(UpdateAccountUserNameRequest req) {
        AccountEntity entity =new AccountEntity();
        entity.setUserName(req.getUserName());
        return entity;
    }

    @Override
    public AccountEntity toEntity(UpdateAccountBalanceRequest req) {
        AccountEntity entity =new AccountEntity();
        entity.setBalance(req.getBalance());
        return entity;
    }

    @Override
    public AccountEntity toEntity(UpdateAccountNumberRequest req) {
        AccountEntity entity =new AccountEntity();
        entity.setAccountNumber(req.getAccountNumber());
        return entity;
    }

    @Override
    public AccountEntity toEntity(UpdateAccountStatusRequest req) {
        AccountEntity entity =new AccountEntity();
        entity.setStatus(req.getStatus());
        return entity;
    }

    @Override
    public AccountEntity toEntity(DeleteAccountRequest req) {
        AccountEntity entity =new AccountEntity();
        entity.setId(req.getId());
        return entity;
    }

    @Override
    public AccountResponse toResponse(AccountEntity ent) {
        AccountResponse response=new AccountResponse(
                ent.getId(),
                ent.getBalance(),
                ent.getUserName(),
                ent.getAccountNumber(),
                ent.getStatus(),
                ent.getOwner()
        );
        return response;
    }

    @Override
    public List<AccountResponse> toResponses(List<AccountEntity> entities) {
        return entities.stream().map(this::toResponse).collect(Collectors.toUnmodifiableList());
    }
}
