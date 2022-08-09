package by.seledtsovaos.departure.service.converter.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import by.seledtsovaos.departure.repository.dao.FlightDao;
import by.seledtsovaos.departure.repository.model.Passenger;
import by.seledtsovaos.departure.service.converter.FlightConverter;
import by.seledtsovaos.departure.service.converter.PassengerConverter;
import by.seledtsovaos.departure.service.dto.FlightDto;
import by.seledtsovaos.departure.service.dto.PassengerDto;

/**
 * Is an implementation of the {@link PassengerConverter} interface.
 */
@Component
public class PassengerConverterImpl implements PassengerConverter {

    @Autowired
    private FlightDao flightDao;
    @Autowired
    private FlightConverter flightConverter;

    @Override
    public PassengerDto convertToDto(Passenger passenger) {
        PassengerDto passengerDto = new PassengerDto();
        passengerDto.setPassengerId(passenger.getPassengerId());
        passengerDto.setFirstname(passenger.getFirstname());
        passengerDto.setLastname(passenger.getLastname());
        passengerDto.setPatronymic(passenger.getPatronymic());
        FlightDto flightDto = flightConverter.convertToDto(flightDao.findById(passenger.getFlightId()));
        passengerDto.setFlight(flightDto);
        return passengerDto;
    }

    @Override
    public Passenger convertBack(PassengerDto passengerDto) {
        Passenger passenger = new Passenger();
        passenger.setPassengerId(passengerDto.getPassengerId());
        passenger.setFirstname(passengerDto.getFirstname());
        passenger.setLastname(passengerDto.getLastname());
        passenger.setPatronymic(passengerDto.getPatronymic());
        passenger.setFlightId(passengerDto.getFlight().getFlightId());
        return passenger;
    }
}

