package com.example.mstudent.fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.mstudent.R;
import com.example.mstudent.activities.PaymentActivity;
import com.example.mstudent.activities.PrimarySchoolActivity;
import com.example.mstudent.activities.SecondarySchoolActivity;
import com.example.mstudent.activities.StudentLogin;
import com.example.mstudent.activities.UniversityActivity;
import com.example.mstudent.api.RetrofitClient;
import com.example.mstudent.models.LipaNaMpesa;
import com.example.mstudent.models.Student;
import com.example.mstudent.storage.StudentSharedPref;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment implements View.OnClickListener {
        private TextView tvFullName, tvSchool, tvGender;
        FloatingActionButton fab;

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

        fab = view.findViewById(R.id.fab_pay);
        fab.setOnClickListener(this);





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
                startActivity(new Intent(getContext(), PaymentActivity.class));
                break;

            case R.id.fab_pay:
                AlertDialog.Builder builder= new AlertDialog.Builder(getContext());
                builder.setView(R.layout.dialog_pay);
                builder.setPositiveButton("SUBMIT", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });

                final AlertDialog alertDialog = builder.create();
                alertDialog.show();
                alertDialog.getButton(DialogInterface.BUTTON_NEGATIVE).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();

                    }
                });
                alertDialog.getButton(DialogInterface.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        EditText etPhone = alertDialog.findViewById(R.id.et_phone_number);
                        EditText etAmount = alertDialog.findViewById(R.id.et_amount);
                        final ProgressBar progressBar = alertDialog.findViewById(R.id.progressBar);

                        String phone = etPhone.getText().toString().trim();
                        if (TextUtils.isEmpty(phone)){
                            return;
                        }

                        String amount = etAmount.getText().toString().trim();
                        if (TextUtils.isEmpty(amount)){
                            return;
                        }

                        LipaNaMpesa lipaNaMpesa = new LipaNaMpesa (phone,
                                amount, "fees",
                        "bar", "foo", "1342", "a");

                        Call<ResponseBody> call = RetrofitClient.getInstance().getApi().lipaNaMpesa(lipaNaMpesa);
                        progressBar.setVisibility(View.VISIBLE);
                        call.enqueue(new Callback<ResponseBody>() {
                            @Override
                            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                                if (response.isSuccessful()){
                                    alertDialog.dismiss();
                                    Toast.makeText(getContext(), "Successful, wait for reponse", Toast.LENGTH_SHORT).show();
                                }

                                else {
                                    try {
                                        JSONObject jsonObject = new JSONObject(response.errorBody().string());
                                        Toast.makeText(getContext(), jsonObject.getString("non_field_errors"), Toast.LENGTH_SHORT).show();
                                        progressBar.setVisibility(View.GONE);
                                    } catch (JSONException | IOException e) {
                                        e.printStackTrace();
                                        progressBar.setVisibility(View.GONE);
                                    }

                                }
                            }

                            @Override
                            public void onFailure(Call<ResponseBody> call, Throwable t) {
                                Toast.makeText(getContext(), "check your connection", Toast.LENGTH_SHORT).show();
                                progressBar.setVisibility(View.GONE);

                            }
                        });

                    }
                });
                break;
        }
    }
}
