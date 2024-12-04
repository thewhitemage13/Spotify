package org.spotify.exceptions;

/**
 * Exception thrown when a {@link org.spotify.entities.Radio} is not found.
 * <p>
 * This exception is used to indicate that an operation failed because a radio station
 * with the specified identifier could not be found in the system. It extends
 * {@link RuntimeException}, making it an unchecked exception.
 * </p>
 *
 * @author Mukhammed Lolo
 * @version 1.0
 */
public class RadioNotFoundException extends RuntimeException {

    /**
     * Constructs a new {@code RadioNotFoundException} with {@code null} as its detail message.
     */
    public RadioNotFoundException() {
        super();
    }

    /**
     * Constructs a new {@code RadioNotFoundException} with the specified detail message.
     *
     * @param message the detail message
     */
    public RadioNotFoundException(String message) {
        super(message);
    }

    /**
     * Constructs a new {@code RadioNotFoundException} with the specified detail message
     * and cause.
     *
     * @param message the detail message
     * @param cause the cause of the exception
     */
    public RadioNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new {@code RadioNotFoundException} with the specified cause.
     *
     * @param cause the cause of the exception
     */
    public RadioNotFoundException(Throwable cause) {
        super(cause);
    }
}
