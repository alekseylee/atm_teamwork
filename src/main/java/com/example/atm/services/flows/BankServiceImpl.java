package com.example.atm.services.flows;

import com.example.atm.data.dtos.*;
import com.example.atm.data.entities.BankEntity;
import com.example.atm.data.repositories.BankRepository;
import com.example.atm.services.exceptions.BankException;
import com.example.atm.services.mappers.BankMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BankServiceImpl implements BankService {
    private BankMapper bankMapper;
    private BankRepository bankRepository;
    public BankServiceImpl(BankRepository repository, BankMapper mapper){
        this.bankRepository = repository;
        this.bankMapper = mapper;
    }

    @Override
    public Long createBank(CreateBankRequest request) throws BankException {
        BankEntity entity = bankMapper.toEntity(request);
        BankEntity updated = bankRepository.save(entity);
        return updated.getId();
    }

    @Override
    public Long updateBankEmail(UpdateBankEmailRequest request) throws BankException {
        return null;
    }

    @Override
    public Long updateBankPhone(UpdateBankPhoneRequest request) throws BankException {
        return null;
    }

    @Override
    public Long updateBankTitle(UpdateBankTitleRequest request) throws BankException {
        return null;
    }

    @Override
    public Long deleteBank(DeleteBankRequest request) throws BankException {
        return null;
    }

    @Override
    public List<BankResponse> getAllBanks() {
        return null;
    }

    @Override
    public Optional<BankResponse> getBankById(Long id) {
        return Optional.empty();
    }
}
