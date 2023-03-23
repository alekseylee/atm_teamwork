package com.example.atm.data.dtos;

import com.example.atm.data.entities.BankEntity;
import lombok.Value;

@Value
public class UpdateAtmCountryRequest {
      String country;
      BankEntity bank;
}
