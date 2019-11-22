package com.example.wellbeingtracker.RoomDatabase;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.wellbeingtracker.Model.Calories;
import com.example.wellbeingtracker.Model.Advice;
import com.example.wellbeingtracker.Retrofit.AdviceClient;
import com.example.wellbeingtracker.Retrofit.ServiceGenerator;
import com.example.wellbeingtracker.Retrofit.SlipObjectResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WellBeingTrackerRepository {

    private CaloriesDao caloriesDao;
    private static WellBeingTrackerRepository instance;
    private LiveData<List<Calories>> allCalories;
    private MutableLiveData<Advice> advice;

    //
    private LiveData<Calories> calories;

    private WellBeingTrackerRepository(Application application){
        WellBeingTrackerDatabase database = WellBeingTrackerDatabase.getInstance(application);
        caloriesDao = database.caloriesDao();
        allCalories = caloriesDao.getAllCalories();
        advice = new MutableLiveData<>();

    }

    public static synchronized WellBeingTrackerRepository getInstance(Application application){
        if(instance==null){
            instance = new WellBeingTrackerRepository(application);
        }
        return instance;

    }
    // Calories
    public LiveData<List<Calories>> getAllCalories(){
        return allCalories;
    }

    public void insert(Calories calories) {
        new InsertCaloriesAsync(caloriesDao).execute(calories);
    }

    public void deleteAllCalories(){
        new DeleteAllCaloriesAsync(caloriesDao).execute();
    }


    private static class InsertCaloriesAsync extends AsyncTask<Calories,Void,Void> {
        private CaloriesDao caloriesDao;

        private InsertCaloriesAsync(CaloriesDao caloriesDao) {
            this.caloriesDao = caloriesDao;
        }

        @Override
        protected Void doInBackground(Calories... notes) {
            caloriesDao.insert(notes[0]);
            return null;
        }
    }

    private static class DeleteAllCaloriesAsync extends AsyncTask<Void,Void,Void> {
        private CaloriesDao caloriesDao;

        private DeleteAllCaloriesAsync(CaloriesDao caloriesDao) {
            this.caloriesDao = caloriesDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            caloriesDao.deleteAllCalories();
            return null;
        }
    }


    //Retrofit Advice

    public LiveData<Advice> getAdvice() {
        return advice;
    }

    public void updateAdvice() {
        AdviceClient pokemonApi = ServiceGenerator.getAdviceApi();
        Call<SlipObjectResponse> call = pokemonApi.getAdvice();
        call.enqueue(new Callback<SlipObjectResponse>() {
            @Override
            public void onResponse(Call<SlipObjectResponse> call, Response<SlipObjectResponse> response) {
                if (response.code() == 200) {
                    advice.setValue(response.body().getAdvice());
                }
            }
            @Override
            public void onFailure(Call<SlipObjectResponse> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong :(");
                Advice noAdvice = new Advice("Something went wrong :(, try again");
                advice.setValue(noAdvice);
            }
        });
    }



}
