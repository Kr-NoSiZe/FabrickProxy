package com.fabrick.persistence.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString()
public class Account {

    public Account() { }
    @Id
    @Getter
    @Setter
    private String accountCode;

    @Getter
    @Setter
    private String bicCode;

}