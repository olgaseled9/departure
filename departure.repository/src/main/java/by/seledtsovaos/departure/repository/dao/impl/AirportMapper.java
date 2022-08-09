package by.seledtsovaos.departure.repository.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import by.seledtsovaos.departure.repository.model.Airport;

/**
 * Displays the rows of the ResultSet for each row of the object {@link Airport}
 */
public class AirportMapper implements RowMapper<Airport> {

    @Override
    public Airport mapRow(ResultSet resultSet, int i) throws SQLException {
        Airport airport = new Airport();
        airport.setAirportId(resultSet.getLong("airport_id"));
        airport.setAirportName(resultSet.getString("airport_name"));
        airport.setCountryId(resultSet.getLong("country_id"));
        return airport;
    }
}
