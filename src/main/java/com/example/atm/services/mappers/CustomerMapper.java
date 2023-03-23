package com.example.atm.services.mappers;

import com.example.atm.data.dtos.*;
import com.example.atm.data.entities.CustomerEntity;

import java.util.List;

public interface CustomerMapper {

    CustomerEntity toEntity(CreateCustomerRequest req);
    CustomerEntity toEntity(UpdateCustomerPinCodeRequest req);
    CustomerEntity toEntity(UpdateCustomerEmailRequest req);
    CustomerEntity toEntity(UpdateCustomerGenderRequest req);
    CustomerEntity toEntity(UpdateCustomerNameRequest req);
    CustomerEntity toEntity(DeleteCustomerRequest req);
    CustomerResponse toResponse(CustomerEntity ent);
    List<CustomerResponse> toResponses(List<CustomerEntity> entities);



}
