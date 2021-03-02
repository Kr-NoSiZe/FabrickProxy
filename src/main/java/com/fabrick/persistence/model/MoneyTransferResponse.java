package com.fabrick.persistence.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Id;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString()
public class MoneyTransferResponse extends MoneyTransfer {
    @Id
    @Getter
    @Setter
    private String moneyTransferId;

    @Getter
    @Setter
    private String status;

    @Getter
    @Setter
    private String direction;

    @Getter
    @Setter
    private User debtor;

    @Getter
    @Setter
    private String cro;

    @Getter
    @Setter
    private String trn;

    @Getter
    @Setter
    private String createdDatetime;

    @Getter
    @Setter
    private String accountedDatetime;

    @Getter
    @Setter
    private String debtorValueDate;

    @Getter
    @Setter
    private String creditorValueDate;

    @Getter
    @Setter
    private Amount amount;

    @Getter
    @Setter
    private List<Fees> fees;

    @Getter
    @Setter
    private Boolean hasTaxRelief;
}

