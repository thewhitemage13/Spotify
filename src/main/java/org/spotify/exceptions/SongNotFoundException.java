package org.spotify.exceptions;

public class SongNotFoundException extends RuntimeException {

    public SongNotFoundException() {
        super();
    }

    public SongNotFoundException(String message) {
        super(message);
    }

    public SongNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public SongNotFoundException(Throwable cause) {
        super(cause);
    }
}
