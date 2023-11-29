package com.abiyyu.my_staffing.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.abiyyu.my_staffing.Auth.AuthManager;
import com.abiyyu.my_staffing.Model.Pegawai;
import com.abiyyu.my_staffing.Model.ServerResponse;
import com.abiyyu.my_staffing.R;
import com.abiyyu.my_staffing.Rest.ApiClient;
import com.abiyyu.my_staffing.Rest.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Profile extends AppCompatActivity {

    AuthManager authManager;
    ApiInterface apiInterface;
    String id, nip, role, nama;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        authManager = new AuthManager(Profile.this);
        String myId = authManager.getId();
        getPegawai(myId);
    }

    private void getPegawai(String idPegawai){
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<ServerResponse> getPetugasCall = apiInterface.getPegawai(idPegawai);
        getPetugasCall.enqueue(new Callback<ServerResponse>() {
            @Override
            public void onResponse(Call<ServerResponse> call, Response<ServerResponse> response) {
                if(response.body() != null && response.isSuccessful() && response.body().isStatus()) {
                    Pegawai pegawai = response.body().getData();
                    id = pegawai.getId();
                    nip = pegawai.getNip();
                    role = pegawai.getRole();
                    nama = pegawai.getNama();
                    //DATA UDAH KEAMBIL SEMUA TINGGAL BEBAS MAU SET TEXT KEMANA, AKU GA NAMBAHIN SETTEXT KARENA R.ID NYA ERROR, RUNGKAD EMANG NUHUN
                    Toast.makeText(Profile.this, "id:" + id + " nip:" + nip + " role:" + role + " nama:" + nama, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Profile.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ServerResponse> call, Throwable t) {
                Toast.makeText(Profile.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}