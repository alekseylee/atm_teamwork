package com.example.atm.data.dtos;

import lombok.Value;
import javax.validation.constraints.NotEmpty;

@Value
public class UpdateAccountUserNameRequest {

    @NotEmpty
    String userName;

}
