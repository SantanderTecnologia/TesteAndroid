package com.bruno.santander.santanderchallenge;

import com.bruno.santander.santanderchallenge.investimento.presentation.InvestimentoContract;
import com.bruno.santander.santanderchallenge.investimento.presentation.InvestimentoPresenter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class InvestimentoPresenterTest {

    @Mock
    private InvestimentoContract.View view;

    private InvestimentoContract.Presenter presenter;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        presenter = new InvestimentoPresenter(view);
    }

    @Test
    public void testGetFund(){
        presenter.getFund();
    }

    @Test
    public void testInvest(){
        presenter.invest();
    }

}
