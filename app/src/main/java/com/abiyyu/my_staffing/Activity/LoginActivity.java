package com.abiyyu.my_staffing.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.abiyyu.my_staffing.Auth.AuthManager;
import com.abiyyu.my_staffing.Model.ServerResponse;
import com.abiyyu.my_staffing.R;
import com.abiyyu.my_staffing.Rest.ApiClient;
import com.abiyyu.my_staffing.Rest.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    EditText etNip, etPassword;
    Button btnLogin;
    String nip, password;
    ApiInterface apiInterface;
    AuthManager authManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etNip = findViewById(R.id.etNip);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(view -> {
            nip = etNip.getText().toString();
            password = etPassword.getText().toString();
            Login(nip,password);
        });

        authManager = new AuthManager(this);

    }

    private void Login(String nip, String password){
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<ServerResponse> loginnCall = apiInterface.loginResponse(nip,password);
        loginnCall.enqueue(new Callback<ServerResponse>() {
            @Override
            public void onResponse(Call<ServerResponse> call, Response<ServerResponse> response) {
                if(response.body() != null && response.isSuccessful() && response.body().isStatus()) {
                    authManager.saveId(response.body().getData().getId());
                    Intent intent = new Intent(LoginActivity.this, Profile.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ServerResponse> call, Throwable t) {
                Toast.makeText(LoginActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

}