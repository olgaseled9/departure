package by.seledtsovaos.departure.service.dto;

import java.util.Objects;

import by.seledtsovaos.departure.repository.model.CountryValue;

/**
 * Container for CountryDto representing data, getter and setter methods.
 * @see CountryDto
 */
public class CountryDto {

    /**
     * Country's id;
     */
    private Long countryId;
    /**
     * Country's name;
     */
    private CountryValue name;

    public CountryDto() {
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public CountryValue getName() {
        return name;
    }

    public void setName(CountryValue name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CountryDto{" +
            "countryId=" + countryId +
            ", name=" + name +
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
        CountryDto that = (CountryDto) o;
        return Objects.equals(countryId, that.countryId) && name == that.name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryId, name);
    }
}
