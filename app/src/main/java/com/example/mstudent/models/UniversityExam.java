package com.example.mstudent.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UniversityExam {
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

    public UniversityExam(Integer id, String courseCode, String courseName, String date, Integer marks) {
        this.id = id;
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.date = date;
        this.marks = marks;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getMarks() {
        return marks;
    }

    public void setMarks(Integer marks) {
        this.marks = marks;
    }

    public Integer getStudent() {
        return student;
    }

    public void setStudent(Integer student) {
        this.student = student;
    }

    public Object getSchool() {
        return school;
    }

    public void setSchool(Object school) {
        this.school = school;
    }
}
