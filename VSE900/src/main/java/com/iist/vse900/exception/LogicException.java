package com.iist.vse900.exception;

public class LogicException extends Exception {

    private Object data;

    public LogicException(String message) {
        super(message);
    }

    public LogicException(String message, Object data) {
        super(message);
        this.data = data;
    }
    public Object getData() {
        return data;
    }
}
