package com.example.getfit.Home.Leg;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.getfit.R;

import java.util.ArrayList;

public class LegRoutines extends AppCompatActivity {

    ArrayList<LegItem> legItems = new ArrayList<>();

    int[] legExerciseVid = {R.raw.scissors,R.raw.high_kness_running,R.raw.squat,R.raw.wallsit,R.raw.plie_squat,
            R.raw.punches,R.raw.straigth_rigth_leg_raises,R.raw.straigth_left_leg_raises};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leg_routines);

        //      Toolbar Code        //

        Toolbar toolbar = findViewById(R.id.toolbarrrrr);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() !=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        toolbar.setNavigationOnClickListener(view -> finish());

        //      Recyclerview Code for item        //
        RecyclerView recyclerView = findViewById(R.id.legRecyclerView);
        setLegExerciseItems();

        LegAdapter adapter = new LegAdapter(this, legItems);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void setLegExerciseItems(){
        String[] legExerciseName = getResources().getStringArray(R.array.LegExerciseName);
        String[] legExerciseReps = getResources().getStringArray(R.array.LegExerciseReps);

        for (int i = 0; i < legExerciseName.length; i++){
            legItems.add(new LegItem(legExerciseName[i], legExerciseReps[i], legExerciseVid[i]));
        }
    }
}