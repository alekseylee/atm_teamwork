package com.example.atm.controllers;

import com.example.atm.data.dtos.*;
import com.example.atm.services.exceptions.AtmException;
import com.example.atm.services.flows.AtmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/intecbank/atm")
public class AtmController {

    private final AtmService atmService;

    @Autowired
    public AtmController(AtmService atmService) {
        this.atmService = atmService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<AtmResponse> getAtmById(@PathVariable Long id) {
        Optional<AtmResponse> response = atmService.getAtmById(id);
        if(response.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<AtmResponse>(response.get(), HttpStatus.FOUND);
    }

    @GetMapping("/all")
    public ResponseEntity<List<AtmResponse>> getAll() {
        List<AtmResponse> response = atmService.getAllAtm();
        if (response.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }

    @PostMapping("/create")
    public ResponseEntity<Long> createAtm(@RequestBody CreateAtmRequest request) {
        System.out.println(request);
        try {
            Long response = atmService.createAtm(request);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (AtmException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/address")
    public ResponseEntity<Long> updateAddress(@RequestBody UpdateAtmAddressRequest request) {
        try {
            Long response = atmService.updateAtm(request);
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        } catch (AtmException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/city")
    public ResponseEntity<Long> updateCity(@RequestBody UpdateAtmCityRequest request) {
        try {
            Long response = atmService.updateAtm(request);
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        } catch (AtmException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/country")
    public ResponseEntity<Long> updateCountry(@RequestBody UpdateAtmCountryRequest request) {
        try {
            Long response = atmService.updateAtm(request);
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        } catch (AtmException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/postcode")
    public ResponseEntity<Long> updatePostCode(@RequestBody UpdateAtmPostCodeRequest request) {
        try {
            Long response = atmService.updateAtm(request);
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        } catch (AtmException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/delete")
    public ResponseEntity<Long> delete(@RequestBody DeleteAtmRequest request) {
        try {
            Long response = atmService.deleteAtm(request);
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        } catch (AtmException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
