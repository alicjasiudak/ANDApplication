package com.example.wellbeingtracker.ui.advice;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.wellbeingtracker.Model.Advice;
import com.example.wellbeingtracker.R;
import com.example.wellbeingtracker.ui.HomeActivity;

import static android.content.ContentValues.TAG;

public class AdviceFragment extends Fragment {

    private AdviceViewModel adviceViewModel;
    private Button updateButton;
    private TextView textView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        adviceViewModel = ViewModelProviders.of(this).get(AdviceViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_advice, container, false);

        textView = root.findViewById(R.id.text_advice);
        updateButton = root.findViewById(R.id.update_advice_button);

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adviceViewModel.updateAdvice();
                Log.d("tag", "it was clicked:");

            }
        });

        adviceViewModel.getAdvice().observe(this, new Observer<Advice>() {
            @Override
            public void onChanged(Advice advice) {
                textView.setText(advice.getAdvice());
            }
        });



        final TextView textView = root.findViewById(R.id.text_advice);

        setHasOptionsMenu(true);
        return root;
    }

    //Add extra button to toolbar
    @Override
    public void onCreateOptionsMenu(
            Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.share, menu);
    }



}
