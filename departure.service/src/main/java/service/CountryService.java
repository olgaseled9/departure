package service;

import java.util.List;

import by.seledtsovaos.departure.service.dto.CountryDto;
import by.seledtsovaos.departure.service.exception.ServiceException;

/**
 * Provides the methods to interact with representing {@link CountryDto} data.
 */
public interface CountryService {

    /**
     * Obtains {@link CountryDto} objects collection from data source.
     * @throws ServiceException if impossible to get {@link CountryDto}
     * @return collection of {@link CountryDto} objects
     */
    List<CountryDto> getAll();

    /**
     * Obtains {@link CountryDto} object from database by its ID.
     * @param id ID of specified {@link CountryDto}
     * @throws ServiceException if not in the database specified {@link CountryDto}
     * @return {@link CountryDto} object
     */
    CountryDto findById(Long id);


}
