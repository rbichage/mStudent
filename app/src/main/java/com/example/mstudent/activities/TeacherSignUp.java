package com.example.mstudent.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mstudent.R;
import com.example.mstudent.api.NoAuthClient;
import com.example.mstudent.models.CreateStaff;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TeacherSignUp extends AppCompatActivity implements View.OnClickListener {

    private EditText etFullName, etEmail, etSchool, etPassword;
    private Button bSignUp;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_sign_up);

        etFullName = findViewById(R.id.et_full_name);
        etEmail = findViewById(R.id.et_email);
        etSchool = findViewById(R.id.et_school);
        etPassword = findViewById(R.id.et_password);

        bSignUp = findViewById(R.id.b_sign_up);
        bSignUp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.b_sign_up){
            String fullName = etFullName.getText().toString();
            if (TextUtils.isEmpty(fullName)){
                etFullName.setError("This is required");
                etFullName.requestFocus();
                return;
            }
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

            String school = etSchool.getText().toString();
            if (TextUtils.isEmpty(school)){
                etSchool.setError("This is required");
                etSchool.requestFocus();
                return;
            }

            String password = etPassword.getText().toString().trim();
            if (TextUtils.isEmpty(password)){
                etPassword.setError("This is required");
                etPassword.requestFocus();
                return;
            }

            CreateStaff createStaff = new CreateStaff(fullName, email, school, password);

            Call<ResponseBody> call = NoAuthClient
                    .getInstance()
                    .getApi()
                    .createStaff(createStaff);

            progressDialog = new ProgressDialog(this);
            progressDialog.setMessage("please wait...");
            progressDialog.setCancelable(true);
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            call.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    if (response.isSuccessful()){
                        Toast.makeText(TeacherSignUp.this, "created successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(TeacherSignUp.this, TeacherLogin.class);
                        progressDialog.dismiss();
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                        finish();
                    }

                    else {
                        try {
                            JSONObject jsonObject = new JSONObject(response.errorBody().string());
                            Toast.makeText(TeacherSignUp.this, jsonObject.getString("Error"), Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();

                        } catch (JSONException | IOException e) {
                            progressDialog.dismiss();
                            e.printStackTrace();
                        }
                    }
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    progressDialog.dismiss();
                    Toast.makeText(TeacherSignUp.this, "Check your connection", Toast.LENGTH_SHORT).show();
                }
            });


        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
