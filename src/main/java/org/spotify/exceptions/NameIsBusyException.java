package org.spotify.exceptions;

/**
 * Exception thrown when an entity's name is already in use or taken.
 * <p>
 * This exception is used to indicate that an operation failed because the name
 * of a {@link org.spotify.entities.MusicCollection} or other entity already exists in the system.
 * It extends {@link RuntimeException}, making it an unchecked exception.
 * </p>
 *
 * @author Mukhammed Lolo
 * @version 1.0
 */
public class NameIsBusyException extends RuntimeException{

    /**
     * Constructs a new {@code NameIsBusyException} with {@code null} as its detail message.
     */
    public NameIsBusyException() {
        super();
    }

    /**
     * Constructs a new {@code NameIsBusyException} with the specified detail message.
     *
     * @param message the detail message
     */
    public NameIsBusyException(String message) {
        super(message);
    }

    /**
     * Constructs a new {@code NameIsBusyException} with the specified detail message
     * and cause.
     *
     * @param message the detail message
     * @param cause the cause of the exception
     */
    public NameIsBusyException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new {@code NameIsBusyException} with the specified cause.
     *
     * @param cause the cause of the exception
     */
    public NameIsBusyException(Throwable cause) {
        super(cause);
    }
}
