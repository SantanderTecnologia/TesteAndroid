package com.example.alessandrofsouza.santanderapp.presentation.pages.contact;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.alessandrofsouza.santanderapp.R;
import com.example.alessandrofsouza.santanderapp.domain.model.Cell;

import java.util.ArrayList;

@SuppressLint("ValidFragment")
public class ContactFragment extends Fragment implements ContactContract.View {

    private static final String TAG = "Santander ";
    private ContactContract.Presenter presenter;
    private ContactAdapter contactAdapter;
    private RecyclerView recyclerView;
    private ContactListPresenter listPresenter0;
    private ContactActionView rowView0;

    private ConstraintLayout layout1;
    private ConstraintLayout layout2;
    private Button btnBack;


    public static ContactFragment newInstance() {
        return new ContactFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.contact, container, false);

        layout1 = view.findViewById(R.id.constLayout1);
        layout2 = view.findViewById(R.id.constLayout2);
        btnBack = view.findViewById(R.id.buttonBack);
        recycleView(view);
        returnContactLayout(view);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.init();
    }

    @Override
    public void setPresenter(ContactContract.Presenter contractPresenter) {
        presenter = contractPresenter;
    }

    @Override
    public void showContactCells(ArrayList<Cell> cellList) {
        //Envia pro recycleView
        contactAdapter.addListContact(cellList);
    }

    private void recycleView(View view) {
        contractActionExtra();
        recyclerView = view.findViewById(R.id.recycleViewContact);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        contactAdapter = new ContactAdapter(rowView0);
        recyclerView.setAdapter(contactAdapter);
    }



    private void contractActionExtra() {
        rowView0 = new ContactActionView() {
            @Override
            public void click(View itemView, int position) {
//                Log.i(TAG, "->: " + contactAdapter.getValidatorForm());
                switch (position) {
                    case 5:
                        if (contactAdapter.getValidatorForm()) {
                            layout1.setVisibility(View.GONE);
                            layout2.setVisibility(View.VISIBLE);
                        }
                        break;
                }
            }
        };
    }

    private void returnContactLayout(View view) {
        btnBack = view.findViewById(R.id.buttonBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                contactAdapter.clearListContact();
                layout1.setVisibility(View.VISIBLE);
                layout2.setVisibility(View.GONE);
            }
        });
    }

}
