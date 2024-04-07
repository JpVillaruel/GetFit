package com.example.getfit.Home.Leg;

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

public class LegAdapter extends RecyclerView.Adapter<LegAdapter.legViewHolder> {

    Context context;
    ArrayList<LegItem> legItems;

    public LegAdapter(Context context, ArrayList<LegItem> legItems){
        this.context = context;
        this.legItems = legItems;
    }
    @NonNull
    @Override
    public LegAdapter.legViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_leg, parent ,false);
        return new LegAdapter.legViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LegAdapter.legViewHolder holder, int position) {
        holder.legExerciseVid.setImageResource(legItems.get(position).LegExerciseVid);
        holder.legExerciseName.setText(legItems.get(position).LegExerciseName);
        holder.legExerciseReps.setText(legItems.get(position).LegExerciseReps);
    }

    @Override
    public int getItemCount() {
        return legItems.size();
    }

    public static class legViewHolder extends RecyclerView.ViewHolder{

        TextView legExerciseName, legExerciseReps;
        ImageView legExerciseVid;

        public legViewHolder(@NonNull View itemView) {
            super(itemView);

            legExerciseName = itemView.findViewById(R.id.LegExerciseName);
            legExerciseReps = itemView.findViewById(R.id.LegExerciseReps);
            legExerciseVid = itemView.findViewById(R.id.LegExercisePic);

        }
    }
}
