package com.example.moneypoint;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class SignUp extends AppCompatActivity {

    EditText edt_name, edt_email, edt_username, edt_password, edt_conf_pass, edt_phone;
    Button sign_up_btn;

    String sname, semail, susername, spass, sconf_pass, sphone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        edt_name = findViewById(R.id.edt_name);
        edt_email = findViewById(R.id.edt_email);
        edt_username = findViewById(R.id.edt_user_name);
        edt_password = findViewById(R.id.edt_password);
        edt_conf_pass = findViewById(R.id.edt_conf_pass);
        edt_phone = findViewById(R.id.edt_phone);
        sign_up_btn = findViewById(R.id.signup_btn);

        sign_up_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignUpUser();
            }
        });

    }

    private void SignUpUser() {
        sname = edt_name.getText().toString();
        semail = edt_email.getText().toString();
        susername = edt_username.getText().toString();
        spass = edt_password.getText().toString();
        sconf_pass = edt_conf_pass.getText().toString();
        sphone = edt_phone.getText().toString();

        if (TextUtils.isEmpty(sname)) {
            Toast.makeText(this, "Enter name...", Toast.LENGTH_SHORT).show();
        }
        if (TextUtils.isEmpty(semail)) {
            Toast.makeText(this, "Enter email..", Toast.LENGTH_SHORT).show();
        }
        if (TextUtils.isEmpty(susername)) {
            Toast.makeText(this, "Enter username", Toast.LENGTH_SHORT).show();
        }
        if (TextUtils.isEmpty(spass)) {
            Toast.makeText(this, "Enter password", Toast.LENGTH_SHORT).show();
        }
        if (TextUtils.isEmpty(sconf_pass)) {
            Toast.makeText(this, "Enter confirm password", Toast.LENGTH_SHORT).show();
        }
        if (TextUtils.isEmpty(sphone)) {
            Toast.makeText(this, "Enter Phone no", Toast.LENGTH_SHORT).show();
        }
        if (!spass.equals(sconf_pass)) {
            Toast.makeText(this, "Your passwords are not matching...", Toast.LENGTH_SHORT).show();
        } else {
            StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
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
                    Map<String, String> params = new HashMap<>();
                    params.put("name", sname);
                    params.put("email", semail);
                    params.put("username", susername);
                    params.put("password", spass);
                    params.put("phone", sphone);
                    return params;
                }
            };

            MySingleton.getmInstance(this).addToRequestque(stringRequest);
        }
    }
}
