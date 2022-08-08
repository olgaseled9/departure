package by.seledtsovaos.departure.service.converter.impl;

import org.springframework.beans.factory.annotation.Autowired;

import by.seledtsovaos.departure.repository.dao.AirportDao;
import by.seledtsovaos.departure.repository.dao.CountryDao;
import by.seledtsovaos.departure.repository.model.Airport;
import by.seledtsovaos.departure.repository.model.Country;
import by.seledtsovaos.departure.repository.model.Flight;
import by.seledtsovaos.departure.service.converter.AirportConverter;
import by.seledtsovaos.departure.service.converter.CountryConverter;
import by.seledtsovaos.departure.service.converter.FlightConverter;
import by.seledtsovaos.departure.service.dto.FlightDto;

/**
 * Is an implementation of the {@link FlightConverter} interface.
 */
public class FlightConverterImpl implements FlightConverter {

    @Autowired
    private CountryDao countryDao;
    @Autowired
    private AirportDao airportDao;
    @Autowired
    private CountryConverter countryConverter;
    @Autowired
    private AirportConverter airportConverter;

    @Override
    public FlightDto convertToDto(Flight flight) {
        FlightDto flightDto = new FlightDto();
        flightDto.setFlightId(flight.getFlightId());
        flightDto.setFlightNumber(flight.getFlightNumber());
        Country country = countryDao.findById(flight.getCountryId());
        flightDto.setCountry(countryConverter.convertToDto(country));
        Airport airport = airportDao.findById(flight.getAirportId());
        flightDto.setAirport(airportConverter.convertToDto(airport));
        return flightDto;
    }

    @Override
    public Flight convertBack(FlightDto flightDto) {
        Flight flight = new Flight();
        flight.setFlightId(flightDto.getFlightId());
        flight.setFlightNumber(flightDto.getFlightNumber());
        flight.setAirportId(flightDto.getAirport().getAirportId());
        flight.setCountryId(flightDto.getCountry().getCountryId());
        return flight;
    }
}
