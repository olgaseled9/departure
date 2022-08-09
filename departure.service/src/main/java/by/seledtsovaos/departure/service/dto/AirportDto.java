package by.seledtsovaos.departure.service.dto;

import java.util.Objects;

import by.seledtsovaos.departure.repository.model.CountryValue;

/**
 * Container for AirportDto representing data, getter and setter methods.
 * @see AirportDto
 */
public class AirportDto {

    /**
     * Airport's id
     */
    private Long airportId;
    /**
     * Airport's name
     */
    private String airportName;
    /**
     * Country of airport's location
     */
    private CountryValue country;

    public AirportDto() {
    }

    public Long getAirportId() {
        return airportId;
    }

    public void setAirportId(Long airportId) {
        this.airportId = airportId;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public CountryValue getCountry() {
        return country;
    }

    public void setCountry(CountryValue country) {
        this.country = country;
    }

    /**
     * Checks if an object is new.
     * @return true, if object is new
     */
    public boolean isNew() {
        return this.getAirportId() == null;
    }


    @Override
    public String toString() {
        return "AirportDto{" +
            "airportId=" + airportId +
            ", airportName='" + airportName + '\'' +
            ", country=" + country +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AirportDto that = (AirportDto) o;
        return Objects.equals(airportId, that.airportId)
            && Objects.equals(airportName, that.airportName)
            && country == that.country;
    }

    @Override
    public int hashCode() {
        return Objects.hash(airportId, airportName, country);
    }
}
