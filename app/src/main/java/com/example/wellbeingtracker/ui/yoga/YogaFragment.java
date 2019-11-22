package com.example.wellbeingtracker.ui.yoga;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wellbeingtracker.Model.YogaPose;
import com.example.wellbeingtracker.R;
import com.example.wellbeingtracker.ui.HomeActivity;

import java.util.ArrayList;

public class YogaFragment extends Fragment {

    private YogaViewModel yogaViewModel;
    RecyclerView yogaPosesList;
    RecyclerView.Adapter yogaPosesAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        yogaViewModel =
                ViewModelProviders.of(this).get(YogaViewModel.class);


        //Can I do this to implement rv in fragment or is it not ok?
        final HomeActivity c = (HomeActivity) getActivity();

        View root = inflater.inflate(R.layout.fragment_yoga, container, false);

        final TextView textView = root.findViewById(R.id.waterFragmentTextView);
        yogaViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        yogaPosesList= root.findViewById(R.id.rv);
        yogaPosesList.hasFixedSize();

        //And then I put c as a parameter context instead of this?
        yogaPosesList.setLayoutManager(new LinearLayoutManager(c));


        //add the yoga poses
        ArrayList<YogaPose> poses = new ArrayList<>();
        poses.add(new YogaPose("Mountain Pose", R.drawable.yoga1));
        poses.add(new YogaPose("Bow pose", R.drawable.yoga24));
        poses.add(new YogaPose("Full moon pose", R.drawable.yoga2));
        poses.add(new YogaPose("Camel pose", R.drawable.yoga23));
        poses.add(new YogaPose("Warrior I", R.drawable.yoga3));
        poses.add(new YogaPose("Crow pose", R.drawable.yoga22));
        poses.add(new YogaPose("Sun Salute", R.drawable.yoga4));
        poses.add(new YogaPose("Lizard", R.drawable.yoga21));
        poses.add(new YogaPose("Triangle Pose", R.drawable.yoga5));
        poses.add(new YogaPose("Half moon pose", R.drawable.yoga20));
        poses.add(new YogaPose("Wheel pose", R.drawable.yoga6));
        poses.add(new YogaPose("Warrior II", R.drawable.yoga19));
        poses.add(new YogaPose("Downward facing dog", R.drawable.yoga7));
        poses.add(new YogaPose("Puppy dog pose", R.drawable.yoga18));
        poses.add(new YogaPose("Warrior III", R.drawable.yoga8));
        poses.add(new YogaPose("Chair pose", R.drawable.yoga17));
        poses.add(new YogaPose("Intense side stretch", R.drawable.yoga9));
        poses.add(new YogaPose("Upward facing dog", R.drawable.yoga16));
        poses.add(new YogaPose("Seated forward fold", R.drawable.yoga10));
        poses.add(new YogaPose("Dolphin pose", R.drawable.yoga15));
        poses.add(new YogaPose("Revolved triangle pose", R.drawable.yoga11));
        poses.add(new YogaPose("Ankle band pose", R.drawable.yoga14));
        poses.add(new YogaPose("Boat pose", R.drawable.yoga12));
        poses.add(new YogaPose("Tree pose", R.drawable.yoga13));


        yogaPosesAdapter = new YogaPosesAdapter(poses);
        yogaPosesList.setAdapter(yogaPosesAdapter);


        return root;
    }
}