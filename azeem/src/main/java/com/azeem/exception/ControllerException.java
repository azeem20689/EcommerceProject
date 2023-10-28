package com.azeem.exception;

public class ControllerException extends RuntimeException{
    public ControllerException(){
        super("Controller Exception Occured");
    }

    public ControllerException(String message){
        super(message);
    }
}
