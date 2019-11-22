package com.example.wellbeingtracker.Retrofit;

import com.example.wellbeingtracker.Retrofit.AdviceClient;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {

    private static Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
            .baseUrl("https://api.adviceslip.com/")
            .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = retrofitBuilder.build();

    private static AdviceClient adviceApi = retrofit.create(AdviceClient.class);

    public static AdviceClient getAdviceApi() {
        return adviceApi;
    }
}
