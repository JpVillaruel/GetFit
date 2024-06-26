package com.example.getfit.Home.Chest;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.getfit.R;

import java.util.ArrayList;


public class ChestRoutines extends AppCompatActivity {


    ArrayList<ChestItem> chestExerciseItems = new ArrayList<>();

    int[] chestExerciseVid = {R.raw.push_ups,R.raw.box_push_ups,R.raw.cobra_stretch,R.raw.diamond_pushup,R.raw.pushup_with_rotation,
            R.raw.spiderman_pushup,R.raw.raise_leg_pushup,R.raw.mountain_climber,R.raw.decline_pushup,R.raw.incline_pushups,};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chest_routines);

                //      Toolbar Code        //
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() !=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        toolbar.setNavigationOnClickListener(view -> finish());


        //      RecyclerView code for items     //

        RecyclerView recyclerView = findViewById(R.id.chestRecyclerView);

        setChestExerciseItems();

        ChestAdapter adapter = new ChestAdapter(this, chestExerciseItems);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setChestExerciseItems(){
        String[] chestExerciseName = getResources().getStringArray(R.array.ChestExerciseName);
        String[] chestExerciseReps = getResources().getStringArray(R.array.ChestExerciseReps);

        for (int i = 0; i < chestExerciseName.length; i++){
            chestExerciseItems.add(new ChestItem(chestExerciseName[i], chestExerciseReps[i], chestExerciseVid[i]));
        }

    }
}