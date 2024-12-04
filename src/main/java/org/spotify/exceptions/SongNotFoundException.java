package org.spotify.exceptions;

/**
 * Exception thrown when a {@link org.spotify.entities.Song} is not found.
 * <p>
 * This exception is used to indicate that an operation failed because a song
 * with the specified identifier could not be found in the system. It extends
 * {@link RuntimeException}, making it an unchecked exception.
 * </p>
 *
 * @author Mukhammed Lolo
 * @version 1.0
 */
public class SongNotFoundException extends RuntimeException {

    /**
     * Constructs a new {@code SongNotFoundException} with {@code null} as its detail message.
     */
    public SongNotFoundException() {
        super();
    }

    /**
     * Constructs a new {@code SongNotFoundException} with the specified detail message.
     *
     * @param message the detail message
     */
    public SongNotFoundException(String message) {
        super(message);
    }

    /**
     * Constructs a new {@code SongNotFoundException} with the specified detail message
     * and cause.
     *
     * @param message the detail message
     * @param cause the cause of the exception
     */
    public SongNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }


    /**
     * Constructs a new {@code SongNotFoundException} with the specified cause.
     *
     * @param cause the cause of the exception
     */
    public SongNotFoundException(Throwable cause) {
        super(cause);
    }
}
