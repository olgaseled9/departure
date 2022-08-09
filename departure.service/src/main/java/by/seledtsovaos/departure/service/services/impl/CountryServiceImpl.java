package by.seledtsovaos.departure.service.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.seledtsovaos.departure.repository.dao.CountryDao;
import by.seledtsovaos.departure.repository.exception.DaoException;
import by.seledtsovaos.departure.repository.model.Country;
import by.seledtsovaos.departure.service.converter.CountryConverter;
import by.seledtsovaos.departure.service.dto.CountryDto;
import by.seledtsovaos.departure.service.exception.ServiceException;
import by.seledtsovaos.departure.service.services.CountryService;

/**
 * Is an implementation of the {@link CountryService} interface.
 */
@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryDao countryDao;
    @Autowired
    private CountryConverter countryConverter;

    @Override
    public List<CountryDto> getAll() {
        try {
            List<Country> countryList = countryDao.findAll();
            List<CountryDto> countryDtoList = new ArrayList<>();
            for (Country country : countryList) {
                countryDtoList.add(countryConverter.convertToDto(country));
            }
            return countryDtoList;
        }
        catch (DaoException e) {
            throw new ServiceException("Not able to get all countries. ", e);
        }
    }

    @Override
    public CountryDto findById(Long id) {
        CountryDto countryDto;
        try {
            Country country = countryDao.findById(id);
            countryDto = countryConverter.convertToDto(country);
            return countryDto;
        }
        catch (DaoException e) {
            throw new ServiceException("Country is not found with id = " + id, e);
        }
    }
}
