package com.example.mstudent.api;

import com.example.mstudent.models.CreateStaff;
import com.example.mstudent.models.Login;
import com.example.mstudent.models.LoginResponse;
import com.example.mstudent.models.StudentDetails;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiClient {



@POST("login/")
    Call<LoginResponse> userLogin(@Body Login login);

@GET("/api/student/{id}")
    Call<StudentDetails> studentDetails(@Path("id") int id);

}
