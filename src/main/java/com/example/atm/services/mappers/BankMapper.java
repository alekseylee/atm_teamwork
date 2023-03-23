package com.example.atm.services.mappers;

import com.example.atm.data.dtos.*;
import com.example.atm.data.entities.BankEntity;

import java.util.List;

public interface BankMapper {
    BankEntity toEntity(CreateBankRequest req);
    BankEntity toEntity(UpdateBankTitleRequest req);
    BankEntity toEntity(UpdateBankPhoneRequest req);
    BankEntity toEntity(UpdateBankEmailRequest req);
    BankEntity toEntity(DeleteBankRequest req);
    BankResponse toResponse(BankEntity ent);
    List<BankResponse> toResponses(List<BankEntity> entities);
}
