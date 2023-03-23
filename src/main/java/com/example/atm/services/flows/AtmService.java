package com.example.atm.services.flows;

import com.example.atm.data.dtos.*;
import com.example.atm.services.exceptions.AccountException;

import java.util.List;
import java.util.Optional;

public interface AtmService {
    Long createAtm(CreateAtmRequest request) throws AccountException;
    Long updateAtm(UpdateAtmAddressRequest request) throws AccountException;
    Long updateAtm(UpdateAtmPostCodeRequest request) throws AccountException;
    Long updateAtm(UpdateAtmCountryRequest request) throws AccountException;
    Long updateAtm(UpdateAtmCityRequest request) throws AccountException;
    Long deleteAtm(DeleteAtmRequest request) throws AccountException;


    List<AtmResponse> getAllAtm();

    Optional<AtmResponse> getAtmById(Long id);
}
