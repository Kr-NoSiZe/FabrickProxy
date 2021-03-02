package com.fabrick.persistence.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Id;

@ToString()
public class Fees {
    @Id
    @Getter
    @Setter
    private String feeCode;

    @Getter
    @Setter
    private String description;

    @Getter
    @Setter
    private String amount;

    @Getter
    @Setter
    private String currency;
}
