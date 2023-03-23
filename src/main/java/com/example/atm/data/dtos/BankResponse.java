package com.example.atm.data.dtos;

import lombok.Value;

@Value
public class BankResponse {
    Long id;
    String title;
    String email;
    String phone;
}
