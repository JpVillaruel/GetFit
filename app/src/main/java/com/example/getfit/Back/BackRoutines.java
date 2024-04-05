package com.example.getfit.Back;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.getfit.R;

public class BackRoutines extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back_routines);

        String RoutineDay = getIntent().getStringExtra("RoutineDays");
        String RoutineName = getIntent().getStringExtra("RoutineName");
        int RoutinePic = getIntent().getIntExtra("RoutinePic", 0);


    }
}