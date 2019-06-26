package com.example.alessandrofsouza.santanderapp.domain.model;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;

public class Screen {

    @Expose
    public String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    @Expose
    public String fundName;

    public String getFundName() {
        return fundName;
    }

    public void setFundName(String fundName) {
        this.fundName = fundName;
    }


    @Expose
    public String whatIs;

    public String getWhatIs() {
        return whatIs;
    }

    public void setWhatIs(String whatIs) {
        this.whatIs = whatIs;
    }


    @Expose
    public String definition;

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }


    @Expose
    public String riskTitle;

    public String getRiskTitle() {
        return riskTitle;
    }

    public void setRiskTitle(String riskTitle) {
        this.riskTitle = riskTitle;
    }


    @Expose
    public int risk;

    public int getRisk() {
        return risk;
    }

    public void setRisk(int risk) {
        this.risk = risk;
    }


    @Expose
    public String infoTitle;

    public String getInfoTitle() {
        return infoTitle;
    }

    public void setInfoTitle(String infoTitle) {
        this.infoTitle = infoTitle;
    }


    @Expose
    public MoreInfo moreInfo;

    public MoreInfo getMoreInfo() {
        return moreInfo;
    }

    public void setMoreInfo(MoreInfo moreInfo) {
        this.moreInfo = moreInfo;
    }


    @Expose
    public ArrayList<Infos> info;

    public ArrayList<Infos> getInfo() {
        return info;
    }

    public void setInfo(ArrayList<Infos> info) {
        this.info = info;
    }


    @Expose
    public ArrayList<Infos> downInfo;

    public ArrayList<Infos> getDownInfo() {
        return downInfo;
    }

    public void setDownInfo(ArrayList<Infos> downInfo) {
        this.downInfo = downInfo;
    }

}
