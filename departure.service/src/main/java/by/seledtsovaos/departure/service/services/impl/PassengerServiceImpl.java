package by.seledtsovaos.departure.service.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.seledtsovaos.departure.repository.dao.PassengerDao;
import by.seledtsovaos.departure.repository.exception.DaoException;
import by.seledtsovaos.departure.repository.model.Passenger;
import by.seledtsovaos.departure.service.converter.PassengerConverter;
import by.seledtsovaos.departure.service.dto.PassengerDto;
import by.seledtsovaos.departure.service.exception.ServiceException;
import by.seledtsovaos.departure.service.services.PassengerService;

/**
 * Is an implementation of the {@link PassengerService} interface.
 */
@Service
public class PassengerServiceImpl implements PassengerService {

    @Autowired
    private PassengerDao passengerDao;
    @Autowired
    private PassengerConverter passengerConverter;


    @Override
    public List<PassengerDto> getAll() throws ServiceException {
        try {
            List<Passenger> passengerList = passengerDao.findAll();
            List<PassengerDto> passengerDtoList = new ArrayList<>();
            for (Passenger passenger : passengerList) {
                passengerDtoList.add(passengerConverter.convertToDto(passenger));
            }
            return passengerDtoList;
        }
        catch (DaoException e) {
            throw new ServiceException("Not able to get all passengers. ", e);
        }
    }

    @Override
    public void removeById(Long id) throws ServiceException {
        try {
            passengerDao.deleteById(id);
        }
        catch (DaoException e) {
            throw new ServiceException("Cannot be removed passenger with id = " + id, e);
        }
    }

    @Override
    public PassengerDto findById(Long id) throws ServiceException {
        PassengerDto passengerDto;
        try {
            Passenger passenger = passengerDao.findById(id);
            passengerDto = passengerConverter.convertToDto(passenger);
            return passengerDto;
        }
        catch (DaoException e) {
            throw new ServiceException("Passenger is not found with id = " + id, e);
        }
    }

    @Override
    public void add(PassengerDto passengerDto) throws ServiceException {
        try {
            passengerDao.add(passengerConverter.convertBack(passengerDto));
        }
        catch (DaoException e) {
            throw new ServiceException("Not able to add new passenger : " + passengerDto, e);
        }
    }

    @Override
    public void update(PassengerDto passengerDto) throws ServiceException {
        try {
            passengerDao.update(passengerConverter.convertBack(passengerDto));
        }
        catch (DaoException e) {
            throw new ServiceException("Passenger is not updated : " + passengerDto, e);
        }
    }
}



