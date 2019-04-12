package com.example.mstudent.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.mstudent.R;
import com.example.mstudent.activities.PrimarySchoolActivity;
import com.example.mstudent.activities.SecondarySchoolActivity;
import com.example.mstudent.activities.StudentLogin;
import com.example.mstudent.activities.UniversityActivity;
import com.example.mstudent.models.Student;
import com.example.mstudent.storage.StudentSharedPref;

public class HomeFragment extends Fragment implements View.OnClickListener {
        TextView tvFullName, tvSchool, tvGender;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Student student = StudentSharedPref.getInstance(getContext()).getStudent();
        Log.e("STUDENT", "onViewCreated: " + student.getFullName() + student.getGender() );

        Toolbar toolbar = view.findViewById(R.id.home_toolbar);
        Button logout = view.findViewById(R.id.student_logout);
        logout.setOnClickListener(this);

        CardView primaryCard = view.findViewById(R.id.primary_card);
        primaryCard.setOnClickListener(this);

        CardView secondaryCard = view.findViewById(R.id.secondary_card);
        secondaryCard.setOnClickListener(this);

        CardView universityCard = view.findViewById(R.id.university_card);
        universityCard.setOnClickListener(this);

        CardView paymentCard = view.findViewById(R.id.payment_card);
        paymentCard.setOnClickListener(this);

        tvFullName = view.findViewById(R.id.student_name);
        tvFullName.setText(String.format("Name: %s", student.getFullName()));

        tvSchool = view.findViewById(R.id.student_school);
        tvSchool.setText(String.format("Institution: %s", student.getSchool()));

        tvGender = view.findViewById(R.id.student_gender);
        tvGender.setText(String.format("Gender:  %s", student.getGender()));





    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.student_logout:
                StudentSharedPref.getInstance(getContext()).clear();
                Intent intent = new Intent(getContext(), StudentLogin.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                break;

            case R.id.primary_card:
                startActivity(new Intent(getContext(), PrimarySchoolActivity.class));
                break;

            case R.id.secondary_card:
                startActivity(new Intent(getContext(), SecondarySchoolActivity.class));
                break;

            case R.id.university_card:
                startActivity(new Intent(getContext(), UniversityActivity.class));
                break;

            case R.id.payment_card:
                break;
        }
    }
}
