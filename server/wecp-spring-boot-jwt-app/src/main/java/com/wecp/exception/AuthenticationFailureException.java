package com.wecp.exception;

public class AuthenticationFailureException extends Exception {

    public AuthenticationFailureException() {
    }

    public AuthenticationFailureException(String arg0) {
        super(arg0);
    }

    public AuthenticationFailureException(Throwable arg0) {
        super(arg0);
    }

    public AuthenticationFailureException(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }

    public AuthenticationFailureException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
        super(arg0, arg1, arg2, arg3);
    }

}
