package com.example.wellbeingtracker.Retrofit;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AdviceClient {

    @GET("/advice")
    Call<SlipObjectResponse> getAdvice();
}
