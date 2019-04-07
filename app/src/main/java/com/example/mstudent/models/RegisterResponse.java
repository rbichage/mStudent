package com.example.mstudent.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RegisterResponse {
    @SerializedName("fullName")
    @Expose
    private String fullName;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("school")
    @Expose
    private String school;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("_id")
    @Expose
    private String id;
}
