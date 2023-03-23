package com.example.atm.services.flows;

import com.example.atm.data.dtos.*;
import com.example.atm.data.entities.CustomerEntity;
import com.example.atm.data.repositories.CustomerRepository;
import com.example.atm.services.exceptions.CustomerException;
import com.example.atm.services.mappers.CustomerMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository CustomerRepository;
    private CustomerMapper CustomerMapper;
    
    public CustomerServiceImpl(CustomerRepository CustomerRepository, CustomerMapper CustomerMapper) {
        this.CustomerRepository = CustomerRepository;
        this.CustomerMapper = CustomerMapper;
    }

    @Override
    public Long createCustomer(CreateCustomerRequest request) throws CustomerException {
        CustomerEntity entityToSave = CustomerMapper.toEntity(request);
        System.out.println(entityToSave);
        CustomerEntity savedEntity = CustomerRepository.save(entityToSave);
        System.out.println(savedEntity);
        return savedEntity.getId();
    }

    @Override
    public Long updateCustomerEmail(UpdateCustomerEmailRequest request) throws CustomerException {
        CustomerEntity entityToUpdate = CustomerMapper.toEntity(request);
        CustomerEntity updatedEntity = CustomerRepository.save(entityToUpdate);
        return updatedEntity.getId();
    }

    @Override
    public Long updateCustomerName(UpdateCustomerNameRequest request) throws CustomerException {
        CustomerEntity entityToUpdate = CustomerMapper.toEntity(request);
        CustomerEntity updatedEntity = CustomerRepository.save(entityToUpdate);
        return updatedEntity.getId();
    }

    @Override
    public Long updateCustomerPinCode(UpdateCustomerPinCodeRequest request) throws CustomerException {
        CustomerEntity entityToUpdate = CustomerMapper.toEntity(request);
        CustomerEntity updatedEntity = CustomerRepository.save(entityToUpdate);
        return updatedEntity.getId();
    }

    @Override
    public Long deleteCustomer(DeleteCustomerRequest request) throws CustomerException {
        CustomerEntity CustomerToDelete = CustomerMapper.toEntity(request);
        CustomerRepository.delete(CustomerToDelete);
        return CustomerToDelete.getId();
    }

    @Override
    public List<CustomerResponse> getAllCustomers() {
        List<CustomerEntity> entities = CustomerRepository.findAll();
        return CustomerMapper.toResponses(entities);
    }

    @Override
    public Optional<CustomerResponse> getCustomerById(Long id) {
        CustomerEntity entity = CustomerRepository.getReferenceById(id);
        return Optional.ofNullable(CustomerMapper.toResponse(entity));
    }
}
