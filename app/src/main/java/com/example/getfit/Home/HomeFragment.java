package com.example.getfit.Home;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.getfit.Back.BackRoutines;
import com.example.getfit.Chest.ChestRoutines;
import com.example.getfit.R;

import java.util.ArrayList;

public class HomeFragment extends Fragment implements ExerciseInterface {

    ArrayList<ExerciseItem> exerciseItems = new ArrayList<>();

    int[] routinePic = {R.drawable.chest, R.drawable.back, R.drawable.abs, R.drawable.rest,
                        R.drawable.arm, R.drawable.leg, R.drawable.rest};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_home, container, false);


        RecyclerView recyclerView = v.findViewById(R.id.homeRecyclerView);
        setExerciseModels();

        ExerciseAdapter adapter = new ExerciseAdapter(getContext(), exerciseItems, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return v;
    }

    private void setExerciseModels(){
        String[] routineDays = getResources().getStringArray(R.array.routineDays);
        String[] routineName = getResources().getStringArray(R.array.routineName);

        for (int i = 0; i<routineDays.length; i++){
        exerciseItems.add(new ExerciseItem(routineDays[i],
                routineName[i],
                routinePic[i]));
        }
    }

    @Override
    public void onExerciseItemClick(int position) {
        Intent intent = null;

        switch (position) {
            case 0:
                intent = new Intent(getContext(), ChestRoutines.class);
                break;
            case 1:
                intent = new Intent(getContext(), BackRoutines.class);
                break;
            // Add more cases for additional items as needed

            default:
                Toast.makeText(getContext(), "Rest Day", Toast.LENGTH_SHORT).show();
                break;
        }


        if (intent != null) {
            intent.putExtra("RoutineDays", exerciseItems.get(position).getRoutineDays());
            intent.putExtra("RoutineName", exerciseItems.get(position).getRoutineName());
            intent.putExtra("RoutinePic", exerciseItems.get(position).getRoutinePic());

            startActivity(intent);
        }
    }
}