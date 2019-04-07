package com.example.mstudent.api;

import com.example.mstudent.models.CreateStaff;
import com.example.mstudent.models.Login;
import com.example.mstudent.models.LoginResponse;
import com.example.mstudent.models.RegisterResponse;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiClient {

@POST("staff")
    Call<ResponseBody> createStaff(@Body CreateStaff createStaff);

@POST("login")
    Call<LoginResponse> userLogin(@Body Login login);

}
