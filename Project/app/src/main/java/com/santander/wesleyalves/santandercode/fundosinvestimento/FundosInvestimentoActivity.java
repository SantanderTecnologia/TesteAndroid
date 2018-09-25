package com.santander.wesleyalves.santandercode.fundosinvestimento;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.santander.wesleyalves.santandercode.R;
import com.santander.wesleyalves.santandercode._utils.ActivityUtils;

public class FundosInvestimentoActivity extends AppCompatActivity {

    private Button btn_footer_investimento;
    private Button btn_footer_contato;
    private ConstraintLayout constraint_investimentos;
    private ConstraintLayout constraint_contato;

    private FundosInvestimentoFragment fundosInvestimentoFragment;
    private ContatoFragment contatoFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fundos_investimento);

        InvestimentosFragment();

        definirObjetosLayout();
        definirListeners();
    }

    private void InvestimentosFragment() {
        fundosInvestimentoFragment =
                (FundosInvestimentoFragment) getSupportFragmentManager().findFragmentById(R.id.fundos_investimento_fragment);

        if (fundosInvestimentoFragment == null) {
            fundosInvestimentoFragment = FundosInvestimentoFragment.newInstance();

            ActivityUtils.addFragmentToActivity(
                    getSupportFragmentManager(), fundosInvestimentoFragment, R.id.fundos_investimento_fragment);
        }
    }

    private void ContatoFragment() {
        contatoFragment =
                (ContatoFragment) getSupportFragmentManager().findFragmentById(R.id.contato_fragment);

        if (contatoFragment == null) {
            contatoFragment = contatoFragment.newInstance();

            ActivityUtils.addFragmentToActivity(
                    getSupportFragmentManager(), contatoFragment, R.id.contato_fragment);

        }
    }

    private void BtnInvestimentoClick() {
        constraint_contato.setVisibility(View.GONE);
        constraint_investimentos.setVisibility(View.VISIBLE);

        btn_footer_investimento.setBackgroundResource(R.drawable.button_footer_pressed);
        btn_footer_contato.setBackgroundResource(R.drawable.button_footer);

        ViewGroup.LayoutParams params = btn_footer_investimento.getLayoutParams();
        params.height = 137;
        btn_footer_investimento.setLayoutParams(params);

        ViewGroup.LayoutParams paramsContato = btn_footer_contato.getLayoutParams();
        paramsContato.height = 130;
        btn_footer_contato.setLayoutParams(paramsContato);

        InvestimentosFragment();
    }

    private void BtnContatoClick() {
        constraint_investimentos.setVisibility(View.GONE);
        constraint_contato.setVisibility(View.VISIBLE);

        btn_footer_contato.setBackgroundResource(R.drawable.button_footer_pressed);
        btn_footer_investimento.setBackgroundResource(R.drawable.button_footer);

        ViewGroup.LayoutParams params = btn_footer_investimento.getLayoutParams();
        params.height = 130;
        btn_footer_investimento.setLayoutParams(params);

        ViewGroup.LayoutParams paramsContato = btn_footer_contato.getLayoutParams();
        paramsContato.height = 137;
        btn_footer_contato.setLayoutParams(paramsContato);

        ContatoFragment();
    }

    private void definirListeners() {
        btn_footer_investimento.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                BtnInvestimentoClick();
            }
        });

        btn_footer_contato.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                BtnContatoClick();
            }
        });
    }

    private void definirObjetosLayout() {
        btn_footer_investimento = findViewById(R.id.btn_investimento);
        btn_footer_contato = findViewById(R.id.btn_contato);
        constraint_investimentos = findViewById(R.id.fundos_investimento_fragment);
        constraint_contato = findViewById(R.id.contato_fragment);
    }
}
