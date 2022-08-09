package by.seledtsovaos.departure.repository.dao;


import java.util.List;

import by.seledtsovaos.departure.repository.model.Country;
import by.seledtsovaos.departure.repository.model.CountryValue;

/**
 * Handles the database operation as create, read, update, delete an {@link Country} object.
 */
public interface CountryDao {

    List<Country> findAll();

    Country findById(Long id);

    Country findByName(CountryValue name);

}
