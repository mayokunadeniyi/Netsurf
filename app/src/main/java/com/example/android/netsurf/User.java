package com.example.android.netsurf;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("response")
    private String Response;

    @SerializedName("id")
    private String UserID;

    public String getResponse() {
        return Response;
    }

    public String getUserID() {
        return UserID;
    }
}
