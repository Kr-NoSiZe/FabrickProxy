package com.fabrick.persistence.model;

import lombok.Getter;
import lombok.Setter;

public class Amount {
    @Getter
    @Setter
    private int debtorAmount;
    @Getter
    @Setter
    private String debtorCurrency;
    @Getter
    @Setter
    private int creditorAmount;
    @Getter
    @Setter
    private String creditorCurrency;
    @Getter
    @Setter
    private String creditorCurrencyDate;
    @Getter
    @Setter
    private int exchangeRate;
}
