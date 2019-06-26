package com.example.alessandrofsouza.santanderapp.presentation.pages.contact;

import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.alessandrofsouza.santanderapp.R;
import com.example.alessandrofsouza.santanderapp.domain.model.Cell;
import com.example.alessandrofsouza.santanderapp.presentation.utils.Constants;

import java.util.ArrayList;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {

    private static final String TAG = "Santander ";
    private ArrayList<Cell> dataSet;
    private Cell cell;
    private final ContactListPresenter presenter;
    private ContactActionView rowView0;




    public ContactAdapter(ContactActionView listener) {
        dataSet = new ArrayList<>();
        cell = new Cell();
        presenter = new ContactListPresenter(dataSet);
        rowView0 = listener;
    }


    @NonNull
    @Override
    public ContactAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        switch (i){
            case Constants.TYPE_FIELD:
                return new ContactAdapter.ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_edit_text, viewGroup, false), rowView0);

            case Constants.TYPE_SEND:
                return new ContactAdapter.ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_button_round, viewGroup, false), rowView0);

            case Constants.TYPE_CHECKBOX:
                return new ContactAdapter.ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_checkbox, viewGroup, false), rowView0);

            case Constants.TYPE_TEXT:
                return new ContactAdapter.ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_text, viewGroup, false), rowView0);

            default:
                //@TODO: change to ImageView or create 1 more field to
                return new ContactAdapter.ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_text, viewGroup, false), rowView0);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ContactAdapter.ViewHolder viewHolder, int i) {
        presenter.onBindRepositoryRowViewAtPosition(i, viewHolder);
    }

    @Override
    public int getItemViewType(int position) {
        cell = dataSet.get(position);
        int viewType = cell.getType();
        return viewType;
    }

    @Override
    public int getItemCount() {
        return presenter.getRepositoriesRowsCount();
    }

    public void addListContact(ArrayList<Cell> cellList) {
        dataSet.clear();
        dataSet.addAll(cellList);
        notifyDataSetChanged();
    }

    public boolean getValidatorForm() {
        return presenter.getValidForm();
    }

    public void clearListContact() {
        presenter.clearForm();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView textView;
        public TextInputLayout textInputLayout;
        public TextInputEditText textInputEditText;
        public Button roundedButton;
        public CheckBox checkBox;

        public ContactActionView contactActionView;


        public ViewHolder(@NonNull View itemView, ContactActionView listerner) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
            textInputLayout = itemView.findViewById(R.id.editTextLayout);
            textInputEditText = itemView.findViewById(R.id.editTextInput);
            roundedButton = itemView.findViewById(R.id.buttonRound);
            checkBox = itemView.findViewById(R.id.checkBox);

            contactActionView = listerner;
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            contactActionView.click(itemView, getAdapterPosition());
        }

    }
}
