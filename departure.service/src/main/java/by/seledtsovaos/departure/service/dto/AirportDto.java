package by.seledtsovaos.departure.service.dto;

import java.util.Objects;

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
    private CountryDto country;

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

    public CountryDto getCountry() {
        return country;
    }

    public void setCountry(CountryDto country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "AirportDto{" +
            "airportId=" + airportId +
            ", airportName='" + airportName + '\'' +
            ", countryDto=" + country +
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
            && Objects.equals(country, that.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(airportId, airportName, country);
    }
}
