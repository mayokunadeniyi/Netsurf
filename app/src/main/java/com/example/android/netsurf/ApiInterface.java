package com.example.android.netsurf;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("login")
    Call<LoginResponse> login(
            @Field("details") String details,
            @Field("password") String password
    );

    /**
     * @return
     */
    @POST("logout")
    Call<LogoutResponse> logout();
}
