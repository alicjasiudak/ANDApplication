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
import androidx.recyclerview.widget.SimpleItemAnimator;

import com.example.wellbeingtracker.Model.YogaPose;
import com.example.wellbeingtracker.R;
import com.example.wellbeingtracker.ui.HomeActivity;

import java.util.ArrayList;

public class YogaFragment extends Fragment implements YogaPosesAdapter.OnListItemClickListener {

    private YogaViewModel yogaViewModel;
    RecyclerView yogaPosesList;
    RecyclerView.Adapter yogaPosesAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        yogaViewModel =
                ViewModelProviders.of(this).get(YogaViewModel.class);


        final HomeActivity c = (HomeActivity) getActivity();

        View root = inflater.inflate(R.layout.fragment_yoga, container, false);

        final TextView textView = root.findViewById(R.id.yogaFragmentTextView);
        yogaViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        yogaPosesList= root.findViewById(R.id.rv);
        yogaPosesList.hasFixedSize();
        yogaPosesList.setLayoutManager(new LinearLayoutManager(c));
        //Remove the blink
        ((SimpleItemAnimator) yogaPosesList.getItemAnimator()).setSupportsChangeAnimations(false);



        //add the yoga poses
        ArrayList<YogaPose> poses = new ArrayList<>();
        poses.add(new YogaPose("Mountain Pose", R.drawable.yoga1,"(tah-DAHS-anna)\n" +
                "tada = mountain\n" +
                "\t\u2022Improves posture.\n" +
                "\t\u2022Strengthens thighs, knees, and ankles.\n" +
                "\t\u2022Increases awareness."));
        poses.add(new YogaPose("Bow pose", R.drawable.yoga24, "Dhanurasana\n" +
                "\t\u2022Stretches the entire front of the body\n" +
                "\t\u2022Strengthens the back muscles\n" +
                "\t\u2022Stimulates the organs of the abdomen and neck"));
        poses.add(new YogaPose("Half moon pose", R.drawable.yoga2, "(are-dah chan-DRAHS-anna)\n" +
                "ardha = half\n" +
                "candra = glittering, shining, having the brilliancy or hue of light (said of the gods); usually translated as \"moon\""));
        poses.add(new YogaPose("Warrior I", R.drawable.yoga3, "Virabhadrasana I"));
        poses.add(new YogaPose("Crow pose", R.drawable.yoga22, "Parsva Bakasana\n"));
        poses.add(new YogaPose("Sun Salute", R.drawable.yoga4, "Urdhva Hastasana"));
        poses.add(new YogaPose("Triangle Pose", R.drawable.yoga5, "Utthita Trikonasana\n"));
        poses.add(new YogaPose("Full moon pose", R.drawable.yoga20, "Marichyasana III"));
        poses.add(new YogaPose("Wheel pose", R.drawable.yoga6, "Urdhva Dhanurasana"));
        poses.add(new YogaPose("Warrior II", R.drawable.yoga19, "Virabhadrasana III"));
        poses.add(new YogaPose("Downward facing dog", R.drawable.yoga7, "Adho Mukha Svanasana"));
        poses.add(new YogaPose("Puppy dog pose", R.drawable.yoga18, "Uttana Shishosana"));
        poses.add(new YogaPose("Intense side stretch", R.drawable.yoga9, "Parsvottanasana"));



        yogaPosesAdapter = new YogaPosesAdapter(poses, this);
        yogaPosesList.setAdapter(yogaPosesAdapter);


        return root;
    }

    @Override
    public void onListItemClick(int clickedItemIndex) {

    }
}