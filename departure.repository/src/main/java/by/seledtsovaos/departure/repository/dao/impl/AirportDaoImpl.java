package by.seledtsovaos.departure.repository.dao.impl;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import by.seledtsovaos.departure.repository.dao.AirportDao;
import by.seledtsovaos.departure.repository.exception.DaoException;
import by.seledtsovaos.departure.repository.model.Airport;

/**
 * Is an implementation of the {@link AirportDao} interface.
 */
@Repository
public class AirportDaoImpl implements AirportDao {

    private static final Logger LOGGER = Logger.getLogger(AirportDaoImpl.class.getName());

    private static final String SELECT_ALL_AIRPORTS =
        "SELECT airport_id , airport_name, country_id FROM airport";
    private static final String DELETE_AIRPORT = "DELETE FROM airport WHERE airport_id = ?";
    private static final String FIND_AIRPORT_BY_ID =
        "SELECT airport_id , airport_name, country_id FROM airport WHERE airport_id = ?";
    private static final String UPDATE_AIRPORT =
        "UPDATE airport SET airport_name = ?, country_id = ? WHERE airport_id=?";
    private static final String ADD_AIRPORT =
        "INSERT INTO airport ( airport_name, country_id) VALUES (?,?)";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public AirportDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void add(Airport airport) {
        try {
            jdbcTemplate.update(ADD_AIRPORT, airport.getAirportName(), airport.getCountryId());
            LOGGER.info("Successfully added new airport : " + airport);
        }
        catch (DataAccessException e) {
            throw new DaoException("Not able to add airport : " + airport, e);
        }
    }

    @Override
    public List<Airport> findAll() {
        List<Airport> airports;
        try {
            airports = jdbcTemplate.query(SELECT_ALL_AIRPORTS, new AirportMapper());
            return airports;
        }
        catch (DaoException e) {
            throw new DaoException("Not able to get all airports.", e);
        }
    }

    @Override
    public void delete(Long id) {
        try {
            jdbcTemplate.update(DELETE_AIRPORT, id);
            LOGGER.info("Successfully deleted airport with id = " + id);
        }
        catch (DataAccessException e) {
            throw new DaoException("Cannot be deleted airport with id = " + id, e);
        }
    }

    @Override
    public Airport findById(Long id) {
        try {
            return jdbcTemplate.queryForObject(FIND_AIRPORT_BY_ID, new AirportMapper(), id);
        }
        catch (DataAccessException e) {
            throw new DaoException("Airport not found with id = " + id, e);
        }
    }

    @Override
    public void update(Airport airport) {
        try {
            jdbcTemplate.update(UPDATE_AIRPORT, airport.getAirportName(), airport.getCountryId(),
                airport.getAirportId());
            LOGGER.info("Airport successfully updated : " + airport);
        }
        catch (DataAccessException e) {
            throw new DaoException("Can't update airport : " + airport, e);
        }
    }
}
