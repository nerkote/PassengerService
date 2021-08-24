package com.passenger.services.controller;


import java.util.HashMap;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.passenger.services.entity.Passenger;
import com.passenger.services.exceptions.ResourceNotFoundException;
import com.passenger.services.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1")
public class PassengerController {

    @Autowired
    private PassengerRepository passengerRepository;

    @GetMapping("/passengers")
    public List <Passenger> getAllPassengers() {
        return passengerRepository.findAll();
    }

    @GetMapping("/passengers/{id}")
    public ResponseEntity <Passenger> getPassengerById(@PathVariable(value = "id") int passengerId)
            throws ResourceNotFoundException {
        Passenger passenger = passengerRepository.findById(passengerId)
                .orElseThrow(() -> new ResourceNotFoundException("Passenger not found for this id :: " + passengerId));
        return ResponseEntity.ok().body(passenger);
    }

    @PostMapping("/passengers")
    public Passenger createPassenger(@Valid @RequestBody Passenger passenger) {
        return passengerRepository.save(passenger);
    }

    @PutMapping("/passengers/{id}")
    public ResponseEntity <Passenger> updatePassenger(@PathVariable(value = "id") int passengerId,
                                                      @Valid @RequestBody Passenger passengerDetails) throws ResourceNotFoundException {
        Passenger passenger = passengerRepository.findById(passengerId)
                .orElseThrow(() -> new ResourceNotFoundException("Passenger not found for this id :: " + passengerId));

        passenger.setEmail(passengerDetails.getEmail());
        passenger.setPassportId(passengerDetails.getPassportId());
        passenger.setLastName(passengerDetails.getLastName());
        passenger.setFirstName(passengerDetails.getFirstName());
        final Passenger updatedPassenger = passengerRepository.save(passenger);
        return ResponseEntity.ok(updatedPassenger);
    }

    @DeleteMapping("/passengers/{id}")
    public Map <String, Boolean> deletePassenger(@PathVariable(value = "id") int passengerId)
            throws ResourceNotFoundException {
        Passenger passenger = passengerRepository.findById(passengerId)
                .orElseThrow(() -> new ResourceNotFoundException("Passenger not found for this id :: " + passengerId));

        passengerRepository.delete(passenger);
        Map <String, Boolean> response = new HashMap <>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}