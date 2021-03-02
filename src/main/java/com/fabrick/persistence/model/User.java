package com.fabrick.persistence.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString()
public class User {

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private Account account;

    @Getter
    @Setter
    private Address address;
}
