package com.example.alessandrofsouza.santanderapp.presentation.utils;

import java.util.regex.Pattern;

public class EmailValidator {

    public static final Pattern EMAIL_PATTERN = Pattern.compile(
            ("[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                    "){1,2}")
    );

    public static boolean validateEmail(CharSequence email) {
        return email != null && EMAIL_PATTERN.matcher(email).matches();
    }
}
