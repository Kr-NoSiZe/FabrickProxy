package com.fabrick.persistence.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class Type {
    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    private OperationType enumeration;

    @Getter
    @Setter
    private String value;

    public Type() {
    }
}