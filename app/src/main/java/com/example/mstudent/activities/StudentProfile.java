package com.example.mstudent.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.mstudent.fragments.HomeFragment;
import com.example.mstudent.R;
import com.example.mstudent.fragments.SearchFragment;
import com.example.mstudent.fragments.SettingsFragment;
import com.example.mstudent.fragments.StudentsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class StudentProfile extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_profile);

        if (savedInstanceState == null) {
            displayFragment(new HomeFragment());
        }


    }

    private void displayFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit();
    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
            finish();
    }
}

