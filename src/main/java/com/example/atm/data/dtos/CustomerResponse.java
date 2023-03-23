package com.example.atm.data.dtos;

import lombok.Value;

@Value
public class CustomerResponse {
     Long id;
     String name;
     String lastName;
     Character gender;
     String pinCode;
     String email;
}
