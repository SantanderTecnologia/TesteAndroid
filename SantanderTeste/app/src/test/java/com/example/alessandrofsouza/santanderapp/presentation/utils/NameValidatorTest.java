package com.example.alessandrofsouza.santanderapp.presentation.utils;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class NameValidatorTest {

    //NAME
    @Test
    public void nameValidator_CorrectNameSimple_ReturnsTrue() {
        assertThat(NameValidator.validateName("name"), is(true));
    }

    @Test
    public void nameValidator_CorrectNameDouble_ReturnsTrue() {
        assertThat(NameValidator.validateName("name name"), is(true));
    }

    @Test
    public void thirdValidator_CorrectNameThird_ReturnsTrue() {
        assertThat(NameValidator.validateName("name name name"), is(true));
    }

    @Test
    public void nameValidator_InvalidName_ReturnsFalse() {
        assertThat(NameValidator.validateName("2@mali&"), is(false));
    }

    @Test
    public void nameValidator_EmptyString_ReturnsFalse() {
        assertEquals(NameValidator.validateName(""), false);
    }

    @Test
    public void nameValidator_NullName_ReturnsFalse() {
        assertEquals(NameValidator.validateName(null), false);
    }

}