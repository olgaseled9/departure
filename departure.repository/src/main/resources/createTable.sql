/**
 * Creates a table country.
 * @param country_id country's id, which auto-generated as a unique identifier for the record
 * @param country_name country's name
 */
CREATE TABLE country
(
    country_id   BIGINT       NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START with 1 INCREMENT by 1),
    country_name VARCHAR(100) NOT NULL
);
/**
 * Creates a table airport.
 * @param airport_id airport's id, which auto-generated as a unique identifier for the record
 * @param airport_name airport's name
 * @param country_id country's id
 */
CREATE TABLE airport
(
    airport_id   BIGINT       NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START with 1 INCREMENT by 1),
    airport_name VARCHAR(100) NOT NULL,
    country_id   BIGINT       NOT NULL,
    FOREIGN KEY (country_id) REFERENCES country (country_id)
);

/**
 * Creates a table flight.
 * @param flight_id flight's id, which auto-generated as a unique identifier for the record
 * @param flight_number flight's number
 * @param airport_id airport's id
 * @param country_id country's id
 */
CREATE TABLE flight
(
    flight_id     BIGINT       NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START with 1 INCREMENT by 1),
    flight_number VARCHAR(100) NOT NULL,
    airport_id    BIGINT       NOT NULL,
    country_id    BIGINT       NOT NULL,
    FOREIGN KEY (country_id) REFERENCES country (country_id),
    FOREIGN KEY (airport_id) REFERENCES airport (airport_id)
);

INSERT INTO country (country_name)
VALUES (('RUSSIA'),
        ('BELARUS'),
        ('TURKEY'),
        ('EGYPT'));

/**
 * Creates a table of passengers.
 * @param passenger_id passenger's id, which auto-generated as a unique identifier for the record
 * @param first_name passenger's first name
 * @param last_name passenger's last name
 * @param patronymic passenger's patronymic
 * @param flight_id passenger's flight's number
 */
CREATE TABLE passenger
(
    passenger_id BIGINT      NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START with 1 INCREMENT by 1),
    first_name   VARCHAR(50) NOT NULL,
    last_name    VARCHAR(50) NOT NULL,
    patronymic   VARCHAR(50) NOT NULL,
    flight_id    BIGINT      NOT NULL,
    FOREIGN KEY (flight_id) REFERENCES flight (flight_id)
);




