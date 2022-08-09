package by.seledtsovaos.departure.service.dto;

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
    private FlightDto flight;


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

    public FlightDto getFlight() {
        return flight;
    }

    public void setFlight(FlightDto flight) {
        this.flight = flight;
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
            ", flight=" + flight +
            '}';
    }

    public Long getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(Long passengerId) {
        this.passengerId = passengerId;
    }
}
