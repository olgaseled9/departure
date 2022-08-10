package by.seledtsovaos.departure.service.dto;

import java.util.Objects;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

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
    @NotNull
    @NotEmpty
    @Size(min = 1, max = 40)
    @Pattern(regexp = "[A-Za-zА-Яа-яЁё\\s-]*", message = "You can use the Latin and Russian alphabet.")
    private String firstname;
    /**
     * Passenger lastname
     */
    @NotNull
    @NotEmpty
    @Size(min = 1, max = 40)
    @Pattern(regexp = "[A-Za-zА-Яа-яЁё\\s-]*", message = "You can use the Latin and Russian alphabet.")
    private String lastname;
    /**
     * Passenger patronymic
     */
    @NotNull
    @NotEmpty
    @Size(min = 1, max = 40)
    @Pattern(regexp = "[A-Za-zА-Яа-яЁё\\s-]*", message = "You can use the Latin and Russian alphabet.")
    private String patronymic;
    /**
     * Flight
     */
    @NotNull
    @NotEmpty
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
