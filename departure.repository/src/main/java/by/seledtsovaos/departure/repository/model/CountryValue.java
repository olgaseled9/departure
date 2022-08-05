package by.seledtsovaos.departure.repository.model;

/**
 * Country to fly to
 * @see CountryValue
 */
public enum CountryValue {

    RUSSIA("Russia"),
    BELARUS("Belarus"),
    TURKEY("Turkey"),
    EGYPT("Egypt");

    /**
     * Put  label to country.
     */
    private final String label;


    /**
     * Constructor to create a new object of class with specific values.
     * @param label country's value
     * @see CountryValue
     */
    CountryValue(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }

}
