package com.example.wellbeingtracker.ui.calories;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.wellbeingtracker.Model.Calories;
import com.example.wellbeingtracker.RoomDatabase.WellBeingTrackerRepository;

import java.util.List;

public class CaloriesViewModel extends AndroidViewModel {

    private WellBeingTrackerRepository repository;

    public CaloriesViewModel(Application app) {
        super(app);
        repository = WellBeingTrackerRepository.getInstance(app);
    }

    public LiveData<List<Calories>> getAllCalories() {
        return repository.getAllCalories();
    }

    public void insert(final Calories calories) {
        repository.insert(calories);
    }

    public void deleteAllCalories() {
        repository.deleteAllCalories();
    }
}
