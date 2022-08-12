package by.seledtsovaos.departure.repository.dao.impl;


import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import by.seledtsovaos.departure.repository.dao.FlightDao;
import by.seledtsovaos.departure.repository.exception.DaoException;
import by.seledtsovaos.departure.repository.model.Flight;

/**
 * Is an implementation of the {@link FlightDao} interface.
 */
@Repository
public class FlightDaoImpl implements FlightDao {

    private static final Logger LOGGER = Logger.getLogger(FlightDaoImpl.class.getName());

    private static final String SELECT_ALL_FLIGHTS =
        "SELECT flight_id , flight_number, airport_id, country_id FROM flight";
    private static final String DELETE_FLIGHT = "DELETE FROM flight WHERE flight_id = ?";
    private static final String FIND_FLIGHT_BY_ID =
        "SELECT flight_id , flight_number, airport_id, country_id FROM flight WHERE flight_id = ?";
    private static final String UPDATE_FLIGHT =
        "UPDATE flight SET flight_number = ?, airport_id = ?, country_id = ? WHERE flight_id = ?";
    private static final String ADD_FLIGHT =
        "INSERT INTO flight (flight_number, airport_id, country_id) VALUES (?,?,?)";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public FlightDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void add(Flight flight) {
        try {
            jdbcTemplate.update(ADD_FLIGHT, flight.getFlightNumber(), flight.getAirportId(), flight.getCountryId());
            LOGGER.info("Successfully added new flight : " + flight);
        }
        catch (DataAccessException e) {
            throw new DaoException("Not able to add flight : " + flight, e);
        }
    }

    @Override
    public List<Flight> findAll() {
        try {
            return jdbcTemplate.query(SELECT_ALL_FLIGHTS, new FlightMapper());
        }
        catch (DaoException e) {
            throw new DaoException("Not able to get all flights.", e);
        }
    }

    @Override
    public void deleteById(Long id) {
        try {
            jdbcTemplate.update(DELETE_FLIGHT, id);
            LOGGER.info("Successfully deleted flight with id = " + id);
        }
        catch (DataAccessException e) {
            throw new DaoException("Cannot be deleted flight with id = " + id, e);
        }
    }

    @Override
    public void update(Flight flight) {
        try {
            jdbcTemplate.update(UPDATE_FLIGHT, flight.getFlightNumber(), flight.getCountryId(),
                flight.getAirportId(), flight.getFlightId());
            LOGGER.info("Flight successfully updated : " + flight);
        }
        catch (DataAccessException e) {
            throw new DaoException("Can't update flight : " + flight, e);
        }
    }

    @Override
    public Flight findById(Long id) {
        try {
            return jdbcTemplate.queryForObject(FIND_FLIGHT_BY_ID, new FlightMapper(), id);
        }
        catch (DataAccessException e) {
            throw new DaoException("Flight not found with id = " + id, e);
        }
    }
}
