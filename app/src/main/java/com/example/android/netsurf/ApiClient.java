package com.example.android.netsurf;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    //KALANGOS LOCALHOST SERVER ACCESS
    private static final String BASE_URL = "http://192.168.43.37/MyApi/public/";

    //MAYOKUNS LOCALHOST SERVER ACCESS CHANGE localhost to IPCONFIG OF YOUR PHONES HOTSPOT
    //private static final String BASE_URL = "http://127.0.0.1/MyApi/public/";
    private static ApiClient mInstance;
    private Retrofit retrofit;

    private ApiClient() {
        retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
    }

    public static synchronized ApiClient getInstance() {
        if (mInstance == null) {
            mInstance = new ApiClient();
        }
        return mInstance;
    }

    public ApiInterface getApiInterface(){
        return retrofit.create(ApiInterface.class);
    }
}
