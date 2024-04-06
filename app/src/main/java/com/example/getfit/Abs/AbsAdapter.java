package com.example.getfit.Abs;

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

public class AbsAdapter extends RecyclerView.Adapter<AbsAdapter.absViewHolder> {

    Context context;
    ArrayList<AbsItem> absItems;

    public AbsAdapter(Context context, ArrayList<AbsItem> absItems){
        this.context = context;
        this.absItems = absItems;
    }
    @NonNull
    @Override
    public AbsAdapter.absViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_abs, parent, false);
        return new AbsAdapter.absViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AbsAdapter.absViewHolder holder, int position) {
        holder.absExerciseVid.setImageResource(absItems.get(position).absExerciseVid);
        holder.absExerciseName.setText(absItems.get(position).absExerciseName);
        holder.absExerciseReps .setText(absItems.get(position).absExerciseReps);
    }

    @Override
    public int getItemCount() {
        return absItems.size();
    }

    public static class absViewHolder extends RecyclerView.ViewHolder{

        TextView absExerciseName, absExerciseReps;
        ImageView absExerciseVid;

        public absViewHolder(@NonNull View itemView) {
            super(itemView);

            absExerciseVid = itemView.findViewById(R.id.absExercisePic);
            absExerciseName = itemView.findViewById(R.id.absExerciseName);
            absExerciseReps = itemView.findViewById(R.id.absExerciseReps);

        }
    }
}
