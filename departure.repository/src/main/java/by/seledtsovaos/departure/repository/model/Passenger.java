package by.seledtsovaos.departure.repository.model;

import java.util.Objects;

/**
 * Container for Passenger entity data, getter and setter methods.
 * @see Passenger
 */
public class Passenger {

    /**
     * Passenger's id
     */
    private Long passengerId;
    /**
     * Passenger firstname
     */
    private String firstname;
    /**
     * Passenger lastname
     */
    private String lastname;
    /**
     * Passenger patronymic
     */
    private String patronymic;
    /**
     * Flight's id
     */
    private Long flightId;

    public Passenger() {
    }

    public Long getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(Long passengerId) {
        this.passengerId = passengerId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }

    @Override
    public String toString() {
        return "Passenger{" +
            "passengerId=" + passengerId +
            ", firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            ", patronymic='" + patronymic + '\'' +
            ", flightId=" + flightId +
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
        Passenger passenger = (Passenger) o;
        return Objects.equals(passengerId, passenger.passengerId)
            && Objects.equals(firstname, passenger.firstname)
            && Objects.equals(lastname, passenger.lastname)
            && Objects.equals(patronymic, passenger.patronymic)
            && Objects.equals(flightId, passenger.flightId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passengerId, firstname, lastname, patronymic, flightId);
    }
}
