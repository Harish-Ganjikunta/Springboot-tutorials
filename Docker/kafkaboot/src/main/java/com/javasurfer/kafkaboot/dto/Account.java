package com.javasurfer.kafkaboot.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Account {

    private String holder;
    private String funds;

    public Account() {
    }

    public Account(@JsonProperty String holder, @JsonProperty String funds) {
        this.holder = holder;
        this.funds = funds;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public String getFunds() {
        return funds;
    }

    public void setFunds(String funds) {
        this.funds = funds;
    }

    @Override
    public String toString() {
        return "Account{" +
                "holder='" + holder + '\'' +
                ", funds='" + funds + '\'' +
                '}';
    }
}
