package com.example.alessandrofsouza.santanderapp.data.service;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ApiServiceTest {

    String str = "https://floating-mountain-50292.herokuapp.com";



    @Test
    public void correct_api_received() {
//        assertTrue(ApiService.ServiceApi.BASE_URL.contentEquals(str));
//        assertSame(ApiService.ServiceApi.BASE_URL, str);
        assertThat(ApiService.ServiceApi.BASE_URL, is("https://floating-mountain-50292.herokuapp.com"));
    }
}