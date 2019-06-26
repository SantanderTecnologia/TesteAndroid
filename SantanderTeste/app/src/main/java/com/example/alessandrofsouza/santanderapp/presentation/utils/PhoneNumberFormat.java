package com.example.alessandrofsouza.santanderapp.presentation.utils;

import android.support.annotation.NonNull;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

import java.lang.ref.WeakReference;

public class PhoneNumberFormat implements TextWatcher {

    private boolean mFormatting; // this is a flag which prevents the stack(onTextChanged)
    private boolean clearFlag;
    private int mLastStartLocation;
    private String mLastBeforeText;
    private WeakReference<EditText> mWeakEditText;
    private int MAX_SIZE = 10;
    public String phoneNumbers;

    public String STATE_PHONE_VALIDATOR = "0";


    public PhoneNumberFormat(WeakReference<EditText> editTextPhone) {
        this.mWeakEditText = editTextPhone;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        if (after == 0 && s.toString().equals("(")) {
            clearFlag = true;
        }
        mLastStartLocation = start;
        mLastBeforeText = s.toString();
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {}

    @Override
    public void afterTextChanged(Editable s) {
        // Make sure to ignore calls to afterTextChanged caused by the work done below
        if (!mFormatting) {
            mFormatting = true;
            int curPos = mLastStartLocation;
            String beforeValue = mLastBeforeText;
            String currentValue = s.toString();
            String formattedValue = formatPhone(s);
            if (currentValue.length() > beforeValue.length()) {
                int setCusorPos = formattedValue.length()
                        - (beforeValue.length() - curPos);
                mWeakEditText.get().setSelection(setCusorPos < 0 ? 0 : setCusorPos);
            } else {
                int setCusorPos = formattedValue.length()
                        - (currentValue.length() - curPos);
                if(setCusorPos > 0 && !Character.isDigit(formattedValue.charAt(setCusorPos -1))){
                    setCusorPos--;
                }
                mWeakEditText.get().setSelection(setCusorPos < 0 ? 0 : setCusorPos);
            }
            mFormatting = false;
            stylePhoneField();
        }
    }

    public String formatPhone(@NonNull Editable text) {
        StringBuilder formattedString = new StringBuilder();

        // Remove everything except digits
        int p = 0;
        while (p < text.length()) {
            char ch = text.charAt(p);
            if (!Character.isDigit(ch)) {
                text.delete(p, p + 1);
            } else {
                p++;
            }
        }

        // Now only digits are remaining
        String allDigitString = text.toString();

        int totalDigitCount = allDigitString.length();

        //clean if dont have numbers
        if (totalDigitCount == 0) {
            text.clear();
            text.append(allDigitString);
            return allDigitString;
        }

        int alreadyPlacedDigitCount = 0;

        // The first 2 numbers must be enclosed in brackets "()"
        if (totalDigitCount - alreadyPlacedDigitCount > 2) {
            formattedString.append("("
                    + allDigitString.substring(alreadyPlacedDigitCount,
                    alreadyPlacedDigitCount + 2) + ") ");
            alreadyPlacedDigitCount += 2;
        }

        //dash"-" (valid BR 9 for mobile phones)
        if (totalDigitCount - alreadyPlacedDigitCount > 5) {
            int validDigit = 2;

            if (String.valueOf(allDigitString.charAt(validDigit)).equals("9")) {
                MAX_SIZE = 11;
                formattedString.append(allDigitString.substring(alreadyPlacedDigitCount, alreadyPlacedDigitCount + 5) + "-");
                alreadyPlacedDigitCount += 5;

            } else {
                MAX_SIZE = 10;
                formattedString.append(allDigitString.substring(alreadyPlacedDigitCount, alreadyPlacedDigitCount + 4) + "-");
                alreadyPlacedDigitCount += 4;
            }
        }


        // All the required formatting is done so we'll just copy the remaining digits.
        if (totalDigitCount > alreadyPlacedDigitCount) {
            formattedString.append(allDigitString
                    .substring(alreadyPlacedDigitCount));
        }

        //delete number after max size
        if(totalDigitCount > MAX_SIZE) {
            formattedString.delete(text.length() - 1, text.length()).toString();
        }


        text.clear();
        text.append(formattedString.toString());

        PhoneValidator.validatePhone(formattedString.toString());
        phoneNumbers = formattedString.toString().replaceAll("[^\\d]", "");

        return formattedString.toString();
        //REF: https://stackoverflow.com/a/23659268
    }


    public String stylePhoneField() {

        if (phoneNumbers.isEmpty()) {
            STATE_PHONE_VALIDATOR = "0";

        } else if (MAX_SIZE == 10 && PhoneValidator.PHONE8_PATTERN.matcher(phoneNumbers).matches()) {
            STATE_PHONE_VALIDATOR = "2";

        } else if (MAX_SIZE == 11 && PhoneValidator.PHONE9_PATTERN.matcher(phoneNumbers).matches()) {
                STATE_PHONE_VALIDATOR = "2";

        } else {
            STATE_PHONE_VALIDATOR = "1";
        }

        return STATE_PHONE_VALIDATOR;
    }
}
