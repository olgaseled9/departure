package by.seledtsovaos.departure.repository.dao.impl;


import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import by.seledtsovaos.departure.repository.dao.PassengerDao;
import by.seledtsovaos.departure.repository.exception.DaoException;
import by.seledtsovaos.departure.repository.model.Passenger;

/**
 * Is an implementation of the {@link PassengerDao} interface.
 */
@Repository
public class PassengerDaoImpl implements PassengerDao {

    private static final Logger LOGGER = Logger.getLogger(PassengerDaoImpl.class.getName());

    private static final String SELECT_ALL_PASSENGERS =
        "SELECT passenger_id , first_name, last_name, patronymic, flight_id FROM passenger";
    private static final String DELETE_PASSENGER = "DELETE FROM passenger WHERE passenger_id = ?";
    private static final String FIND_PASSENGER_BY_ID =
        "SELECT passenger_id , first_name, last_name, patronymic, flight_id FROM passenger WHERE passenger_id = ?";
    private static final String UPDATE_PASSENGER =
        "UPDATE passenger SET first_name = ?, last_name = ?, patronymic = ?, flight_id = ? WHERE passenger_id=?";
    private static final String ADD_PASSENGER =
        "INSERT INTO passenger (first_name, last_name, patronymic, flight_id) VALUES (?,?,?,?)";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public PassengerDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void add(Passenger passenger) {
        try {
            jdbcTemplate.update(ADD_PASSENGER, passenger.getFirstname(), passenger.getLastname(),
                passenger.getPatronymic(), passenger.getFlightId());
            LOGGER.info("Successfully added new passenger : " + passenger);
        }
        catch (DataAccessException e) {
            throw new DaoException("Not able to add passenger : " + passenger, e);
        }
    }

    @Override
    public List<Passenger> findAll() {
        try {
            return jdbcTemplate.query(SELECT_ALL_PASSENGERS, new PassengerMapper());
        }
        catch (DaoException e) {
            throw new DaoException("Not able to get all passengers.", e);
        }
    }

    @Override
    public void deleteById(Long id) {
        try {
            jdbcTemplate.update(DELETE_PASSENGER, id);
            LOGGER.info("Successfully deleted passenger with id = " + id);
        }
        catch (DataAccessException e) {
            throw new DaoException("Cannot be deleted passenger with id = " + id, e);
        }
    }

    @Override
    public void update(Passenger passenger) {
        try {
            jdbcTemplate.update(UPDATE_PASSENGER, passenger.getFirstname(), passenger.getLastname(),
                passenger.getPatronymic(), passenger.getFlightId(), passenger.getPassengerId());
            LOGGER.info("Passenger successfully updated : " + passenger);
        }
        catch (DataAccessException e) {
            throw new DaoException("Can't update passenger : " + passenger, e);
        }
    }

    @Override
    public Passenger findById(Long id) {
        try {
            return jdbcTemplate.queryForObject(FIND_PASSENGER_BY_ID, new PassengerMapper(), id);
        }
        catch (DataAccessException e) {
            throw new DaoException("Passenger not found with id = " + id, e);
        }
    }
}
