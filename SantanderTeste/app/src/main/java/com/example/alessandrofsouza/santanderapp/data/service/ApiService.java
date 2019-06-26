package com.example.alessandrofsouza.santanderapp.data.service;

import com.example.alessandrofsouza.santanderapp.domain.model.ContactModel;
import com.example.alessandrofsouza.santanderapp.domain.model.InvestmentModel;

import java.util.Set;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class ApiService {

    //private String BASE_URL = "https://floating-mountain-50292.herokuapp.com/";

    public ServiceApi getApi() {
        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl(ServiceApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(ServiceApi.class);
    }

    public interface ServiceApi {

        public static final String BASE_URL = "https://floating-mountain-50292.herokuapp.com";

        @GET("/cells.json")
        Call<ContactModel> listCells();

        @GET("/fund.json")
        Call<InvestmentModel> listInvestment();

    }
}
