package com.example.mstudent.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CreateStaff {
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

    public CreateStaff(String fullName, String email, String school, String password) {
        this.fullName = fullName;
        this.email = email;
        this.school = school;
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }
}
