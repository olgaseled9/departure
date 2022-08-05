package by.seledtsovaos.departure.repository.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import by.seledtsovaos.departure.repository.dao.CountryDao;
import by.seledtsovaos.departure.repository.exception.DaoException;
import by.seledtsovaos.departure.repository.model.Country;
import by.seledtsovaos.departure.repository.model.CountryValue;

/**
 * Is an implementation of the {@link CountryDao} interface.
 */
@Repository
public class CountryDaoImpl implements CountryDao {

    private static final String SELECT_ALL_COUNTRIES =
        "SELECT country_id , country_name FROM country";
    private static final String FIND_COUNTRY_BY_ID =
        "SELECT country_id , country_name FROM country WHERE country_id = ?";
    private static final String FIND_COUNTRY_BY_NAME =
        "SELECT country_id , country_name FROM country WHERE country_name = ?";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CountryDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Country> findAll() {
        try {
            return jdbcTemplate.query(SELECT_ALL_COUNTRIES, new CountryMapper());
        }
        catch (DaoException e) {
            throw new DaoException("Not able to get all countries.", e);
        }
    }

    @Override
    public Country findById(Long id) {
        try {
            return jdbcTemplate.queryForObject(FIND_COUNTRY_BY_ID, new CountryMapper(), id);
        }
        catch (DataAccessException e) {
            throw new DaoException("Country not found with id = " + id, e);
        }
    }

    @Override
    public Country findCountryByName(CountryValue value) {
        try {
            return jdbcTemplate.queryForObject(FIND_COUNTRY_BY_NAME, new CountryMapper(), value.name());
        }
        catch (DataAccessException e) {
            throw new DaoException("Country not found with name = " + value, e);
        }
    }
}

