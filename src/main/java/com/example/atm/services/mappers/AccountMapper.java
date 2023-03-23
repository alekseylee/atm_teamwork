package com.example.atm.services.mappers;

import com.example.atm.data.dtos.*;
import com.example.atm.data.entities.AccountEntity;

import java.util.List;

public interface AccountMapper {

    AccountEntity toEntity(CreateAccountRequest req);
    AccountEntity toEntity(UpdateAccountUserNameRequest req);
    AccountEntity toEntity(UpdateAccountBalanceRequest req);
    AccountEntity toEntity(UpdateAccountNumberRequest req);
    AccountEntity toEntity(UpdateAccountStatusRequest req);
    AccountEntity toEntity(DeleteAccountRequest req);
    AccountResponse toResponse(AccountEntity ent);
    List<AccountResponse> toResponses(List<AccountEntity> entities);




}
