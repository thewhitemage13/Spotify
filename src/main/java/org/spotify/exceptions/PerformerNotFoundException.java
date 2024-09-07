package org.spotify.exceptions;

public class PerformerNotFoundException extends RuntimeException {

    public PerformerNotFoundException() {
        super();
    }

    public PerformerNotFoundException(String message) {
        super(message);
    }

    public PerformerNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public PerformerNotFoundException(Throwable cause) {
        super(cause);
    }
}
