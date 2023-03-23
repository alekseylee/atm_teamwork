package com.example.atm.data.dtos;

import com.example.atm.data.entities.BankEntity;
import lombok.Value;

@Value
public class UpdateAtmAddressRequest {
      String address;
      BankEntity bank;
}
