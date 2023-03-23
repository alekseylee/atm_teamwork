package com.example.atm.data.dtos;

import com.example.atm.data.entities.BankEntity;
import lombok.Value;

@Value
public class AtmResponse {
    Long id;
    String address;
    String postcode;
    String city;
    String country;
    BankEntity bank;
}
