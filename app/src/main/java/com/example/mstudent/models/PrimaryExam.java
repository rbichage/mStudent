package com.example.mstudent.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class PrimaryExam implements Serializable {
    @SerializedName("school")
    @Expose
    private String school;
    @SerializedName("average")
    @Expose
    private Double average;
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
    @SerializedName("totalscore")
    @Expose
    private Integer totalscore;
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

    public PrimaryExam(String school, Double average, Integer sst, String date, String klass, Integer student, Integer totalscore,
                       Integer id, Integer maths, Integer english, Integer kiswahili, Integer science) {
        this.school = school;
        this.average = average;
        this.sst = sst;
        this.date = date;
        this.klass = klass;
        this.student = student;
        this.totalscore = totalscore;
        this.id = id;
        this.maths = maths;
        this.english = english;
        this.kiswahili = kiswahili;
        this.science = science;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Double getAverage() {
        return average;
    }

    public void setAverage(Double average) {
        this.average = average;
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

    public Integer getTotalscore() {
        return totalscore;
    }

    public void setTotalscore(Integer totalscore) {
        this.totalscore = totalscore;
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
}
