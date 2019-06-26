package com.example.alessandrofsouza.santanderapp.domain.model;

import com.google.gson.annotations.Expose;

public class Infos {

    @Expose
    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Expose
    public String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }



    public String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Infos(String sTitle, String sName, String sData) {
        title = sTitle;
        name = sName;
        data = sData;
    }

}
