package com.example.alessandrofsouza.santanderapp.domain.model;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class InfosTest {

    Infos info;

    @Before
    public void init() {
        info = new Infos("string", "string", "string");
    }

    @Test
    public void title_ReturnsTrue() {
        assertThat(info.getTitle(), is("string"));
    }


    @Test
    public void name_ReturnsTrue() {
        assertThat(info.getName(), is("string"));
    }


    @Test
    public void data_ReturnsTrue() {
        assertThat(info.getData(), is("string"));
    }


}