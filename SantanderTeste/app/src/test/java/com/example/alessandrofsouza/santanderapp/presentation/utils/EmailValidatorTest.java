package com.example.alessandrofsouza.santanderapp.presentation.utils;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class EmailValidatorTest {

    //RIGHTS
    @Test
    public void emailValidator_CorrectEmailSimple_ReturnsTrue() {
        assertThat(EmailValidator.validateEmail("name@email.com"), is(true));
    }

    @Test
    public void emailValidator_CorrectEmailSubDomain_ReturnsTrue() {
        assertThat(EmailValidator.validateEmail("name@email.com.br"), is(true));
    }

    //WRONGS
    @Test
    public void emailValidator_NullEmail_ReturnsFalse() {
        assertEquals(EmailValidator.validateEmail(null), false);
    }

    @Test
    public void emailValidator_NullEmpty_ReturnsFalse() {
        assertEquals(EmailValidator.validateEmail(""), false);
    }

    @Test
    public void emailValidator_IncorrectEmailNoAt_ReturnsFalse() {
        assertEquals(EmailValidator.validateEmail("email.com.br"), false);
    }

    @Test
    public void emailValidator_IncorrectEmailDoubleAt_ReturnsFalse() {
        assertEquals(EmailValidator.validateEmail("email@@.com.br"), false);
    }
}