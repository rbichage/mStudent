package com.example.mstudent.models;

public class Teacher {
    private String fullName;
    private String email;
    private String school;
    private String token;

    public Teacher(String fullName, String email, String school, String token) {
        this.fullName = fullName;
        this.email = email;
        this.school = school;
        this.token = token;
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

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
