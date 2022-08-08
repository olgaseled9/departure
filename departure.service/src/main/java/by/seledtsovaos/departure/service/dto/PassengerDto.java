package by.seledtsovaos.departure.service.dto;

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
