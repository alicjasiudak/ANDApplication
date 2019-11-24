package com.example.wellbeingtracker.ui;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;

import com.example.wellbeingtracker.Model.Advice;
import com.example.wellbeingtracker.R;
import com.example.wellbeingtracker.RoomDatabase.WellBeingTrackerRepository;
import com.example.wellbeingtracker.ui.advice.AdviceViewModel;
import com.example.wellbeingtracker.ui.calories.CaloriesViewModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class HomeActivity extends AppCompatActivity {

    private FirebaseAuth mFirebaseAuth;
    private Button updateAdvice;
    private AdviceViewModel adviceViewModel;
    private String shareThought;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_yoga, R.id.navigation_calories, R.id.navigation_exercises)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

        adviceViewModel = ViewModelProviders.of(this).get(AdviceViewModel.class);
        adviceViewModel.getAdvice().observe(this, new Observer<Advice>() {
            @Override
            public void onChanged(Advice advice) {
                shareThought = advice.getAdvice();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_menu, menu);
        return true;
    }

 public void logOut(MenuItem item) {
            FirebaseAuth.getInstance().signOut();
            Intent i = new Intent(HomeActivity.this, LoginActivity.class);
            startActivity(i);

        }

    public void share(MenuItem item) {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        String shareBody = shareThought;
        String shareSub = "subject";
        i.putExtra(Intent.EXTRA_SUBJECT, shareSub);
        i.putExtra(Intent.EXTRA_TEXT, shareBody);
        startActivity(Intent.createChooser(i, "Share via"));
    }
}
