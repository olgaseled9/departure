package by.seledtsovaos.departure.service.converter.impl;

import org.springframework.beans.factory.annotation.Autowired;

import by.seledtsovaos.departure.repository.dao.CountryDao;
import by.seledtsovaos.departure.repository.model.Airport;
import by.seledtsovaos.departure.repository.model.Country;
import by.seledtsovaos.departure.service.converter.AirportConverter;
import by.seledtsovaos.departure.service.converter.CountryConverter;
import by.seledtsovaos.departure.service.dto.AirportDto;

/**
 * Is an implementation of the {@link AirportConverter} interface.
 */
public class AirportConverterImpl implements AirportConverter {

    @Autowired
    private CountryDao countryDao;
    @Autowired
    private CountryConverter countryConverter;

    @Override
    public AirportDto convertToDto(Airport airport) {
        AirportDto airportDto = new AirportDto();
        airportDto.setAirportId(airport.getAirportId());
        airportDto.setAirportName(airport.getAirportName());
        Country country = countryDao.findById(airport.getCountryId());
        airportDto.setCountry(countryConverter.convertToDto(country));
        return airportDto;
    }

    @Override
    public Airport convertBack(AirportDto airportDto) {
        Airport airport = new Airport();
        airport.setAirportId(airportDto.getAirportId());
        airport.setAirportName(airportDto.getAirportName());
        airport.setCountryId(airportDto.getCountry().getCountryId());
        return airport;
    }
}