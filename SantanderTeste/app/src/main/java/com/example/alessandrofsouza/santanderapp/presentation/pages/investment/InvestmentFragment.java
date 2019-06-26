package com.example.alessandrofsouza.santanderapp.presentation.pages.investment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.alessandrofsouza.santanderapp.R;
import com.example.alessandrofsouza.santanderapp.domain.model.Screen;

@SuppressLint("ValidFragment")
public class InvestmentFragment extends Fragment implements InvestmentContract.View {

    private InvestmentContract.Presenter presenter;
    private InvestmentAdapter investmentAdapter;
    private RecyclerView recyclerView;
    public Button btnPrint;

    public static InvestmentFragment newInstance() {
        return new InvestmentFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.investment, container, false);

        recycleView(view);

        btnPrint = view.findViewById(R.id.buttonPrint);
        btnPrint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), R.string.disable, Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.init();
    }

    @Override
    public void setPresenter(InvestmentContract.Presenter investmentPresenter) {
        presenter = investmentPresenter;
    }


    @Override
    public void showInvestmentScreen(Screen screen) {
        investmentAdapter.addListInvestment(screen);
    }

    private void recycleView(View view) {
        recyclerView = view.findViewById(R.id.recycleViewInvestment);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        investmentAdapter = new InvestmentAdapter();
        recyclerView.setAdapter(investmentAdapter);
    }

}
