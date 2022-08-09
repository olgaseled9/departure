package by.seledtsovaos.departure.service.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.seledtsovaos.departure.repository.dao.AirportDao;
import by.seledtsovaos.departure.repository.exception.DaoException;
import by.seledtsovaos.departure.repository.model.Airport;
import by.seledtsovaos.departure.service.converter.AirportConverter;
import by.seledtsovaos.departure.service.dto.AirportDto;
import by.seledtsovaos.departure.service.exception.ServiceException;
import by.seledtsovaos.departure.service.services.AirportService;

/**
 * Is an implementation of the {@link AirportService} interface.
 */
@Service
public class AirportServiceImpl implements AirportService {

    @Autowired
    private AirportDao airportDao;
    @Autowired
    private AirportConverter airportConverter;

    @Override
    public List<AirportDto> getAll() {
        try {
            List<Airport> airportList = airportDao.findAll();
            List<AirportDto> airportDtoList = new ArrayList<>();
            for (Airport airport : airportList) {
                airportDtoList.add(airportConverter.convertToDto(airport));
            }
            return airportDtoList;
        }
        catch (DaoException e) {
            throw new ServiceException("Not able to get all airports. ", e);
        }
    }

    @Override
    public AirportDto findById(Long id) {
        AirportDto airportDto;
        try {
            Airport airport = airportDao.findById(id);
            airportDto = airportConverter.convertToDto(airport);
            return airportDto;
        }
        catch (DaoException e) {
            throw new ServiceException("Airport is not found with id = " + id, e);
        }
    }

    @Override
    public void add(AirportDto airportDto) {
        try {
            airportDao.add(airportConverter.convertBack(airportDto));
        }
        catch (DaoException e) {
            throw new ServiceException("Not able to add new airport : " + airportDto, e);
        }
    }

    @Override
    public void removeById(Long id) {
        try {
            airportDao.deleteById(id);
        }
        catch (DaoException e) {
            throw new ServiceException("Cannot be removed airport with id = " + id, e);
        }
    }

    @Override
    public void update(AirportDto airportDto) {
        try {
            airportDao.update(airportConverter.convertBack(airportDto));
        }
        catch (DaoException e) {
            throw new ServiceException("Airport is not updated : " + airportDto, e);
        }
    }
}
