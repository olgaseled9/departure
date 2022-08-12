package by.seledtsovaos.departure.service.dto;

import java.util.Objects;

/**
 * Container for PassengerDto representing data, getter and setter methods.
 * @see PassengerDto
 */
public class PassengerDto {

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
     * Flight
     */
    private Long flightId;


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

    public Long getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(Long passengerId) {
        this.passengerId = passengerId;
    }

    /**
     * Checks if an object is new.
     * @return true, if object is new
     */
    public boolean isNew() {
        return this.getPassengerId() == null;
    }

    @Override
    public String toString() {
        return "PassengerDto{" +
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
        PassengerDto that = (PassengerDto) o;
        return Objects.equals(passengerId, that.passengerId)
            && Objects.equals(firstname, that.firstname)
            && Objects.equals(lastname, that.lastname)
            && Objects.equals(patronymic, that.patronymic)
            && Objects.equals(flightId, that.flightId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passengerId, firstname, lastname, patronymic, flightId);
    }
}
