package by.seledtsovaos.departure.service.dto;

import java.util.Objects;

import by.seledtsovaos.departure.repository.model.CountryValue;

/**
 * Container for FlightDto representing data, getter and setter methods.
 * @see FlightDto
 */
public class FlightDto {

    /**
     * Flight's id
     */
    private Long flightId;
    /**
     * Flight's number
     */
    private String flightNumber;
    /**
     * Airport
     */
    private Long airportId;
    /**
     * Country
     */
    private CountryValue country;

    public FlightDto() {
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

    public CountryValue getCountry() {
        return country;
    }

    public void setCountry(CountryValue country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "FlightDto{" +
            "flightId=" + flightId +
            ", flightNumber='" + flightNumber + '\'' +
            ", airportId=" + airportId +
            ", country=" + country +
            '}';
    }

    /**
     * Checks if an object is new.
     * @return true, if object is new
     */
    public boolean isNew() {
        return this.getFlightId() == null;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FlightDto flightDto = (FlightDto) o;
        return Objects.equals(flightId, flightDto.flightId)
            && Objects.equals(flightNumber, flightDto.flightNumber)
            && Objects.equals(airportId, flightDto.airportId)
            && country == flightDto.country;
    }

    @Override
    public int hashCode() {
        return Objects.hash(flightId, flightNumber, airportId, country);
    }
}
