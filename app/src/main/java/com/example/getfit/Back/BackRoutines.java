package com.example.getfit.Back;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import com.example.getfit.R;

import java.util.ArrayList;

public class BackRoutines extends AppCompatActivity {

    ArrayList<BackItem> backExerciseItems = new ArrayList<>();

    int[] backExerciseVid = {R.drawable.rest, R.drawable.rest, R.drawable.rest, R.drawable.rest, R.drawable.rest,
            R.drawable.rest, R.drawable.rest, R.drawable.rest,R.drawable.rest,R.drawable.rest};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back_routines);

        //      Toolbar Code        //
        Toolbar toolbar = findViewById(R.id.toolbarr);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() !=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        toolbar.setNavigationOnClickListener(view -> finish());

        //      RecyclerView code for items     //
        RecyclerView recyclerView = findViewById(R.id.backRecyclerView);

        setBackExerciseItems();

        BackAdapter adapter = new BackAdapter(this, backExerciseItems);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setBackExerciseItems(){
        String[] backExerciseName = getResources().getStringArray(R.array.BackExerciseName);
        String[] backExerciseReps = getResources().getStringArray(R.array.BackExerciseReps);

        for (int i = 0; i < backExerciseName.length; i++){
            backExerciseItems.add(new BackItem(backExerciseName[i], backExerciseReps[i], backExerciseVid[i]));
        }

    }
}
