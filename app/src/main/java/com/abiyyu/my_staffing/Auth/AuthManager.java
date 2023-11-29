package com.abiyyu.my_staffing.Auth;

import android.content.Context;
import android.content.SharedPreferences;

public class AuthManager {
    private static final String SHARED_PREFS = "MyPrefs";
    private static final String KEY_ID = "id";

    private final SharedPreferences sharedPreferences;

    public AuthManager(Context context) {
        this.sharedPreferences = context.getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
    }

    public void saveId(String accessToken) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_ID, accessToken);
        editor.apply();
    }

    public String getId() {
        return sharedPreferences.getString(KEY_ID, "");
    }

    public void clearId() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(KEY_ID);
        editor.apply();
    }
}
