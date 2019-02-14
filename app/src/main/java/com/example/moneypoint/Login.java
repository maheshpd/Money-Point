package com.example.moneypoint;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity {
    EditText edt_username, edt_password;
    Button login_btn;

    String login_url = "";

    String susername, spass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edt_username = findViewById(R.id.edt_username);
        edt_password = findViewById(R.id.edt_password);
        login_btn = findViewById(R.id.login_btn);

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserLogin();
            }
        });
    }

    private void UserLogin() {
        susername = edt_username.getText().toString();
        spass = edt_password.getText().toString();

        if (TextUtils.isEmpty(susername)) {
            Toast.makeText(this, "Enter username", Toast.LENGTH_SHORT).show();
        }
        if (TextUtils.isEmpty(spass)) {
            Toast.makeText(this, "Enter password", Toast.LENGTH_SHORT).show();
        } else {
            StringRequest stringRequest = new StringRequest(Request.Method.POST, login_url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> param = new HashMap<>();
                    param.put("", susername);
                    param.put("", spass);
                    return param;
                }
            };
        }
    }

    public void MainActivity(View view) {
        startActivity(new Intent(Login.this, MainActivity.class));
    }

    public void Signup(View view) {
        startActivity(new Intent(Login.this, SignUp.class));
    }
}
