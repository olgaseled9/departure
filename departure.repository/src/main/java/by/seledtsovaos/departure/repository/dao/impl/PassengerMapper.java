package by.seledtsovaos.departure.repository.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import by.seledtsovaos.departure.repository.model.Passenger;

/**
 * Displays the rows of the ResultSet for each row of the object {@link Passenger}
 */
public class PassengerMapper implements RowMapper<Passenger> {

    @Override
    public Passenger mapRow(ResultSet resultSet, int i) throws SQLException {
        Passenger passenger = new Passenger();
        passenger.setPassengerId(resultSet.getLong("passenger_id"));
        passenger.setFirstname(resultSet.getString("first_name"));
        passenger.setLastname(resultSet.getString("last_name"));
        passenger.setPatronymic(resultSet.getString("patronymic"));
        passenger.setFlightId(resultSet.getLong("flight_id"));
        return passenger;
    }
}
