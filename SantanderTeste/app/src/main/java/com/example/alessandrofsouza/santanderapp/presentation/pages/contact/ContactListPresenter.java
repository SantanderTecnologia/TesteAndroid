package com.example.alessandrofsouza.santanderapp.presentation.pages.contact;

import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.content.res.ResourcesCompat;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.alessandrofsouza.santanderapp.R;
import com.example.alessandrofsouza.santanderapp.domain.model.Cell;
import com.example.alessandrofsouza.santanderapp.presentation.utils.Constants;
import com.example.alessandrofsouza.santanderapp.presentation.utils.EmailValidator;
import com.example.alessandrofsouza.santanderapp.presentation.utils.NameValidator;
import com.example.alessandrofsouza.santanderapp.presentation.utils.PhoneNumberFormat;
import com.example.alessandrofsouza.santanderapp.presentation.utils.PhoneValidator;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

class ContactListPresenter {

    private static final String TAG = "Santander ";
    private final ArrayList<Cell> dataCell;
    private Resources resources;
    private View view;
    private Cell cell;

    private ContactListPresenter listPresenter0;
    private ContactActionView rowView0;
    private ContactAdapter contactAdapter;

    private boolean checkCheckbox = false;
    private CheckBox checkBox;

    private TextInputLayout editLayout;
    private TextInputEditText editTextName;
    private TextInputEditText editTextMail;
    private TextInputEditText editTextPhone;

    private PhoneNumberFormat phoneformat;



    public ContactListPresenter(ArrayList<Cell> dataCell) {
        this.dataCell = dataCell;
    }


    public void onBindRepositoryRowViewAtPosition(int i, final ContactAdapter.ViewHolder viewHolder) {
        cell = dataCell.get(i);
        resources = viewHolder.itemView.getContext().getResources();
        contactAdapter = new ContactAdapter(rowView0);

//        viewHolder.setTitle(cell.getMessage());

        switch (cell.getType()) {

            case Constants.TYPE_FIELD:
                viewHolder.textInputLayout.setHint(cell.getMessage());
                viewHolder.textInputLayout.setHint(cell.getMessage());
                viewHolder.textInputLayout.setVisibility(cell.isHidden() ? View.GONE : View.VISIBLE);
                viewHolder.textInputLayout.setId(cell.getId());
                viewHolder.textInputLayout.setPadding(0, cell.getTopSpacing(), 0, 0);
                viewHolder.textInputLayout.clearFocus();

                switch (cell.getTypefield()) {

                    case Constants.TYPEFIELD_TEXT_T:
                        viewHolder.textInputEditText.setInputType(InputType.TYPE_CLASS_TEXT);
                        viewHolder.textInputEditText.setText(cell.getEditTextValue());
                        editTextName = viewHolder.textInputEditText;

                        editTextName.addTextChangedListener(new TextWatcher() {
                            @Override
                            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                            }

                            @Override
                            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                            }

                            @Override
                            public void afterTextChanged(Editable editable) {
                                NameValidator.validateName(editable);
                                styleNameField();
                            }

                            public boolean styleNameField() {
                                String nameInput = editTextName.getText().toString().trim();

                                if (nameInput.isEmpty()) {
                                    editTextName.setError("Está vázio");
                                    editTextName.getBackground().mutate().setColorFilter(resources.getColor(R.color.santanderRed), PorterDuff.Mode.SRC_ATOP);
                                    return false;

                                } else if (!NameValidator.NAME_PATTERN.matcher(nameInput).matches()) {
                                    editTextName.setError("Está incorreto");
                                    editTextName.getBackground().mutate().setColorFilter(resources.getColor(R.color.santanderRed), PorterDuff.Mode.SRC_ATOP);
                                    return false;

                                } else {
                                    editTextName.setError(null);
                                    editTextName.getBackground().mutate().setColorFilter(resources.getColor(R.color.santanderCorrect), PorterDuff.Mode.SRC_ATOP);
                                    return true;
                                }
                            }
                        });
                        break;

                    case Constants.TYPEFIELD_TELNUMBER_T:
                        viewHolder.textInputEditText.setInputType(InputType.TYPE_CLASS_PHONE);
                        editTextPhone = viewHolder.textInputEditText;

                        phoneformat = new PhoneNumberFormat(new WeakReference<EditText>(editTextPhone));
                        editTextPhone.addTextChangedListener(phoneformat);
                        editTextPhone.setSelection(editTextPhone.getText().length());

                        editTextPhone.addTextChangedListener(new TextWatcher() {
                            @Override
                            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

                            @Override
                            public void onTextChanged(CharSequence s, int start, int before, int count) { }

                            @Override
                            public void afterTextChanged(Editable s) {
                                stylePhoneField();
                            }
                        });

                        break;

                    case Constants.TYPEFIELD_EMAIL_T:
                        viewHolder.textInputEditText.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
                        editLayout = viewHolder.textInputLayout;
                        editTextMail = viewHolder.textInputEditText;


                        editTextMail.addTextChangedListener(new TextWatcher() {
                            @Override
                            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

                            @Override
                            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

                            @Override
                            public void afterTextChanged(Editable editable) {
                                EmailValidator.validateEmail(editable);
                                styleEmailField();
                            }

                            private boolean styleEmailField() {
                                String emailInput = editTextMail.getText().toString().trim();
                                if (emailInput.isEmpty()) {
                                    editTextMail.setError("Está vázio");
                                    editTextMail.getBackground().mutate().setColorFilter(resources.getColor(R.color.santanderRed), PorterDuff.Mode.SRC_ATOP);
                                    return false;

                                } else if (!EmailValidator.EMAIL_PATTERN.matcher(emailInput).matches()) {
                                    editTextMail.setError("Está incorreto");
                                    editTextMail.getBackground().mutate().setColorFilter(resources.getColor(R.color.santanderRed), PorterDuff.Mode.SRC_ATOP);
                                    return false;

                                } else {
                                    editTextMail.setError(null);
                                    editTextMail.getBackground().mutate().setColorFilter(resources.getColor(R.color.santanderCorrect), PorterDuff.Mode.SRC_ATOP);
                                    return true;
                                }
                            }
                        });
                        break;

                    default:
                        viewHolder.textInputEditText.setInputType(InputType.TYPE_CLASS_TEXT);
                        break;
                }

                break;

            case Constants.TYPE_TEXT:
                viewHolder.textView.setText(cell.getMessage());
                viewHolder.textView.setVisibility(cell.isHidden() ? View.GONE : View.VISIBLE);
                viewHolder.textView.setId(cell.getId());
                viewHolder.textView.setPadding(0, cell.getTopSpacing(), 0, cell.getTopSpacing());
                viewHolder.textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, resources.getDimension(R.dimen.txtRegular));
                break;

            case Constants.TYPE_CHECKBOX:
                viewHolder.checkBox.setText(cell.getMessage());
                viewHolder.checkBox.setVisibility(cell.isHidden() ? View.GONE : View.VISIBLE);
                viewHolder.checkBox.setId(cell.getId());
                viewHolder.checkBox.setTextSize(TypedValue.COMPLEX_UNIT_PX, resources.getDimension(R.dimen.txtRegular));
                viewHolder.checkBox.setTypeface(ResourcesCompat.getFont(viewHolder.itemView.getContext(), R.font.dinpro_medium));
                viewHolder.checkBox.setPadding(0, cell.getTopSpacing(), 0, cell.getTopSpacing());
                viewHolder.checkBox.setChecked(cell.isHidden());
                viewHolder.checkBox.setOnCheckedChangeListener(null);

                checkBox = viewHolder.checkBox;

                viewHolder.checkBox.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        if(checkBox.isChecked()) {
                            checkCheckbox = true;
                            editLayout.setVisibility(View.VISIBLE);
                        } else {
                            checkCheckbox = false;
                            editLayout.setVisibility(View.GONE);
                        }
                    }
                });
                break;

            case Constants.TYPE_SEND:
                viewHolder.roundedButton.setText(cell.getMessage());
                viewHolder.roundedButton.setVisibility(cell.isHidden() ? View.GONE : View.VISIBLE);
                viewHolder.roundedButton.setId(cell.getId());
                viewHolder.roundedButton.setPadding(0, cell.getTopSpacing(), 0, cell.getTopSpacing());
                viewHolder.roundedButton.setOnClickListener(viewHolder);
                break;

            default:
                //@TODO: change to ImageView or create 1 more field to
                viewHolder.textView.setText(cell.getMessage());
                viewHolder.textView.setVisibility(cell.isHidden() ? View.GONE : View.VISIBLE);
                viewHolder.textView.setId(cell.getId());
                viewHolder.textView.setPadding(0, cell.getTopSpacing(), 0, cell.getTopSpacing());
                viewHolder.textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, resources.getDimension(R.dimen.txtRegular));
                break;
        }
    }


    private void stylePhoneField() {

        switch (phoneformat.STATE_PHONE_VALIDATOR) {
            case "0":
                editTextPhone.setError("Está vázio");
                editTextPhone.getBackground().mutate().setColorFilter(resources.getColor(R.color.santanderRed), PorterDuff.Mode.SRC_ATOP);
                break;
            case "1":
                editTextPhone.setError("Está incorreto");
                editTextPhone.getBackground().mutate().setColorFilter(resources.getColor(R.color.santanderRed), PorterDuff.Mode.SRC_ATOP);
                break;
            case "2":
                editTextPhone.setError(null);
                editTextPhone.getBackground().mutate().setColorFilter(resources.getColor(R.color.santanderCorrect), PorterDuff.Mode.SRC_ATOP);
                break;
            default:
                editTextPhone.setError("Está incorreto");
                editTextPhone.getBackground().mutate().setColorFilter(resources.getColor(R.color.santanderRed), PorterDuff.Mode.SRC_ATOP);
                break;
        }
    }


    public int getRepositoriesRowsCount() {
        return dataCell.size();
    }


    public boolean getValidForm() {
        if (!checkCheckbox) {
            if (NameValidator.NAME_PATTERN.matcher(editTextName.getText().toString().trim()).matches() && PhoneValidator.PHONE8_PATTERN.matcher(phoneformat.phoneNumbers.trim()).matches() ||
                    NameValidator.NAME_PATTERN.matcher(editTextName.getText().toString().trim()).matches() && PhoneValidator.PHONE9_PATTERN.matcher(phoneformat.phoneNumbers.trim()).matches()) {
                return true;
            } else {
                return false;
            }

        } else {
            if (NameValidator.NAME_PATTERN.matcher(editTextName.getText().toString().trim()).matches() && EmailValidator.EMAIL_PATTERN.matcher(editTextMail.getText().toString().trim()).matches() && PhoneValidator.PHONE8_PATTERN.matcher(phoneformat.phoneNumbers.trim()).matches() ||
                    NameValidator.NAME_PATTERN.matcher(editTextName.getText().toString().trim()).matches() && EmailValidator.EMAIL_PATTERN.matcher(editTextMail.getText().toString().trim()).matches() && PhoneValidator.PHONE9_PATTERN.matcher(phoneformat.phoneNumbers.trim()).matches()) {
                return true;
            } else {
                return false;
            }
        }
    }


    public void clearForm() {
        editTextName.setText(null);
        editTextName.setError("", null);
        editTextName.getBackground().mutate().setColorFilter(resources.getColor(R.color.santanderLtGray), PorterDuff.Mode.SRC_ATOP);

        editTextPhone.setText(null);
        editTextPhone.setError("", null);
        editTextPhone.getBackground().mutate().setColorFilter(resources.getColor(R.color.santanderLtGray), PorterDuff.Mode.SRC_ATOP);

        checkBox.setChecked(false);

        editLayout.setVisibility(View.GONE);
        editTextMail.setText(null);
        editTextMail.setError("", null);
        editTextMail.getBackground().mutate().setColorFilter(resources.getColor(R.color.santanderLtGray), PorterDuff.Mode.SRC_ATOP);
    }
}
