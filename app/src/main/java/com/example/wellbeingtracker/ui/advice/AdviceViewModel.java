package com.example.wellbeingtracker.ui.advice;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.wellbeingtracker.Model.Advice;
import com.example.wellbeingtracker.RoomDatabase.WellBeingTrackerRepository;

public class AdviceViewModel extends AndroidViewModel {


    private WellBeingTrackerRepository repository;

    public AdviceViewModel(Application app) {
        super(app);
        repository = WellBeingTrackerRepository.getInstance(app);
    }

    public LiveData<Advice> getAdvice() {
        return repository.getAdvice();
    }

    public void updateAdvice() {
        repository.updateAdvice();
    }
}