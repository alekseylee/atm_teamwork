package com.example.atm.services.flows;

import com.example.atm.data.dtos.*;
import com.example.atm.services.exceptions.AccountException;
import com.example.atm.services.exceptions.BankException;

import java.util.List;
import java.util.Optional;

public interface BankService {
    Long createBank(CreateBankRequest request) throws BankException;

    Long updateBankEmail(UpdateBankEmailRequest request) throws BankException;

    Long updateBankPhone(UpdateBankPhoneRequest request) throws BankException;
    Long updateBankTitle(UpdateBankTitleRequest request) throws BankException;
    Long deleteBank(DeleteBankRequest request) throws BankException;

    List<BankResponse> getAllBanks();

    Optional<BankResponse> getBankById(Long id);
}
