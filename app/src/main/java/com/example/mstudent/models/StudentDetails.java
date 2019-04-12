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

    public StudentDetails(Student student, List<Payment> payments, List<PrimaryExam> primaryExams, List<SecondaryExam> secondaryExams,
                          List<UniversityExam> universityExams, List<Certificate> certificates) {
        this.student = student;
        this.payments = payments;
        this.primaryExams = primaryExams;
        this.secondaryExams = secondaryExams;
        this.universityExams = universityExams;
        this.certificates = certificates;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public List<PrimaryExam> getPrimaryExams() {
        return primaryExams;
    }

    public void setPrimaryExams(List<PrimaryExam> primaryExams) {
        this.primaryExams = primaryExams;
    }

    public List<SecondaryExam> getSecondaryExams() {
        return secondaryExams;
    }

    public void setSecondaryExams(List<SecondaryExam> secondaryExams) {
        this.secondaryExams = secondaryExams;
    }

    public List<UniversityExam> getUniversityExams() {
        return universityExams;
    }

    public void setUniversityExams(List<UniversityExam> universityExams) {
        this.universityExams = universityExams;
    }

    public List<Certificate> getCertificates() {
        return certificates;
    }

    public void setCertificates(List<Certificate> certificates) {
        this.certificates = certificates;
    }
}
