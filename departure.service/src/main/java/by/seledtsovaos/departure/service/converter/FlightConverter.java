package by.seledtsovaos.departure.service.converter;

import by.seledtsovaos.departure.repository.model.Flight;
import by.seledtsovaos.departure.service.dto.FlightDto;

/**
 * Converts a container of Flight entity data {@link FlightDto}
 * into a container for representing data {@link Flight}.
 */
public interface FlightConverter extends GenericConverter<FlightDto, Flight> {


}

