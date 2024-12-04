package org.spotify.exceptions;

/**
 * Exception thrown when a {@link org.spotify.entities.MusicCollection} is not found in the database.
 * <p>
 * This exception is used to signal that a {@code MusicCollection} entity could not be found
 * during database operations such as searching or retrieving by ID. It extends {@link RuntimeException},
 * allowing for unchecked exceptions that do not require explicit handling in the calling code.
 * </p>
 *
 * @author Mukhammed Lolo
 * @version 1.0
 */
public class MusicCollectionNotFoundException extends RuntimeException {

    /**
     * Constructs a new {@code MusicCollectionNotFoundException} with {@code null} as its detail message.
     */
    public MusicCollectionNotFoundException() {
        super();
    }

    /**
     * Constructs a new {@code MusicCollectionNotFoundException} with the specified detail message.
     *
     * @param message the detail message
     */
    public MusicCollectionNotFoundException(String message) {
        super(message);
    }

    /**
     * Constructs a new {@code MusicCollectionNotFoundException} with the specified detail message
     * and cause.
     *
     * @param message the detail message
     * @param cause the cause of the exception
     */
    public MusicCollectionNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new {@code MusicCollectionNotFoundException} with the specified cause.
     *
     * @param cause the cause of the exception
     */
    public MusicCollectionNotFoundException(Throwable cause) {
        super(cause);
    }
}
