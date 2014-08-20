package net.hanney.minion.service;

/**
 * {@link Exception} that is thrown when a user fails authentication
 *
 * @author justin.hanney
 */
public class AuthenticationException extends Exception {

    private static final long serialVersionUID = 1L;

    public AuthenticationException() {
        super();
    }

    public AuthenticationException(final String message) {
        super(message);
    }

}
