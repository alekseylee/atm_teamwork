package com.example.atm.data.dtos;

import com.example.atm.data.entities.BankEntity;
import lombok.Value;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Value
public class CreateAtmRequest {
      String address;
      String postcode;
      String city;
      String country;
      BankEntity bank;
}
