package com.fabrick.persistence.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.util.List;

public class ElementList<T> {

    @Column(nullable = false, unique = true)
    @Getter
    @Setter
    private List<T> list;

}
