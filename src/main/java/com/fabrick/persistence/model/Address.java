package com.fabrick.persistence.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString()
public class Address {

    @Getter
    @Setter
    private String address;

    @Getter
    @Setter
    private String city;

    @Getter
    @Setter
    private String countryCode;
}

