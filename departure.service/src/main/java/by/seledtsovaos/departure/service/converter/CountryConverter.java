package by.seledtsovaos.departure.service.converter;

import by.seledtsovaos.departure.repository.model.Country;
import by.seledtsovaos.departure.service.dto.CountryDto;

/**
 * Converts a container of Country entity data {@link Country}
 * into a container for representing data {@link CountryDto}.
 */
public interface CountryConverter extends GenericConverter<CountryDto, Country> {

}


