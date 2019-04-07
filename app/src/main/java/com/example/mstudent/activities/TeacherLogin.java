package com.example.mstudent.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mstudent.R;
import com.example.mstudent.api.NoAuthClient;
import com.example.mstudent.models.Login;
import com.example.mstudent.models.LoginResponse;
import com.example.mstudent.models.Teacher;
import com.example.mstudent.storage.TeacherSharedPref;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TeacherLogin extends AppCompatActivity implements View.OnClickListener {

    private TextView pageTitle, tvresetPassword;
    private EditText etEmail, etPassword;
    private Button bLogin;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);

        pageTitle = findViewById(R.id.tv_title);
        pageTitle.setText("Teacher Login");

        etEmail = findViewById(R.id.et_email);
        etEmail.setHint("Email");
        etEmail.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);

        etPassword = findViewById(R.id.et_password);

        bLogin = findViewById(R.id.b_login);
        bLogin.setOnClickListener(this);

        tvresetPassword = findViewById(R.id.tv_reset_password);
        tvresetPassword.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.b_login:
                teacherLogin();
                break;

            case R.id.tv_reset_password:
                Toast.makeText(this, "nothing here yet", Toast.LENGTH_SHORT).show();
                break;
        }

    }

    private void teacherLogin() {
        String email = etEmail.getText().toString().trim();
        if (TextUtils.isEmpty(email)){
            etEmail.setError("This is required");
            etEmail.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            etEmail.setError("Invalid email address");
            etEmail.requestFocus();
            return;
        }

        String password = etPassword.getText().toString().trim();
        if (TextUtils.isEmpty(password)){
            etPassword.setError("This is required");
            etPassword.requestFocus();
            return;
        }

        Login login = new Login(email, password);
        Call<LoginResponse> call = NoAuthClient
                .getInstance()
                .getApi()
                .userLogin(login);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("please wait...");
        progressDialog.setCancelable(true);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();

        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful()){
                    LoginResponse loginResponse = response.body();
                    Teacher teacher = new Teacher(loginResponse.getFullName(),
                            loginResponse.getEmail(),
                            loginResponse.getSchool(),
                            loginResponse.getToken()
                            );

                    TeacherSharedPref
                            .getInstance(getApplicationContext())
                            .saveTeacher(teacher);

                    progressDialog.dismiss();
                    Toast.makeText(TeacherLogin.this, teacher.getFullName(), Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(getApplicationContext(), TeacherProfile.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }

                else {
                    try {
                        JSONObject jsonObject = new JSONObject(response.errorBody().string());
                        Toast.makeText(TeacherLogin.this, jsonObject.getString("Error"), Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                    } catch (JSONException | IOException e) {
                        e.printStackTrace();
                        progressDialog.dismiss();
                    }
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                progressDialog.dismiss();

            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
