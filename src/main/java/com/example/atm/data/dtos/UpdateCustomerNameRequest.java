package com.example.atm.data.dtos;

import lombok.Value;

@Value
public class UpdateCustomerNameRequest {

    String name;
    String lastName;
}
