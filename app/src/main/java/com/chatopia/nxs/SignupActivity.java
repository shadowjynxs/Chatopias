package com.chatopia.nxs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;

public class SignupActivity extends AppCompatActivity {

    TextInputLayout name, email, dob;
    AppCompatButton cAcc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        name = findViewById(R.id.rName);
        email = findViewById(R.id.rEmailUsername);
        dob = findViewById(R.id.rDob);

        EditText xName = name.getEditText();
        EditText xEmail = email.getEditText();
        EditText xDob = dob.getEditText();


        cAcc = findViewById(R.id.finalCreate);

        Intent intent = getIntent();
        String mEmail = intent.getStringExtra("mEmail");
        String mName = intent.getStringExtra("mName");
        String mDob = intent.getStringExtra("mDob");
        String isNum = intent.getStringExtra("isNum");


        assert xName != null;
        xName.setText((CharSequence) mName);
        assert isNum != null;
        if (isNum.equals(getString(R.string.uEmail))) {
            assert xEmail != null;
            email.setHint(R.string.uEmail);
            xEmail.setText((CharSequence) mEmail);
        } else if (isNum.equals(getString(R.string.uPhone))) {
            assert xEmail != null;
            email.setHint(R.string.uPhone);
            xEmail.setInputType(InputType.TYPE_CLASS_NUMBER);
            xEmail.setText((CharSequence) mEmail);
        }

        assert xDob != null;
        xDob.setText((CharSequence) mDob);

        cAcc.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), ConfirmSignup.class)));

        xName.setOnClickListener(v -> {
            finish();
        });
        assert xEmail != null;
        xEmail.setOnClickListener(v -> {
            finish();
        });
        xDob.setOnClickListener(v -> {
            finish();
        });
    }
}