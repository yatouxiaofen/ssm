package com.susu.ssm.exception;

/**
 *
 */
public class UnloginException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public UnloginException() {
        super();
    }

    public UnloginException(String message) {
        super(message);
    }

    public UnloginException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnloginException(Throwable cause) {
        super(cause);
    }

    protected UnloginException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
