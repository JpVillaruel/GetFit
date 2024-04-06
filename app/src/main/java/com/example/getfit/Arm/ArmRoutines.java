package com.example.getfit.Arm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.getfit.R;

import java.util.ArrayList;

public class ArmRoutines extends AppCompatActivity {


    ArrayList<ArmItem> armExerciseItems = new ArrayList<>();

    int[] armExerciseVid = {R.drawable.rest, R.drawable.rest, R.drawable.rest, R.drawable.rest, R.drawable.rest,
            R.drawable.rest, R.drawable.rest, R.drawable.rest,R.drawable.rest,R.drawable.rest};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arm_routines);

        //      Toolbar Code        //

        Toolbar toolbar = findViewById(R.id.toolbarrr);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() !=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        toolbar.setNavigationOnClickListener(view -> finish());

        //      Recyclerview Code for items        //
        RecyclerView recyclerView = findViewById(R.id.armRecyclerView);

        setArmExerciseItems();

        ArmAdapter adapter = new ArmAdapter(this,armExerciseItems);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void setArmExerciseItems(){
        String[] armExerciseName = getResources().getStringArray(R.array.ArmExerciseName);
        String[] armExerciseReps = getResources().getStringArray(R.array.ArmExerciseReps);

        for (int i = 0; i < armExerciseName.length; i++){
            armExerciseItems.add(new ArmItem(armExerciseName[i], armExerciseReps[i], armExerciseVid[i]));
        }
    }
}