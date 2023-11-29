package com.abiyyu.my_staffing.Model;

import com.google.gson.annotations.SerializedName;

public class ServerResponse {
    @SerializedName("data")
    private Pegawai data;

    @SerializedName("token")
    private String token;

    @SerializedName("message")
    private String message;

    @SerializedName("status")
    private Boolean status;

    public void setData(Pegawai data){
        this.data = data;
    }

    public Pegawai getData(){
        return data;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    public void setMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

    public void setStatus(Boolean status){
        this.status = status;
    }

    public Boolean isStatus(){
        return status;
    }
}
