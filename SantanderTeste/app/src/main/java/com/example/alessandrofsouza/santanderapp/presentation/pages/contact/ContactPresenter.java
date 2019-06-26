package com.example.alessandrofsouza.santanderapp.presentation.pages.contact;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.alessandrofsouza.santanderapp.data.service.ApiService;
import com.example.alessandrofsouza.santanderapp.domain.model.ContactModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ContactPresenter implements ContactContract.Presenter{

    private static final String TAG = "Santander ";
    private ContactContract.View view;
    private ApiService service;

    public ContactPresenter(@NonNull ContactContract.View contractView) {
        view = contractView;
        view.setPresenter(this);
        service = new ApiService();
    }

    @Override
    public void init() {
        getContactCells();
    }

    public void getContactCells() {
        service.getApi().listCells().enqueue(new Callback<ContactModel>() {
            @NonNull
            @Override
            public void onResponse(Call<ContactModel> call, Response<ContactModel> response) {
                if (response.isSuccessful()) {
                    ContactModel contactModel = response.body();
                    view.showContactCells(contactModel.getCells());

                } else {
                    Log.e(TAG, "Error Unsuccessful " + response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<ContactModel> call, Throwable t) {
                Log.e(TAG, "Error Failure " + t.getMessage());
            }
        });
    }


}
