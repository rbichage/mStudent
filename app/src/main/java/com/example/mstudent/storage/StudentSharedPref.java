package com.example.mstudent.storage;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.mstudent.models.Student;

public class StudentSharedPref {
    private static final String SHARED_PREF_NAME = "teacher_pref";
    private static Context mContext;

    private StudentSharedPref(Context context){
        mContext = context;
    }

    public static synchronized StudentSharedPref getInstance(Context context){
        StudentSharedPref studentSharedPref;
        studentSharedPref = new StudentSharedPref(context);

            return studentSharedPref;
    }

    public void saveStudent(Student student){

        SharedPreferences sharedPreferences = mContext.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putInt("id", student.getId());
        editor.putString("full_name", student.getFullName());
        editor.putString("adm_no", student.getAdmNo());
        editor.putString("dob", student.getDob());
        editor.putString("gender", student.getGender());
        editor.putString("school", student.getSchool());
        editor.apply();
    }

    public Student getStudent(){
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return new Student(
                sharedPreferences.getInt("id", -1),
                sharedPreferences.getString("full_name", null),
                sharedPreferences.getString("adm_no", null),
                sharedPreferences.getString("dob", null),
                sharedPreferences.getString("gender", null),
                sharedPreferences.getString("school", null)
        );
    }

    public boolean isLoggedIn(){
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getInt("id", -1) != -1;
    }

    public void clear(){
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }
}
