package com.azeem.exception;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.message.Message;
import org.springframework.stereotype.Component;

@Component
public class ControllerException extends RuntimeException {

    private String errocode;

    public ControllerException() {
        super("UserDefined Exception Occured ..!!");
    }

    public ControllerException(String message) {
        super(message);
    }

    public ControllerException(String message, String errorcode) {
        super(message);
        this.errocode = errorcode;
    }

    public String getErrocode(){
        return this.errocode;
    }


}
