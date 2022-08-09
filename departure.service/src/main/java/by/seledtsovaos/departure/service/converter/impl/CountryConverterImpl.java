package by.seledtsovaos.departure.service.converter.impl;

import org.springframework.stereotype.Component;

import by.seledtsovaos.departure.repository.model.Country;
import by.seledtsovaos.departure.service.converter.CountryConverter;
import by.seledtsovaos.departure.service.dto.CountryDto;

/**
 * Is an implementation of the {@link CountryConverter} interface.
 */
@Component
public class CountryConverterImpl implements CountryConverter {

    @Override
    public CountryDto convertToDto(Country country) {
        CountryDto countryDto = new CountryDto();
        countryDto.setCountryId(country.getCountryId());
        countryDto.setName(country.getName());
        return countryDto;
    }

    @Override
    public Country convertBack(CountryDto countryDto) {
        Country country = new Country();
        country.setCountryId(countryDto.getCountryId());
        country.setName(countryDto.getName());
        return country;
    }
}
