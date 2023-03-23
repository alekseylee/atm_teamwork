package com.example.atm.data.dtos;

import com.example.atm.data.entities.BankEntity;
import lombok.Value;

@Value
public class UpdateAtmPostCodeRequest {
      String postCode;
      BankEntity bank;
}
