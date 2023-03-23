package com.example.atm.data.dtos;

import lombok.Value;

@Value
public class UpdateCustomerPinCodeRequest {

    String pinCode;
    String email;
}
