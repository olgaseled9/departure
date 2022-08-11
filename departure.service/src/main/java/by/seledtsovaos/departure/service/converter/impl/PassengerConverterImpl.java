package by.seledtsovaos.departure.service.converter.impl;

import org.springframework.stereotype.Component;

import by.seledtsovaos.departure.repository.model.Passenger;
import by.seledtsovaos.departure.service.converter.PassengerConverter;
import by.seledtsovaos.departure.service.dto.PassengerDto;

/**
 * Is an implementation of the {@link PassengerConverter} interface.
 */
@Component
public class PassengerConverterImpl implements PassengerConverter {

    @Override
    public PassengerDto convertToDto(Passenger passenger) {
        PassengerDto passengerDto = new PassengerDto();
        passengerDto.setPassengerId(passenger.getPassengerId());
        passengerDto.setFirstname(passenger.getFirstname());
        passengerDto.setLastname(passenger.getLastname());
        passengerDto.setPatronymic(passenger.getPatronymic());
        passengerDto.setFlightId(passenger.getFlightId());
        return passengerDto;
    }

    @Override
    public Passenger convertBack(PassengerDto passengerDto) {
        Passenger passenger = new Passenger();
        passenger.setPassengerId(passengerDto.getPassengerId());
        passenger.setFirstname(passengerDto.getFirstname().trim());
        passenger.setLastname(passengerDto.getLastname().trim());
        passenger.setPatronymic(passengerDto.getPatronymic().trim());
        passenger.setFlightId(passengerDto.getFlightId());
        return passenger;
    }
}

