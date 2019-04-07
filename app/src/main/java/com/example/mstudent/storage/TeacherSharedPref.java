package com.example.mstudent.storage;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.mstudent.models.Teacher;

public class TeacherSharedPref {
    private static final String SHARED_PREF_NAME = "teacher_pref";
    private static Context mContext;
    private static TeacherSharedPref teacherSharedPref;

    private TeacherSharedPref(Context context){
        mContext = context;
    }

    public static synchronized  TeacherSharedPref getInstance(Context context){
        if (teacherSharedPref==null){
            teacherSharedPref = new TeacherSharedPref(context);

        }
        return teacherSharedPref;
    }

    public void saveTeacher(Teacher teacher){

        SharedPreferences sharedPreferences = mContext.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("full_name", teacher.getFullName());
        editor.putString("email", teacher.getEmail());
        editor.putString("school", teacher.getSchool());
        editor.putString("token", teacher.getToken());
        editor.apply();
    }

    public Teacher getTeacher(){
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return new Teacher(
                sharedPreferences.getString("full_name", null),
                sharedPreferences.getString("email", null),
                sharedPreferences.getString("school", null),
                sharedPreferences.getString("token", null)
        );
    }
}
