package com.fabrick.persistence.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.math.BigDecimal;

@Entity
@ToString()
public class Transaction {

    @Id
    @Getter
    @Setter
    private String transactionId;

    @Getter
    @Setter
    private String operationId;

    @Getter
    @Setter
    private String accountingDate;

    @Getter
    @Setter
    private String valueDate;

    @Getter
    @Setter
    private BigDecimal amount;

    @Getter
    @Setter
    @Transient
    private Type type;

    @Getter
    @Setter
    private String currency;

    @Getter
    @Setter
    private String description;
}
