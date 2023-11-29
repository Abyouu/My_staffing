package com.abiyyu.my_staffing.Rest;

import com.abiyyu.my_staffing.Model.ServerResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {
    @FormUrlEncoded
    @POST("login.php")
    Call<ServerResponse> loginResponse(
            @Field("nip") String nip,
            @Field("password") String password);

    @GET("profile.php")
    Call<ServerResponse> getPegawai(@Query("id") String idPegawai);
}
