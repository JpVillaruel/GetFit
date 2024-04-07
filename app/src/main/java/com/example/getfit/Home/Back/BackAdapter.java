package com.example.getfit.Home.Back;

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

public class BackAdapter extends RecyclerView.Adapter<BackAdapter.backViewHolder> {

    Context context;
    ArrayList<BackItem> backItems;

    public BackAdapter(Context context, ArrayList<BackItem> backItems){
        this.context = context;
        this.backItems = backItems;
    }
    @NonNull
    @Override
    public BackAdapter.backViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_back, parent, false);
        return new BackAdapter.backViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BackAdapter.backViewHolder holder, int position) {
        holder.backExerciseName.setText(backItems.get(position).backExerciseName);
        holder.backExerciseReps.setText(backItems.get(position).backExerciseReps);
        holder.backExerciseView.setImageResource(backItems.get(position).backExerciseVid);
    }

    @Override
    public int getItemCount() {
        return backItems.size();
    }

    public static class backViewHolder extends RecyclerView.ViewHolder{

        ImageView backExerciseView;
        TextView backExerciseName, backExerciseReps;

        public backViewHolder(@NonNull View itemView) {
            super(itemView);

            backExerciseView = itemView.findViewById(R.id.BackExercisePic);
            backExerciseName = itemView.findViewById(R.id.BackExerciseName);
            backExerciseReps = itemView.findViewById(R.id.BackExerciseReps);
        }
    }
}
