package by.seledtsovaos.departure.repository.dao;


import java.util.List;

import by.seledtsovaos.departure.repository.model.Country;

/**
 * Handles the database operation as create, read, update, delete an {@link Country} object.
 */
public interface CountryDao {

    List<Country> findAll();

    Country findById(Long id);

}
