package com.fabrick.persistence.model;

import lombok.Getter;
import lombok.Setter;

public class MoneyTransfer {


    @Getter
    @Setter
    private User creditor;

    @Getter
    @Setter
    private String uri;
    @Getter
    @Setter
    private String description;
    @Getter
    @Setter
    private Boolean isUrgent;
    @Getter
    @Setter
    private Boolean isInstant;
    @Getter
    @Setter
    private String feeType;
    @Getter
    @Setter
    private String feeAccountId;
}
