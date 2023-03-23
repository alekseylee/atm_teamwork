package com.example.atm.services.mappers;

import com.example.atm.data.dtos.*;
import com.example.atm.data.entities.CustomerEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class CustomerMapperImpl implements CustomerMapper{

    @Override
    public CustomerEntity toEntity(CreateCustomerRequest req) {
        CustomerEntity entity=new CustomerEntity();
        entity.setGender(req.getGender());
        entity.setEmail(req.getEmail());
        entity.setLastName(req.getLastName());
        entity.setPinCode(req.getPinCode());
        entity.setLastName(req.getLastName());
        return entity;
    }

    @Override
    public CustomerEntity toEntity(UpdateCustomerPinCodeRequest req) {
        CustomerEntity entity=new CustomerEntity();
        entity.setPinCode(req.getPinCode());
        return entity;
    }

    @Override
    public CustomerEntity toEntity(UpdateCustomerEmailRequest req) {
        CustomerEntity entity=new CustomerEntity();
        entity.setEmail(req.getEmail());
        return entity;
    }

    @Override
    public CustomerEntity toEntity(UpdateCustomerGenderRequest req) {
        CustomerEntity entity=new CustomerEntity();
        entity.setGender(req.getGender());
        return entity;
    }

    @Override
    public CustomerEntity toEntity(UpdateCustomerNameRequest req) {
        CustomerEntity entity=new CustomerEntity();
        entity.setName(req.getName());
        return entity;
    }

    @Override
    public CustomerEntity toEntity(DeleteCustomerRequest req) {
        CustomerEntity entity=new CustomerEntity();
        entity.setId(req.getId());
        return entity;
    }

    @Override
    public CustomerResponse toResponse(CustomerEntity ent) {
        CustomerResponse response=new CustomerResponse(
                ent.getId(),
                ent.getName(),
                ent.getLastName(),
                ent.getGender(),
                ent.getPinCode(),
                ent.getEmail()
        );
        return response;
    }

    @Override
    public List<CustomerResponse> toResponses(List<CustomerEntity> entities) {
        return entities.stream().map(this::toResponse).collect(Collectors.toUnmodifiableList());
    }
}


