package com.example.mstudent.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PrimaryExam {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("maths")
    @Expose
    private Integer maths;
    @SerializedName("english")
    @Expose
    private Integer english;
    @SerializedName("kiswahili")
    @Expose
    private Integer kiswahili;
    @SerializedName("science")
    @Expose
    private Integer science;
    @SerializedName("sst")
    @Expose
    private Integer sst;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("klass")
    @Expose
    private String klass;
    @SerializedName("student")
    @Expose
    private Integer student;
    @SerializedName("school")
    @Expose
    private String school;

    public PrimaryExam(Integer id, Integer maths, Integer english, Integer kiswahili, Integer science,
                       Integer sst, String date, String klass, Integer student, String school) {
        this.id = id;
        this.maths = maths;
        this.english = english;
        this.kiswahili = kiswahili;
        this.science = science;
        this.sst = sst;
        this.date = date;
        this.klass = klass;
        this.student = student;
        this.school = school;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMaths() {
        return maths;
    }

    public void setMaths(Integer maths) {
        this.maths = maths;
    }

    public Integer getEnglish() {
        return english;
    }

    public void setEnglish(Integer english) {
        this.english = english;
    }

    public Integer getKiswahili() {
        return kiswahili;
    }

    public void setKiswahili(Integer kiswahili) {
        this.kiswahili = kiswahili;
    }

    public Integer getScience() {
        return science;
    }

    public void setScience(Integer science) {
        this.science = science;
    }

    public Integer getSst() {
        return sst;
    }

    public void setSst(Integer sst) {
        this.sst = sst;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getKlass() {
        return klass;
    }

    public void setKlass(String klass) {
        this.klass = klass;
    }

    public Integer getStudent() {
        return student;
    }

    public void setStudent(Integer student) {
        this.student = student;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }
}
