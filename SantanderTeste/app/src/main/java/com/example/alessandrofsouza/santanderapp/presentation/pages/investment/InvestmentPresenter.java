package com.example.alessandrofsouza.santanderapp.presentation.pages.investment;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.alessandrofsouza.santanderapp.data.service.ApiService;
import com.example.alessandrofsouza.santanderapp.domain.model.InvestmentModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InvestmentPresenter implements InvestmentContract.Presenter{

    private static final String TAG = "Santander ";
    private InvestmentContract.View view;
    private ApiService service;

    public InvestmentPresenter(@NonNull InvestmentContract.View investmentView) {
        view = investmentView;
        view.setPresenter(this);
        service = new ApiService();
    }

    @Override
    public void init() {
        getInvestmentScreen();
    }

    @Override
    public void getInvestmentScreen() {
        service.getApi().listInvestment().enqueue(new Callback<InvestmentModel>() {
            @NonNull
            @Override
            public void onResponse(Call<InvestmentModel> call, Response<InvestmentModel> response) {
                if (response.isSuccessful()) {
                    InvestmentModel investmentModel = response.body();

                    view.showInvestmentScreen(investmentModel.getScreen());
                } else {
                    Log.e(TAG, "Error Unsuccessful " + response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<InvestmentModel> call, Throwable t) {
                Log.e(TAG, "Error Failure " + t.getMessage());
            }
        });
    }

}
