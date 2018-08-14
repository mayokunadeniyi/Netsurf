package com.example.android.netsurf;

public class LogoutResponse {
    private boolean error;
    private String message;

    public LogoutResponse(boolean error, String message) {
        this.error = error;
        this.message = message;
    }

    public boolean isError() {
        return error;
    }

    public String getMessage() {
        return message;
    }
}
