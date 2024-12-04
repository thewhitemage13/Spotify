package org.spotify.exceptions;

/**
 * Exception thrown when a {@link org.spotify.entities.Performer} is not found.
 * <p>
 * This exception is used to signal that an operation failed because a performer
 * with the specified identifier could not be found in the system. It extends
 * {@link RuntimeException}, making it an unchecked exception.
 * </p>
 *
 * @author Mukhammed Lolo
 * @version 1.0
 */
public class PerformerNotFoundException extends RuntimeException {

    /**
     * Constructs a new {@code PerformerNotFoundException} with {@code null} as its detail message.
     */
    public PerformerNotFoundException() {
        super();
    }

    /**
     * Constructs a new {@code PerformerNotFoundException} with the specified detail message.
     *
     * @param message the detail message
     */
    public PerformerNotFoundException(String message) {
        super(message);
    }

    /**
     * Constructs a new {@code PerformerNotFoundException} with the specified detail message
     * and cause.
     *
     * @param message the detail message
     * @param cause the cause of the exception
     */
    public PerformerNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new {@code PerformerNotFoundException} with the specified cause.
     *
     * @param cause the cause of the exception
     */
    public PerformerNotFoundException(Throwable cause) {
        super(cause);
    }
}
