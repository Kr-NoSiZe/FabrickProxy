package com.fabrick.persistence.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString()
public class FabrickResponse<T> {
    @Getter
    @Setter
    private String status;

    @Getter
    @Setter
    private List<String> error;

    @Getter
    @Setter
    private T payload;

    public FabrickResponse() {
        this.error = new ArrayList<>();
    }








}
