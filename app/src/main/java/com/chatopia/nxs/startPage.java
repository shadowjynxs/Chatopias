package com.chatopia.nxs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class startPage extends AppCompatActivity {

    ImageView logo;
    TextView sLogin;
    AppCompatButton cWithGoogle, cAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);

        sLogin = findViewById(R.id.SignUp);
        cWithGoogle = findViewById(R.id.idGoogleLogin);
        cAccount = findViewById(R.id.idCreateAcc);

        cAccount.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), RegisterActivity.class)));
        sLogin.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), LoginActivity.class)));

    }
}