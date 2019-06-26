package com.example.alessandrofsouza.santanderapp.presentation.pages.investment;

import com.example.alessandrofsouza.santanderapp.domain.model.Screen;
import com.example.alessandrofsouza.santanderapp.presentation.pages.base.BasePresenter;
import com.example.alessandrofsouza.santanderapp.presentation.pages.base.BaseView;

public interface InvestmentContract {

    interface View extends BaseView<Presenter> {
        void showInvestmentScreen(Screen screen);
    }

    interface Presenter extends BasePresenter {
        void getInvestmentScreen();
    }

}
