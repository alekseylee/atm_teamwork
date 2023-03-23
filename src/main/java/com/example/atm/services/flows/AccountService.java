package com.example.atm.services.flows;

import com.example.atm.data.dtos.*;
import com.example.atm.services.exceptions.AccountException;

import java.util.List;
import java.util.Optional;

public interface AccountService {
    Long createAccount(CreateAccountRequest request) throws AccountException;
    Long updateAccountStatus(UpdateAccountStatusRequest request) throws AccountException;
    Long updateAccountNumber(UpdateAccountNumberRequest request) throws AccountException;
    Long updateAccountBalance(UpdateAccountBalanceRequest request) throws AccountException;

    Long updateAccountName(UpdateAccountUserNameRequest request) throws AccountException;

    Long deleteAccount(DeleteAccountRequest request) throws AccountException;

    List<AccountResponse> getAllAccounts();

    Optional<AccountResponse> getAccountById(Long id);
}
