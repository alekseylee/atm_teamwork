package com.example.atm.data.dtos;

import lombok.Value;

@Value
public class UpdateCustomerGenderRequest {

    String email;
    Character gender;
}
