package com.fabrick.persistence.model;

import lombok.Getter;
import lombok.Setter;

public class LegalPersonBeneficiary {

    @Getter
    @Setter
    private String fiscalCode;

    @Getter
    @Setter
    private String legalRepresentativeFiscalCode;
}
