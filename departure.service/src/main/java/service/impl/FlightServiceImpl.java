package service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import by.seledtsovaos.departure.repository.dao.FlightDao;
import by.seledtsovaos.departure.repository.exception.DaoException;
import by.seledtsovaos.departure.repository.model.Flight;
import by.seledtsovaos.departure.service.converter.FlightConverter;
import by.seledtsovaos.departure.service.dto.FlightDto;
import by.seledtsovaos.departure.service.exception.ServiceException;
import service.FlightService;

/**
 * Is an implementation of the {@link FlightService} interface.
 */
public class FlightServiceImpl implements FlightService {

    @Autowired
    private FlightDao flightDao;

    @Autowired
    private FlightConverter flightConverter;

    @Override
    public List<FlightDto> getAll() throws ServiceException {
        try {
            List<Flight> flightList = flightDao.findAll();
            List<FlightDto> flightDtoList = new ArrayList<>();
            for (Flight flight : flightList) {
                flightDtoList.add(flightConverter.convertToDto(flight));
            }
            return flightDtoList;
        }
        catch (DaoException e) {
            throw new ServiceException("Not able to get all flights. ", e);
        }
    }

    @Override
    public FlightDto findById(Long id) {
        FlightDto flightDto;
        try {
            Flight flight = flightDao.findById(id);
            flightDto = flightConverter.convertToDto(flight);
            return flightDto;
        }
        catch (DaoException e) {
            throw new ServiceException("Flight is not found with id = " + id, e);
        }
    }

    @Override
    public void add(FlightDto flightDto) {
        try {
            Flight flight = flightConverter.convertBack(flightDto);
            flightDao.add(flight);
            flightDto.setFlightId(flight.getFlightId());
        }
        catch (DaoException e) {
            throw new ServiceException("Not able to add new flight : " + flightDto, e);
        }
    }

    @Override
    public void removeById(Long id) throws ServiceException {
        try {
            flightDao.deleteById(id);
        }
        catch (DaoException e) {
            throw new ServiceException("Cannot be removed flight with id = " + id, e);
        }
    }

    @Override
    public void update(FlightDto entity) {

    }
}
