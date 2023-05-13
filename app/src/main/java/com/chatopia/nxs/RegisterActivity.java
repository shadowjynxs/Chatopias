package com.chatopia.nxs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;


import com.google.android.material.textfield.TextInputLayout;

public class RegisterActivity extends AppCompatActivity {

    AppCompatButton appCompatButton, rNext;
    TextInputLayout rName, tEmail, rDob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        appCompatButton = findViewById(R.id.idSwitch);
        rNext = findViewById(R.id.rNext);

        tEmail = findViewById(R.id.rEmail);
        rName = findViewById(R.id.rName);
        rDob = findViewById(R.id.rDob);

        appCompatButton.setOnClickListener(v -> {
            if (appCompatButton.getText().toString().equals(getString(R.string.usePhone))) {
                appCompatButton.setText(R.string.use_email_instead);
                tEmail.setHint(R.string.uPhone);
                if (tEmail.getEditText() != null) {
                    tEmail.getEditText().setInputType(InputType.TYPE_CLASS_NUMBER);
                }
            } else if (appCompatButton.getText().toString().equals(getString(R.string.use_email_instead))) {
                appCompatButton.setText(R.string.usePhone);
                tEmail.setHint(R.string.uEmail);
                if (tEmail.getEditText() != null) {
                    tEmail.getEditText().setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
                }
            }
        });

        EditText email = tEmail.getEditText();
        EditText name = rName.getEditText();
        EditText dob = rDob.getEditText();


        rNext.setOnClickListener(v -> {
            if (email != null && name != null && dob != null) {
                String mEmail = email.getText().toString().trim();
                String mName = name.getText().toString().trim();
                String mDob = dob.getText().toString().trim();

                boolean isValid = true;
                if (TextUtils.isEmpty(mName)) {
                    Toast.makeText(getApplicationContext(), "Name Required", Toast.LENGTH_SHORT).show();
                    isValid = false;
                }

                if (TextUtils.isEmpty(mEmail)) {
                    Toast.makeText(getApplicationContext(), "Email Required", Toast.LENGTH_SHORT).show();
                    isValid = false;
                }

                if (TextUtils.isEmpty(mDob)) {
                    Toast.makeText(getApplicationContext(), "DOB Required", Toast.LENGTH_SHORT).show();
                    isValid = false;
                }

                if (isValid) {
                    Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
                    intent.putExtra("mEmail", mEmail);
                    intent.putExtra("mName", mName);
                    intent.putExtra("mDob", mDob);
                    EditText isNum = tEmail.getEditText();
                    if (isNum != null) {
                        intent.putExtra("isNum", isNum.getHint().toString().trim());
                    }
                    startActivity(intent);
                }
            }
        });
    }
}