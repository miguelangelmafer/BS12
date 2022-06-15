package com.bosonit.EJ3.Person.Exceptions;

import java.util.Date;

public class CustomError {
    private Date timestamp;

    private Integer HttpCode;
    private String mensaje;



    public CustomError(Date timestamp, Integer HttpCode,String message) {
        super();
        this.timestamp = timestamp;
        this.HttpCode=HttpCode;
        this.mensaje = message;
    }

    public Integer getHttpCode() {
        return HttpCode;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMensaje() {
        return mensaje;
    }


}

