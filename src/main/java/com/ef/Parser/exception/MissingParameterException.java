package com.ef.Parser.exception;

public class MissingParameterException  extends Exception{

    private static final long serialVersionUID = -5106708684524029184L;

    public MissingParameterException() {
        super();
    }

    public MissingParameterException(String parameter) {
        super("Incorrect param: " + parameter);
    }
}
