package com.example.atm.services.mappers;

import com.example.atm.data.dtos.*;
import com.example.atm.data.entities.AtmEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class AtmMapperImpl implements AtmMapper{

    @Override
    public AtmEntity toEntity(CreateAtmRequest req) {
        AtmEntity entity =new AtmEntity();
        entity.setAddress(req.getAddress());
        entity.setCity(req.getCity());
        entity.setBank(req.getBank());
        entity.setPostcode(req.getPostcode());
        entity.setCountry(req.getCountry());
        return  entity;
    }

    @Override
    public AtmEntity toEntity(UpdateAtmAddressRequest req) {
        AtmEntity entity =new AtmEntity();
        entity.setAddress(req.getAddress());
        return entity;
    }

    @Override
    public AtmEntity toEntity(UpdateAtmCityRequest req) {
        AtmEntity entity =new AtmEntity();
        entity.setCity(req.getCity());
        return entity;
    }

    @Override
    public AtmEntity toEntity(UpdateAtmCountryRequest req) {
        AtmEntity entity =new AtmEntity();
        entity.setCountry(req.getCountry());
        return entity;
    }

    @Override
    public AtmEntity toEntity(UpdateAtmPostCodeRequest req) {
        AtmEntity entity =new AtmEntity();
        entity.setPostcode(req.getPostCode());
        return entity;
    }

    @Override
    public AtmEntity toEntity(DeleteAtmRequest req) {
        AtmEntity entity =new AtmEntity();
        entity.setId(req.getId());
        return entity;
    }

    @Override
    public AtmResponse toResponse(AtmEntity ent) {
        AtmResponse response=new AtmResponse(
                ent.getId(),
                ent.getAddress(),
                ent.getPostcode(),
                ent.getCity(),
                ent.getCountry(),
                ent.getBank()
        );
        return response;
    }

    @Override
    public List<AtmResponse> toResponses(List<AtmEntity> entities) {
        return entities.stream().map(this::toResponse).collect(Collectors.toUnmodifiableList());
    }
}
