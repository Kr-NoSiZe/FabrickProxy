package com.fabrick.persistence.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MoneyTransferRequest extends  MoneyTransfer {

    @Getter
    @Setter
    private String executionDate;

    @Getter
    @Setter
    private int amount;

    @Getter
    @Setter
    private String currency;

    @Getter
    @Setter
    private TaxRelief taxRelief;

    @Getter
    @Setter
    private LegalPersonBeneficiary legalPersonBeneficiary;

}
