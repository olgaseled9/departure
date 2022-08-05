package by.seledtsovaos.departure.repository.model;

import java.util.Objects;

/**
 * Container for Flight entity data, getter and setter methods.
 * @see Flight
 */
public class Flight {

    private Long flightId;
    private String flightNumber;
    private Long airportId;
    private Long countryId;

    public Flight() {
    }

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Long getAirportId() {
        return airportId;
    }

    public void setAirportId(Long airportId) {
        this.airportId = airportId;
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    @Override
    public String toString() {
        return "Flight{" +
            "flightId=" + flightId +
            ", flightNumber='" + flightNumber + '\'' +
            ", airportId=" + airportId +
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
        Flight flight = (Flight) o;
        return Objects.equals(flightId, flight.flightId) && Objects.equals(flightNumber, flight.flightNumber) && Objects.equals(airportId, flight.airportId) && Objects.equals(countryId, flight.countryId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flightId, flightNumber, airportId, countryId);
    }
}


