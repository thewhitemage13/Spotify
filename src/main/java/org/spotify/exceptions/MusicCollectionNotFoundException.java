package org.spotify.exceptions;

public class MusicCollectionNotFoundException extends RuntimeException {

    public MusicCollectionNotFoundException() {
        super();
    }

    public MusicCollectionNotFoundException(String message) {
        super(message);
    }

    public MusicCollectionNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public MusicCollectionNotFoundException(Throwable cause) {
        super(cause);
    }
}
