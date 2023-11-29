package com.abiyyu.my_staffing.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.abiyyu.my_staffing.MainActivity;
import com.abiyyu.my_staffing.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etNip, etPassword;
    Button btnLogin;
    String username, password;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etNip = findViewById(R.id.etNip);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);

//        Button login = findViewById(R.id.btn_login);
//        login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(login.this, MainActivity.class);
//                startActivity(intent);
//                finish();
//            }
//
//        });
//    }
}

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnLogin:

                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;

        }
    }

}