package com.example.mstudent.api;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class NoAuthClient {
    private static Retrofit retrofit;
//    private static String BASE_URL = "http://10.0.2.2:8000/api";
//    private static String BASE_URL = "http://192.168.43.65:8000/api/";
    private static String BASE_URL = "http://192.168.43.19:8000/api/";


    private NoAuthClient(){
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request();

                        Request authRequest = request.newBuilder()
                                .addHeader("Content-Type", "application/json")
                                .method(request.method(), request.body())
                                .build();

                        return chain.proceed(authRequest);
                    }
                })
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static NoAuthClient getInstance(){
        NoAuthClient noAuthClient;
        noAuthClient = new NoAuthClient();

        return noAuthClient;
    }

    public  ApiClient getApi(){
        return retrofit.create(ApiClient.class);
    }
}
