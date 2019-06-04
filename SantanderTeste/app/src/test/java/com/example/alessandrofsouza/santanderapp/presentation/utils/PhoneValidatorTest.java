package com.example.alessandrofsouza.santanderapp.presentation.utils;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class PhoneValidatorTest {
    //PHONE
    @Test
    public void phoneValidator_Correct9Digits_ReturnsTrue() {
//        assertTrue(PhoneValidator.validatePhone("00912345678"));
        assertThat(PhoneValidator.validatePhone("00912345678"), is(true));
    }

    @Test
    public void phoneValidator_Correct8Digits_ReturnsTrue() {
//        assertTrue(PhoneValidator.validatePhone("0012345678"));
        assertThat(PhoneValidator.validatePhone("0012345678"), is(true));
    }

    @Test
    public void phoneValidator_WrongMoreThen9Digits_ReturnsFalse() {
//        assertFalse(PhoneValidator.validatePhone("009123456789"));
        assertThat(PhoneValidator.validatePhone("009123456789"), is(false));
    }

    @Test
    public void phoneValidator_WrongLessThen8Digits_ReturnsFalse() {
//        assertFalse(PhoneValidator.validatePhone("12345678"));
        assertThat(PhoneValidator.validatePhone("12345678"), is(false));
    }

    @Test
    public void phoneValidator_EmptyString_ReturnsFalse() {
//        assertFalse(PhoneValidator.validatePhone(""));
        assertEquals(PhoneValidator.validatePhone(""), false);
    }

    @Test
    public void phoneValidator_NullPhone_ReturnsFalse() {
//        assertFalse(PhoneValidator.validatePhone(null));
        assertEquals(PhoneValidator.validatePhone(null), false);
    }

    @Test
    public void phoneValidator_OddDigitPhone_ReturnsFalse() {
//        assertFalse(PhoneValidator.validatePhone("01#2222222"));
        assertThat(PhoneValidator.validatePhone("01#2222222"), is(false));
    }
}