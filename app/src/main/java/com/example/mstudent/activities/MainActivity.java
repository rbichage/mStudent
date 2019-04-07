package com.example.mstudent.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mstudent.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button bTeacher, bStudent;
    private TextView tvSignUp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bTeacher = findViewById(R.id.b_teacher_login);
        bTeacher.setOnClickListener(this);

        bStudent = findViewById(R.id.b_student_login);
        bStudent.setOnClickListener(this);

        tvSignUp = findViewById(R.id.tv_teacher_sign_up);
        tvSignUp.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.b_student_login:
                startActivity(new Intent(this, StudentLogin.class));
                break;

            case R.id.tv_teacher_sign_up:
                startActivity(new Intent(this, TeacherSignUp.class));
                break;

            case R.id.b_teacher_login:
                startActivity(new Intent(this, TeacherLogin.class));
                break;
        }

    }
}
