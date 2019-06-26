package com.example.alessandrofsouza.santanderapp.domain.model;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MoreInfoValuesTest {

    MoreInfoValues moreinfo;

    @Before
    public void init() {
        moreinfo = new MoreInfoValues();
        moreinfo.setFund(0.1);
        moreinfo.setCDI(0.1);
    }

    @Test
    public void fund_ReturnsTrue() {
        assertThat(moreinfo.getFund(), is(0.1));
    }


    @Test
    public void cdi_ReturnsTrue() {
        assertThat(moreinfo.getCDI(), is(0.1));
    }


}