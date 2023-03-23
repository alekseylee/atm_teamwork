package com.example.atm.services.flows;

import com.example.atm.data.dtos.*;
import com.example.atm.data.entities.AtmEntity;
import com.example.atm.data.entities.CustomerEntity;
import com.example.atm.data.repositories.AtmRepository;
import com.example.atm.services.exceptions.AtmException;
import com.example.atm.services.exceptions.CustomerException;
import com.example.atm.services.mappers.AtmMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class AtmServiceImpl implements AtmService{
    private AtmRepository atmRepository;

    private AtmMapper atmMapper;

    public AtmServiceImpl(AtmRepository repository, AtmMapper mapper){
        this.atmRepository = repository;
        this.atmMapper = mapper;
    }

    @Override
    public Long createAtm(CreateAtmRequest request) throws AtmException {
        AtmEntity entity = atmMapper.toEntity(request);
        AtmEntity updated = atmRepository.save(entity);
        return updated.getId();
    }


    @Override
    public Long updateAtm(UpdateAtmCountryRequest request) throws AtmException {
        AtmEntity entity = atmMapper.toEntity(request);
        AtmEntity updated = atmRepository.save(entity);
        return updated.getId();
    }
    @Override
    public Long updateAtm(UpdateAtmCityRequest request) throws AtmException {
        AtmEntity entity = atmMapper.toEntity(request);
        AtmEntity updated = atmRepository.save(entity);
        return updated.getId();
    }
    @Override
    public Long updateAtm(UpdateAtmPostCodeRequest request) throws AtmException {
        AtmEntity entity = atmMapper.toEntity(request);
        AtmEntity updated = atmRepository.save(entity);
        return updated.getId();
    }
    @Override
    public Long updateAtm(UpdateAtmAddressRequest request) throws AtmException {
        AtmEntity entity = atmMapper.toEntity(request);
        AtmEntity updated = atmRepository.save(entity);
        return updated.getId();
    }

    @Override
    public Long deleteAtm(DeleteAtmRequest request) throws AtmException {
        AtmEntity atmToDelete = atmMapper.toEntity(request);
        atmRepository.delete(atmToDelete);
        return atmToDelete.getId();
    }

    @Override
    public List<AtmResponse> getAllAtm() {
        List<AtmEntity> entities = atmRepository.findAll();
        return atmMapper.toResponses(entities);
    }

    @Override
    public Optional<AtmResponse> getAtmById(Long id) {
        AtmEntity entity = atmRepository.getReferenceById(id);
        return Optional.of(atmMapper.toResponse(entity));
    }
}
