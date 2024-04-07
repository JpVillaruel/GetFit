package com.example.getfit.Home.Arm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.getfit.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ArmAdapter extends RecyclerView.Adapter<ArmAdapter.armViewHolder> {

    Context context;
    ArrayList<ArmItem> armItems;

    public ArmAdapter(Context context, ArrayList<ArmItem> armItems){
        this.context = context;
        this.armItems = armItems;
    }

    @NonNull
    @Override
    public ArmAdapter.armViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_arm, parent, false);
        return new ArmAdapter.armViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArmAdapter.armViewHolder holder, int position) {
        holder.armExerciseView.setImageResource(armItems.get(position).ArmExerciseVid);
        holder.armExerciseName.setText(armItems.get(position).ArmExerciseName);
        holder.armExerciseReps .setText(armItems.get(position).ArmExerciseReps);
    }

    @Override
    public int getItemCount() {
        return armItems.size();
    }

    public static class armViewHolder extends RecyclerView.ViewHolder{

        ImageView armExerciseView;
        TextView armExerciseName, armExerciseReps;

        public armViewHolder(@NonNull View itemView) {
            super(itemView);

            armExerciseView = itemView.findViewById(R.id.armExercisePic);
            armExerciseName = itemView.findViewById(R.id.armExerciseName);
            armExerciseReps = itemView.findViewById(R.id.armExerciseReps);
        }
    }
}
