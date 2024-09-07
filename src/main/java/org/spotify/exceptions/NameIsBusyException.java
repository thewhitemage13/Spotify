package org.spotify.exceptions;

public class NameIsBusyException extends RuntimeException{
    public NameIsBusyException() {
        super();
    }

    public NameIsBusyException(String message) {
        super(message);
    }

    public NameIsBusyException(String message, Throwable cause) {
        super(message, cause);
    }

    public NameIsBusyException(Throwable cause) {
        super(cause);
    }
}
