package com.fabrick.persistence.model;

import lombok.Getter;
import lombok.Setter;

public class TaxRelief {
    @Getter
    @Setter
    private String taxReliefId;
    @Getter
    @Setter
    private Boolean isCondoUpgrade;
    @Getter
    @Setter
    private String creditorFiscalCode;
    @Getter
    @Setter
    private String beneficiaryType;
    @Getter
    @Setter
    private NaturalPersonBeneficiary naturalPersonBeneficiary;

}
