package com.example.android.netsurf;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("/login")
    Call<User> PerformLogin(@Query("logUser") String Name, @Query("logPass") String Password);
}
