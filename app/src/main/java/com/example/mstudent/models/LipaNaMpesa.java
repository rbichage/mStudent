package com.example.mstudent.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LipaNaMpesa {
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("request_amount")
    @Expose
    private String requestAmount;
    @SerializedName("reference")
    @Expose
    private String reference;
    @SerializedName("first_name")
    @Expose
    private String firstName;
    @SerializedName("last_name")
    @Expose
    private String lastName;
    @SerializedName("till_no")
    @Expose
    private String tillNo;
    @SerializedName("domain")
    @Expose
    private String domain;

    public LipaNaMpesa(String phone, String requestAmount, String reference,
                       String firstName, String lastName, String tillNo, String domain) {
        this.phone = phone;
        this.requestAmount = requestAmount;
        this.reference = reference;
        this.firstName = firstName;
        this.lastName = lastName;
        this.tillNo = tillNo;
        this.domain = domain;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRequestAmount() {
        return requestAmount;
    }

    public void setRequestAmount(String requestAmount) {
        this.requestAmount = requestAmount;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTillNo() {
        return tillNo;
    }

    public void setTillNo(String tillNo) {
        this.tillNo = tillNo;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }
}
