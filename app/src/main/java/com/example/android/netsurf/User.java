package com.example.android.netsurf;

public class User {

    private int id;
    private String name, email, matnum, username;

    public User(int id, String name, String email, String matnum, String username) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.matnum = matnum;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getMatnum() {
        return matnum;
    }

    public String getUsername() {
        return username;
    }
}
