package com.example.alessandrofsouza.santanderapp.presentation.pages.investment;

import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alessandrofsouza.santanderapp.R;
import com.example.alessandrofsouza.santanderapp.domain.model.Infos;

import java.util.ArrayList;

class InvestmentInfoAdapter extends RecyclerView.Adapter<InvestmentInfoAdapter.ViewHolder> {


    private static final String TAG = "Santander ";
    private ArrayList<Infos> dataSet;

    public InvestmentInfoAdapter() {
        dataSet = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View viewText = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.invest_info, viewGroup, false);
        return new ViewHolder(viewText);
    }

    @Override
    public void onBindViewHolder(@NonNull final InvestmentInfoAdapter.ViewHolder viewHolder, int i) {
        //TODO: create holderPresenter

        Infos info = dataSet.get(i);
        Resources resources = viewHolder.itemView.getContext().getResources();

        viewHolder.info_title.setText(info.getName());

        if(info.getData() != null) {
            viewHolder.buttonDown.setAlpha(0);
            viewHolder.buttonDown.setClickable(false);
            viewHolder.info_content.setText(info.getData());
        } else {
            viewHolder.info_content.setAlpha(0);
            viewHolder.buttonDown.setText(resources.getText(R.string.baixar));
            viewHolder.buttonDown.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(viewHolder.itemView.getContext(), R.string.disable, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public void addListInfo(ArrayList<Infos> listInfo) {
        dataSet.addAll(listInfo);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView info_title;
        private TextView info_content;
        private Button buttonDown;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            info_title = itemView.findViewById(R.id.info_title);
            info_content = itemView.findViewById(R.id.info_content);
            buttonDown = itemView.findViewById(R.id.buttonDown);
        }
    }
}
