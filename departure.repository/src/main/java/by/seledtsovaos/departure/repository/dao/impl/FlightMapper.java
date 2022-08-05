package by.seledtsovaos.departure.repository.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import by.seledtsovaos.departure.repository.model.Flight;

/**
 * Displays the rows of the ResultSet for each row of the object {@link Flight}
 */
public class FlightMapper implements RowMapper<Flight> {

    @Override
    public Flight mapRow(ResultSet resultSet, int i) throws SQLException {
        Flight flight = new Flight();
        flight.setFlightId(resultSet.getLong("flight_id"));
        flight.setFlightNumber(resultSet.getString("flight_number"));
        flight.setAirportId(resultSet.getLong("airport_id"));
        flight.setCountryId(resultSet.getLong("country_id"));
        return flight;
    }
}
