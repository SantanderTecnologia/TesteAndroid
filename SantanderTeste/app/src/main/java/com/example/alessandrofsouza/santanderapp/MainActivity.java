package com.example.alessandrofsouza.santanderapp;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.alessandrofsouza.santanderapp.presentation.adapters.PageAdapter;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Santander ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

//        PageAdapter adapter = new PageAdapter(getSupportFragmentManager());
//        adapter.add(new InvestmentPresenter(), getString(R.string.investimento));
//        adapter.add(new ContactPresenter(), getString(R.string.contato));

        PagerAdapter adapter = new PageAdapter(this, getSupportFragmentManager());

        ViewPager viewPager = findViewById(R.id.mainPage);
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = findViewById(R.id.pageTab);
        tabLayout.setupWithViewPager(viewPager);
    }
}
