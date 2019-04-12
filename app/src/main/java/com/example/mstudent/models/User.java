package com.example.mstudent.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("course_code")
    @Expose
    private String courseCode;
    @SerializedName("course_name")
    @Expose
    private String courseName;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("marks")
    @Expose
    private Integer marks;
    @SerializedName("student")
    @Expose
    private Integer student;
    @SerializedName("school")
    @Expose
    private Object school;

    public User(Integer id, String courseCode, String courseName,
                String date, Integer marks, Integer student, Object school) {
        this.id = id;
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.date = date;
        this.marks = marks;
        this.student = student;
        this.school = school;
    }
}
