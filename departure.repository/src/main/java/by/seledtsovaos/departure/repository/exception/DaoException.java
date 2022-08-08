package by.seledtsovaos.departure.repository.exception;

/**
 * Thrown if it is not possible to create a connection to database or perform CRUD operations.
 */
public class DaoException extends RuntimeException {

    /**
     * Constructs a new exception with the specified detail message.
     * @param message describing an exception
     */
    public DaoException(String message, Throwable cause) {
        super(message, cause);
    }
}
