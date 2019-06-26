package com.example.alessandrofsouza.santanderapp.presentation.pages.contact;

import com.example.alessandrofsouza.santanderapp.domain.model.Cell;
import com.example.alessandrofsouza.santanderapp.presentation.pages.base.BasePresenter;
import com.example.alessandrofsouza.santanderapp.presentation.pages.base.BaseView;

import java.util.ArrayList;

public interface ContactContract {

    interface View extends BaseView<Presenter> {
        void showContactCells(ArrayList<Cell> cellList);
    }

    interface Presenter extends BasePresenter {
        void getContactCells();
    }

}
