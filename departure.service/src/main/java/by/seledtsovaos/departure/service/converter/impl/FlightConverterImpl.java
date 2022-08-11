package by.seledtsovaos.departure.service.converter.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import by.seledtsovaos.departure.repository.dao.CountryDao;
import by.seledtsovaos.departure.repository.model.Country;
import by.seledtsovaos.departure.repository.model.Flight;
import by.seledtsovaos.departure.service.converter.FlightConverter;
import by.seledtsovaos.departure.service.dto.FlightDto;

/**
 * Is an implementation of the {@link FlightConverter} interface.
 */
@Component
public class FlightConverterImpl implements FlightConverter {

    @Autowired
    private CountryDao countryDao;

    @Override
    public FlightDto convertToDto(Flight flight) {
        FlightDto flightDto = new FlightDto();
        flightDto.setFlightId(flight.getFlightId());
        flightDto.setFlightNumber(flight.getFlightNumber());
        Country country = countryDao.findById(flight.getCountryId());
        flightDto.setCountry(country.getName());
        flightDto.setAirportId(flight.getAirportId());
        return flightDto;
    }

    @Override
    public Flight convertBack(FlightDto flightDto) {
        Flight flight = new Flight();
        flight.setFlightId(flightDto.getFlightId());
        flight.setFlightNumber(flightDto.getFlightNumber().trim());
        flight.setAirportId(flightDto.getAirportId());
        Country country = countryDao.findByName(flightDto.getCountry());
        flight.setCountryId(country.getCountryId());
        return flight;
    }
}
