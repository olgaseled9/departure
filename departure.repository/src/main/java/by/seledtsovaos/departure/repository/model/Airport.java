package by.seledtsovaos.departure.repository.model;

import java.util.Objects;

/**
 * Container for Airport entity data, getter and setter methods.
 * @see Airport
 */
public class Airport {

    private Long airportId;
    private String airportName;
    private Long countryId;

    public Airport() {
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

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    @Override
    public String toString() {
        return "Airport{" +
            "airportId=" + airportId +
            ", airportName='" + airportName + '\'' +
            ", countryId=" + countryId +
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
        Airport airport = (Airport) o;
        return Objects.equals(airportId, airport.airportId) && Objects.equals(airportName, airport.airportName) && Objects.equals(countryId, airport.countryId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(airportId, airportName, countryId);
    }
}
