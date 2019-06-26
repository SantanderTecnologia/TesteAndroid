package com.example.alessandrofsouza.santanderapp.presentation.utils;

import java.util.regex.Pattern;

public class NameValidator {

    public static final Pattern NAME_PATTERN = Pattern.compile(
            ("^[a-zA-ZáàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ ]+(?:[\\s.]+[a-zA-ZáàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ ]+)*${1,6}")
    );

    public static boolean validateName(CharSequence name) {
        return name != null && NAME_PATTERN.matcher(name).matches();
    }

}
