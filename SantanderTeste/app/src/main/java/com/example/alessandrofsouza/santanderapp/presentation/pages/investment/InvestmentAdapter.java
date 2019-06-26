package com.example.alessandrofsouza.santanderapp.presentation.pages.investment;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alessandrofsouza.santanderapp.R;
import com.example.alessandrofsouza.santanderapp.domain.model.Screen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class InvestmentAdapter extends RecyclerView.Adapter<InvestmentAdapter.ViewHolder> {

    public ArrayList<Screen> dataScreenSet;
    private View view;
    private Context context;
    private Resources resources;
    private Screen screen;
    private final InvestmentListPresenter presenter;

    public InvestmentAdapter() {
        dataScreenSet = new ArrayList<>();
        presenter = new InvestmentListPresenter(dataScreenSet);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.frame_layout_invest, viewGroup, false);
        context = view.getContext();

//        recycleInfo(view, context);//chama o recycleView
//        recycleDownInfo(view, context);//chama o recycleView

        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull InvestmentAdapter.ViewHolder viewHolder, int i) {
        presenter.onBindRepositoryRowViewAtPosition(i, viewHolder);
    }


    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return presenter.getRepositoriesRowsCount();
    }

    public void addListInvestment(Screen screen) {
        dataScreenSet.clear();
        dataScreenSet.addAll(Collections.singleton(screen));
        notifyDataSetChanged();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView investTitle;
        public TextView investFundName;
        public TextView whatIs;
        public TextView definition;
        public TextView riskTitle;

        public ImageView arrowRisk;
        private View viewColors1;
        private View viewColors2;
        private View viewColors3;
        private View viewColors4;
        private View viewColors5;
        public ArrayList<View> viewRisk;

        public TextView infoTitle;
        public Button btnInvestment;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            investTitle = itemView.findViewById(R.id.investTitle);
            investFundName = itemView.findViewById(R.id.investFundName);
            whatIs = itemView.findViewById(R.id.whatIs);
            definition = itemView.findViewById(R.id.definition);
            riskTitle = itemView.findViewById(R.id.riskTitle);

            arrowRisk = itemView.findViewById(R.id.arrowRisk);
            viewColors1 = itemView.findViewById(R.id.viewColors1);
            viewColors2 = itemView.findViewById(R.id.viewColors2);
            viewColors3 = itemView.findViewById(R.id.viewColors3);
            viewColors4 = itemView.findViewById(R.id.viewColors4);
            viewColors5 = itemView.findViewById(R.id.viewColors5);
            viewRisk = new ArrayList<>(Arrays.asList(null, viewColors1, viewColors2, viewColors3, viewColors4, viewColors5));

            infoTitle = itemView.findViewById(R.id.infoTitle);

            btnInvestment = itemView.findViewById(R.id.buttonRound);

        }
    }
}
