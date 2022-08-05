package by.seledtsovaos.departure.repository.model;

import java.util.Objects;

/**
 * Container for Country entity data, getter and setter methods.
 * @see Country
 */
public class Country {

    /**
     * Country's id;
     */
    private Long countryId;
    /**
     * Country's name;
     */
    private CountryValue name;

    public Country() {
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
        return "Country{" +
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
        Country country = (Country) o;
        return Objects.equals(countryId, country.countryId) && name == country.name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryId, name);
    }
}
