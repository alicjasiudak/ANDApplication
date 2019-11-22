package com.example.wellbeingtracker.RoomDatabase;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.wellbeingtracker.Model.Calories;

import java.util.List;

@Dao
public interface CaloriesDao {

    @Insert
    void insert(Calories Calories);

    @Update
    void update(Calories Calories);

    @Delete
    void delete(Calories Calories);

    @Query("DELETE FROM calories_table")
    void deleteAllCalories();

    @Query("SELECT * FROM calories_table")
    LiveData<List<Calories>> getAllCalories();

}
