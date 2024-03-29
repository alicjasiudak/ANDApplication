package com.example.wellbeingtracker.ui.yoga;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class YogaViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public YogaViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Get free of all stress and negativity through yoga.");
    }

    public LiveData<String> getText() {
        return mText;
    }
}