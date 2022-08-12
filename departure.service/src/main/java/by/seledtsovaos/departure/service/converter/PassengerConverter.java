package by.seledtsovaos.departure.service.converter;


import by.seledtsovaos.departure.repository.model.Passenger;
import by.seledtsovaos.departure.service.dto.PassengerDto;

/**
 * Converts a container of Passenger entity data {@link Passenger}
 * into a container for representing data {@link PassengerDto}.
 */
public interface PassengerConverter extends GenericConverter<PassengerDto, Passenger> {


}

