package com.example.atm.services.mappers;

import com.example.atm.data.dtos.*;
import com.example.atm.data.entities.BankEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class BankMapperImpl implements BankMapper {

    @Override
    public BankEntity toEntity(CreateBankRequest req) {
        BankEntity entity =new BankEntity();
        entity.setEmail(req.getEmail());
        entity.setTitle(req.getTitle());
        entity.setPhone(req.getPhone());
        return  entity;
    }

    @Override
    public BankEntity toEntity(UpdateBankEmailRequest req) {
        BankEntity entity =new BankEntity();
        entity.setEmail(req.getEmail());
        return entity;
    }

    @Override
    public BankEntity toEntity(UpdateBankPhoneRequest req) {
        BankEntity entity =new BankEntity();
        entity.setPhone(req.getPhone());
        return entity;
    }

    @Override
    public BankEntity toEntity(UpdateBankTitleRequest req) {
        BankEntity entity =new BankEntity();
        entity.setTitle(req.getTitle());
        return entity;
    }

    @Override
    public BankEntity toEntity(DeleteBankRequest req) {
        BankEntity entity =new BankEntity();
        entity.setId(req.getId());
        return entity;
    }

    @Override
    public BankResponse toResponse(BankEntity ent) {
        BankResponse response=new BankResponse(
                ent.getId(),
                ent.getTitle(),
                ent.getEmail(),
                ent.getPhone()
        );
        return response;
    }

    @Override
    public List<BankResponse> toResponses(List<BankEntity> entities) {
        return entities.stream().map(this::toResponse).collect(Collectors.toUnmodifiableList());
    }
}
