package com.example.atm.services.mappers;

import com.example.atm.data.dtos.*;
import com.example.atm.data.entities.AtmEntity;

import java.util.List;

public interface AtmMapper {
    AtmEntity toEntity(CreateAtmRequest req);
    AtmEntity toEntity(UpdateAtmAddressRequest req);
    AtmEntity toEntity(UpdateAtmCityRequest req);
    AtmEntity toEntity(UpdateAtmCountryRequest req);
    AtmEntity toEntity(UpdateAtmPostCodeRequest req);
    AtmEntity toEntity(DeleteAtmRequest req);
    AtmResponse toResponse(AtmEntity ent);
    List<AtmResponse> toResponses(List<AtmEntity> entities);
}
