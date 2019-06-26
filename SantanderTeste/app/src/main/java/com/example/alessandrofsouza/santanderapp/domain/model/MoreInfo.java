package com.example.alessandrofsouza.santanderapp.domain.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MoreInfo {

    @Expose
    public MoreInfoValues month;

    public MoreInfoValues getMonth() {
        return month;
    }

    public void setMonth(MoreInfoValues month) {
        this.month = month;
    }


    @Expose
    public MoreInfoValues year;

    public MoreInfoValues getYear() {
        return year;
    }

    public void setYear(MoreInfoValues year) {
        this.year = year;
    }


    @SerializedName("12months")
    @Expose
    public MoreInfoValues months12;

    public MoreInfoValues getMonths12() {
        return months12;
    }

    public void setMonths12(MoreInfoValues months12) {
        this.months12 = months12;
    }

}
