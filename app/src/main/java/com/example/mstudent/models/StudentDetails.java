package com.example.mstudent.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StudentDetails {
    @SerializedName("student")
    @Expose
    private Student student;
    @SerializedName("payments")
    @Expose
    private List<Payment> payments = null;
    @SerializedName("primary_exams")
    @Expose
    private List<PrimaryExam> primaryExams = null;
    @SerializedName("secondary_exams")
    @Expose
    private List<SecondaryExam> secondaryExams = null;
    @SerializedName("university_exams")
    @Expose
    private List<UniversityExam> universityExams = null;
    @SerializedName("certificates")
    @Expose
    private List<Certificate> certificates = null;
}
