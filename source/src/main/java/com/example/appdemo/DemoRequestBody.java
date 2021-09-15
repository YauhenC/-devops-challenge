package com.example.appdemo;


import javax.validation.constraints.NotNull;

public class DemoRequestBody {

    @NotNull
    private String username;
    @NotNull
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}