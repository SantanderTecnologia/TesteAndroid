package com.example.alessandrofsouza.santanderapp.presentation.pages.investment;

import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.alessandrofsouza.santanderapp.R;
import com.example.alessandrofsouza.santanderapp.domain.model.Infos;

import java.util.ArrayList;

class InvestmentMoreInfoAdapter extends RecyclerView.Adapter<InvestmentMoreInfoAdapter.ViewHolder> {

    private static final String TAG = "Santander ";
    private ArrayList<Infos> dataSet;

    public InvestmentMoreInfoAdapter() {
        dataSet = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View viewText = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.invest_more_info, viewGroup, false);
        return new InvestmentMoreInfoAdapter.ViewHolder(viewText);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        //TODO: create holderPresenter
        Infos info = dataSet.get(i);
        Resources resources = viewHolder.itemView.getContext().getResources();

        viewHolder.info_title.setText(info.getTitle());
        viewHolder.info_fundo.setText(info.getName());
        viewHolder.info_Cdi.setText(info.getData());

    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public void addListMoreInfo(ArrayList<Infos> moreInfo) {
        dataSet.addAll(moreInfo);
        notifyDataSetChanged();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView info_title;
        private TextView info_fundo;
        private TextView info_Cdi;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            info_title = itemView.findViewById(R.id.moreInfo_title);
            info_fundo = itemView.findViewById(R.id.moreInfo_fundo);
            info_Cdi = itemView.findViewById(R.id.moreInfo_cdi);
        }
    }
}
