package com.example.android.netsurf;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefManager {

    private static SharedPrefManager mInstance;
    private Context mCtx;

    private static final String SHARED_PREF_NAME = "user_data";

    private static final String user_logout = "USER_LOGOUT";

    private static final String USER_ID = "user_id";
    private static final String USER_NAME = "user_name";
    private static final String USER_EMAIL = "user_email";
    private static final String USER_MATNUM = "user_matnum";
    private static final String USER_USERNAME = "user_username";

    private SharedPrefManager(Context context) {
        mCtx = context;
    }

    public static synchronized SharedPrefManager getInstance(Context context) {
        if(mInstance == null) {
            mInstance = new SharedPrefManager(context);
        }
        return mInstance;
    }
    public boolean login(User user){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("USER_ID", user.getId());
        editor.putString("USER_NAME", user.getName());
        editor.putString("USER_EMAIL", user.getEmail());
        editor.putString("USER_MATNUM", user.getMatnum());
        editor.putString("USER_USERNAME", user.getUsername());
        editor.apply();
        return true;
    }

    public boolean isLoggedIn() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getInt(USER_ID,-1) != -1;
    }

    public User getUser(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return new User(
                sharedPreferences.getInt(USER_ID,-1),
                sharedPreferences.getString(USER_NAME, null),
                sharedPreferences.getString(USER_EMAIL, null),
                sharedPreferences.getString(USER_MATNUM, null),
                sharedPreferences.getString(USER_USERNAME,null)
        );
    }

    public void clear(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }
}
