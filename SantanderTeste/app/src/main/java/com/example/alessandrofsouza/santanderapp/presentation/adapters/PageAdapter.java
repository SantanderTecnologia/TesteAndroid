package com.example.alessandrofsouza.santanderapp.presentation.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.alessandrofsouza.santanderapp.R;
import com.example.alessandrofsouza.santanderapp.presentation.pages.contact.ContactFragment;
import com.example.alessandrofsouza.santanderapp.presentation.pages.contact.ContactPresenter;
import com.example.alessandrofsouza.santanderapp.presentation.pages.investment.InvestmentFragment;
import com.example.alessandrofsouza.santanderapp.presentation.pages.investment.InvestmentPresenter;

import java.util.ArrayList;

public class PageAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> fragments = new ArrayList<>();
    private ArrayList<String> title = new ArrayList<>();
    private Context context;

    public PageAdapter(Context ctx, FragmentManager fm) {
        super(fm);
        context = ctx;
    }

//    public void add(Fragment frag, String title) {
//        this.fragments.add(frag);
//        this.title.add(title);
//    }

    @Override
    public Fragment getItem(int i) {
//        return this.fragments.get(i);

        switch (i) {
            case 0:
                InvestmentFragment fragment1 = InvestmentFragment.newInstance();
                new InvestmentPresenter(fragment1);
                return fragment1;

            case 1:
                ContactFragment fragment0 = ContactFragment.newInstance();
                new ContactPresenter(fragment0);
                return fragment0;

            default:
                return null;

        }
    }

    @Override
    public int getCount() {
//        return this.fragments.size();
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
//        return this.title.get(position);
        switch (position) {
            case 0:
                return context.getResources().getString(R.string.investimento);
            case 1:
                return context.getResources().getString(R.string.contato);
            default:
                return null;
        }
    }
}
