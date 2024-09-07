package org.spotify.exceptions;

public class RadioNotFoundException extends RuntimeException {

    public RadioNotFoundException() {
        super();
    }

    public RadioNotFoundException(String message) {
        super(message);
    }

    public RadioNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public RadioNotFoundException(Throwable cause) {
        super(cause);
    }
}
