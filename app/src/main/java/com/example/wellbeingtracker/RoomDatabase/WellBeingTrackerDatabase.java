package com.example.wellbeingtracker.RoomDatabase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.wellbeingtracker.Model.Calories;

@Database(entities = {Calories.class}, version = 5, exportSchema = false)
public abstract class WellBeingTrackerDatabase extends RoomDatabase {

    private static WellBeingTrackerDatabase instance;

    public abstract CaloriesDao caloriesDao();

    public static synchronized WellBeingTrackerDatabase getInstance(Context context){
        if(instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    WellBeingTrackerDatabase.class, "wellbeing_tracker_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

}
