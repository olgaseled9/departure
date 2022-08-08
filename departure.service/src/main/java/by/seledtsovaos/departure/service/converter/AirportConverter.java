package by.seledtsovaos.departure.service.converter;

import by.seledtsovaos.departure.repository.model.Airport;
import by.seledtsovaos.departure.service.dto.AirportDto;

/**
 * Converts a container of Airport entity data {@link Airport}
 * into a container for representing data {@link AirportDto}.
 */
public interface AirportConverter extends GenericConverter<AirportDto, Airport> {

}


