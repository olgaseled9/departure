package by.seledtsovaos.departure.repository.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import by.seledtsovaos.departure.repository.model.Country;
import by.seledtsovaos.departure.repository.model.CountryValue;

/**
 * Displays the rows of the ResultSet for each row of the object {@link Country}
 */
public class CountryMapper implements RowMapper<Country> {

    @Override
    public Country mapRow(ResultSet resultSet, int i) throws SQLException {
        Country country = new Country();
        country.setCountryId(resultSet.getLong("country_id"));
        country.setName(CountryValue.valueOf(resultSet.getString("country_name")));
        return country;
    }
}
