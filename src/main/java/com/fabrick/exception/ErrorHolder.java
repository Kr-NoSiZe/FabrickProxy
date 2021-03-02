package com.fabrick.exception;

import lombok.Getter;
import lombok.Setter;

public class ErrorHolder {

    @Getter @Setter
    private String code;
    @Getter @Setter
    private String description;

    public ErrorHolder(){
        super();
    }
    public ErrorHolder(String code , String description){
        this.code=code;
        this.description=description;
    }
}


