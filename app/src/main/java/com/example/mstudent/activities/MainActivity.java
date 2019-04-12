package com.example.mstudent.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mstudent.R;
import com.example.mstudent.storage.StudentSharedPref;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button bTeacher, bStudent;
    private TextView tvSignUp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (StudentSharedPref.getInstance(getApplicationContext()).isLoggedIn()){
            startActivity(new Intent(this, StudentProfile.class));
        }

        bTeacher = findViewById(R.id.b_teacher_login);
        bTeacher.setOnClickListener(this);
        bTeacher.setVisibility(View.GONE);

        bStudent = findViewById(R.id.b_student_login);
        bStudent.setOnClickListener(this);

        tvSignUp = findViewById(R.id.tv_teacher_sign_up);
        tvSignUp.setOnClickListener(this);
        tvSignUp.setVisibility(View.GONE);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.b_student_login:
                startActivity(new Intent(this, UserLogin.class));
                break;

            case R.id.tv_teacher_sign_up:
                startActivity(new Intent(this, StudentLogin.class));
                break;

            case R.id.b_teacher_login:
                startActivity(new Intent(this, StudentLogin.class));
                break;
        }

    }
}
