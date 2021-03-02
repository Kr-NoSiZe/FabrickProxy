package com.fabrick.persistence.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString()
@JsonIgnoreProperties(ignoreUnknown = true)
public class Balance {
    @Getter
    @Setter
    private String date;

    @Getter
    @Setter
    private String balance;

    @Getter
    @Setter
    private String availableBalance;

    @Getter
    @Setter
    private String currency;
}
