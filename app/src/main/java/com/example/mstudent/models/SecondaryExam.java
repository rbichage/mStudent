package com.example.mstudent.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public  class SecondaryExam {
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
    @SerializedName("chem")
    @Expose
    private Integer chem;
    @SerializedName("phy")
    @Expose
    private Integer phy;
    @SerializedName("bio")
    @Expose
    private Integer bio;
    @SerializedName("comp")
    @Expose
    private Integer comp;
    @SerializedName("bst")
    @Expose
    private Integer bst;
    @SerializedName("agr")
    @Expose
    private Integer agr;
    @SerializedName("art")
    @Expose
    private Integer art;
    @SerializedName("cre")
    @Expose
    private Integer cre;
    @SerializedName("music")
    @Expose
    private Integer music;
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
    @SerializedName("average")
    @Expose
    private Double average;
    @SerializedName("totalscore")
    @Expose
    private Integer totalscore;

    public SecondaryExam(Integer id, Integer maths, Integer english, Integer kiswahili, Integer chem,
                         Integer phy, Integer bio, Integer comp, Integer bst, Integer agr, Integer art,
                         Integer cre, Integer music, String date,
                         String klass, Integer student, String school, Double average, Integer totalscore) {
        this.id = id;
        this.maths = maths;
        this.english = english;
        this.kiswahili = kiswahili;
        this.chem = chem;
        this.phy = phy;
        this.bio = bio;
        this.comp = comp;
        this.bst = bst;
        this.agr = agr;
        this.art = art;
        this.cre = cre;
        this.music = music;
        this.date = date;
        this.klass = klass;
        this.student = student;
        this.school = school;
        this.average = average;
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

    public Integer getChem() {
        return chem;
    }

    public void setChem(Integer chem) {
        this.chem = chem;
    }

    public Integer getPhy() {
        return phy;
    }

    public void setPhy(Integer phy) {
        this.phy = phy;
    }

    public Integer getBio() {
        return bio;
    }

    public void setBio(Integer bio) {
        this.bio = bio;
    }

    public Integer getComp() {
        return comp;
    }

    public void setComp(Integer comp) {
        this.comp = comp;
    }

    public Integer getBst() {
        return bst;
    }

    public void setBst(Integer bst) {
        this.bst = bst;
    }

    public Integer getAgr() {
        return agr;
    }

    public void setAgr(Integer agr) {
        this.agr = agr;
    }

    public Integer getArt() {
        return art;
    }

    public void setArt(Integer art) {
        this.art = art;
    }

    public Integer getCre() {
        return cre;
    }

    public void setCre(Integer cre) {
        this.cre = cre;
    }

    public Integer getMusic() {
        return music;
    }

    public void setMusic(Integer music) {
        this.music = music;
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

    public Double getAverage() {
        return average;
    }

    public void setAverage(Double average) {
        this.average = average;
    }

    public Integer getTotalscore() {
        return totalscore;
    }

    public void setTotalscore(Integer totalscore) {
        this.totalscore = totalscore;
    }
}
