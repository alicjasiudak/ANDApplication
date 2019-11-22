package com.example.wellbeingtracker.ui.calories;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.wellbeingtracker.Model.Calories;
import com.example.wellbeingtracker.R;

import java.util.List;

public class CaloriesFragment extends Fragment {

    private CaloriesViewModel caloriesViewModel;
    private EditText editText;
    private TextView textView;
    private Button addButton;
    private Button deleteButton;
    private TextView totalCalories;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        caloriesViewModel = ViewModelProviders.of(this).get(CaloriesViewModel.class);

        View root = inflater.inflate(R.layout.fragment_calories, container, false);
        editText = root.findViewById(R.id.caloriesEditText);
        textView = root.findViewById(R.id.caloriesInsertedTextView);
        addButton = root.findViewById(R.id.addCaloriesButton);
        deleteButton =root.findViewById(R.id.delete_all);
        totalCalories = root.findViewById(R.id.totalCalories);

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                caloriesViewModel.deleteAllCalories();
            }
        });

        addButton.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                int i = Integer.parseInt(editText.getText().toString());
                caloriesViewModel.insert(new Calories(i , "description"));
            }
        });

        caloriesViewModel.getAllCalories().observe(this, new Observer<List<Calories>>() {
            @Override
            public void onChanged(List<Calories> calories) {
                if (!calories.isEmpty()) {
                    textView.setText("");
                    for (Calories c : calories) {
                        textView.append(c.getAmount() + "\n");
                    }
                } else {
                    textView.setText("No calories inserted");
                }
            }
        });
        return root;
    }

}