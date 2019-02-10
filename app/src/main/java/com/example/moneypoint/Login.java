package com.example.moneypoint;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void MainActivity(View view) {
        startActivity(new Intent(Login.this, MainActivity.class));
    }

    public void Signup(View view) {
        startActivity(new Intent(Login.this, SignUp.class));
    }
}
