package com.example.alessandrofsouza.santanderapp.domain.model;

import com.google.gson.annotations.Expose;

public class MoreInfoValues {

    @Expose
    public Double fund;

    public Double getFund() {
        return fund;
    }

    public void setFund(Double fund) {
        this.fund = fund;
    }

    @Expose
    public Double CDI;

    public Double getCDI() {
        return CDI;
    }

    public void setCDI(Double CDI) {
        this.CDI = CDI;
    }

}
