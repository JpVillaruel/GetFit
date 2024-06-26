package com.example.getfit.Home.Abs;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.getfit.R;

import java.util.ArrayList;

public class AbsRoutines extends AppCompatActivity {

    ArrayList<AbsItem> absExerciseItem = new ArrayList<>();

    int[] absExerciseVid = {R.raw.reverse_crunches, R.raw.leg_raises, R.raw.high_plank, R.raw.cobra_stretch,
            R.raw.push_ups,R.raw.bridge,R.raw.scissors,R.raw.high_kness_running};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abs_routines);

        //      Toolbar Code        //

        Toolbar toolbar = findViewById(R.id.toolbarrrr);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() !=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        toolbar.setNavigationOnClickListener(view -> finish());

        //      Recyclerview Code for items        //
        RecyclerView recyclerView = findViewById(R.id.absRecyclerView);

        setAbsExerciseItems();

        AbsAdapter adapter = new AbsAdapter(this, absExerciseItem);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void setAbsExerciseItems(){
        String[] absExerciseName = getResources().getStringArray(R.array.AbsExerciseName);
        String[] absExerciseReps = getResources().getStringArray(R.array.AbsExerciseReps);

        for (int i = 0; i < absExerciseName.length; i++){
            absExerciseItem.add(new AbsItem(absExerciseName[i], absExerciseReps[i], absExerciseVid[i]));
        }
    }
}