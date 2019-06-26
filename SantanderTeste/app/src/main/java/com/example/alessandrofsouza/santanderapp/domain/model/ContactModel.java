package com.example.alessandrofsouza.santanderapp.domain.model;

import java.util.ArrayList;

public class ContactModel {

    //@Expose
    public ArrayList<Cell> cells;

    public ArrayList<Cell> getCells() {
        return cells;
    }

    public void setCells(ArrayList<Cell> cells) {
        this.cells = cells;
    }

}
