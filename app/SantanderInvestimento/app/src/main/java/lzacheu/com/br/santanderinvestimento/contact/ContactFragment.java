package lzacheu.com.br.santanderinvestimento.contact;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.text.InputType;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import lzacheu.com.br.santanderinvestimento.R;
import lzacheu.com.br.santanderinvestimento.model.contact.InputField;
import lzacheu.com.br.santanderinvestimento.util.InputFieldHelper;
import lzacheu.com.br.santanderinvestimento.util.MaskEditText;
import lzacheu.com.br.santanderinvestimento.widget.CustomEditText;

/**
 * Created by luiszacheu on 6/16/18.
 */

public class ContactFragment extends Fragment implements ContactContract.View, View.OnClickListener {

    private ContactContract.Presenter presenter;

    @BindView(R.id.content_form)
    LinearLayout contentLayout;

    private List<View> viewList = new ArrayList<>();

    public static ContactFragment newInstance() {
        return new ContactFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new ContactPresenter(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.start();
        presenter.getFields();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.contact_fragment, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }


    @Override
    public void setPresenter(ContactContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showLoading(boolean isVisible) {

    }

    @Override
    public void renderForm(List<InputField> inputFieldList) {
        contentLayout.removeAllViews();
        for (InputField inputField : inputFieldList) {
            switch (inputField.getType()) {
                case 1:
                    CustomEditText appCompatEditText = InputFieldHelper.createEditText(getContext(), inputField);
                    if (inputField.getMessage().equalsIgnoreCase("telefone")){
                        appCompatEditText.addTextChangedListener(MaskEditText.mask(appCompatEditText, MaskEditText.FORMAT_FONE));
                        appCompatEditText.setInputType(InputType.TYPE_CLASS_NUMBER);
                    } else if(inputField.getMessage().equalsIgnoreCase("email")){
                        appCompatEditText.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
                    }
                    View inputTextLayout = InputFieldHelper.wrapChildOnTextInputLayout(getContext(), appCompatEditText);
                    contentLayout.addView(inputTextLayout);
                    viewList.add(inputTextLayout);
                    break;
                case 2:
                    TextView textView = InputFieldHelper.createTextView(getContext(), inputField);
                    contentLayout.addView(textView);
                    viewList.add(textView);
                    break;
                case 3:
                    ///
                case 4:
                    CheckBox checkBox = InputFieldHelper.createCheckBox(getContext(), inputField);
                    checkBox.setOnClickListener(toggleHiddenFields);
                    contentLayout.addView(checkBox);
                    viewList.add(checkBox);
                    break;
                case 5:
                    Button button = InputFieldHelper.createButtom(getContext(), inputField);
                    button.setOnClickListener(this);
                    contentLayout.addView(button);
                    viewList.add(button);
                    break;
            }
        }
    }


    @Override
    public void hideForm() {
        contentLayout.removeAllViews();

    }

    @Override
    public void sendForm() {

    }

    @Override
    public void showSendMessageView() {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        ConstraintLayout messageLayout = (ConstraintLayout) inflater.inflate(R.layout.message_contact, null, false);
        TextView textView = messageLayout.findViewById(R.id.new_message);
        textView.setOnClickListener(this);
        contentLayout.addView(messageLayout);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.new_message){
            presenter.getFields();
            Toast.makeText(getContext(), "New Form", Toast.LENGTH_SHORT).show();
        }else{
            if (!validateFields()){
                presenter.sendMessage();
            }
            Toast.makeText(getContext(), "Envia Form", Toast.LENGTH_SHORT).show();
        }

    }

    private boolean validateFields(){
        boolean existError = false;
        for (View view : viewList){
            if (view instanceof TextInputLayout){
                CustomEditText customEditText = (CustomEditText)((TextInputLayout) view).getEditText();
                if (customEditText.isRequired() && customEditText.isShown()){
                    if (customEditText.getText().toString().isEmpty()){
                        ((TextInputLayout) view).setError("Campo é obrigatório.");
                        existError =true;
                    }else{
                        ((TextInputLayout) view).setError(null);
                    }

                    if (customEditText.getInputType() == InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS){
                        Pattern pattern = Patterns.EMAIL_ADDRESS;
                        Matcher matcher = pattern.matcher(customEditText.getText().toString());
                        if (!matcher.matches()){
                            ((TextInputLayout) view).setError("Formato do e-mail incorreto.");
                            existError =true;
                        }
                    }
                }
            }
        }
        return existError;
    }

    private View.OnClickListener toggleHiddenFields = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            for (View component: viewList){
                if (component instanceof TextInputLayout){
                    CustomEditText customEditText = (CustomEditText)((TextInputLayout) component).getEditText();
                    if (customEditText.getInputType() == InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS){
                        if (customEditText.isShown()){
                            customEditText.setVisibility(View.GONE);
                        }else{
                            customEditText.setVisibility(View.VISIBLE);
                        }
                    }
                }

            }

        }
    };


}
