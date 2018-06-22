package com.example.savio.testeandroid.contract;

import java.util.List;

public interface FormContract {

    interface Model{

        List<Object> getData();
    }

    interface View{

        void initView();

        void setViewData(List<Object> messages);
    }

    interface Presenter{

        void requestData();
        boolean testRequestData();
    }

}
