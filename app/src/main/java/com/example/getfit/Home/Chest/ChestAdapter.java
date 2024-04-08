package com.example.getfit.Home.Chest;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.getfit.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ChestAdapter extends RecyclerView.Adapter<ChestAdapter.MyViewHolder> {

    Context context;
    ArrayList<ChestItem> chestItems;

    public ChestAdapter(Context context, ArrayList<ChestItem> chestItems){
        this.context = context;
        this.chestItems = chestItems;
    }

    @NonNull
    @Override
    public ChestAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_chest, parent, false);
        return new ChestAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChestAdapter.MyViewHolder holder, int position) {
        holder.chestExerciseName.setText(chestItems.get(position).chestExerciseName);
        holder.chestExerciseReps.setText(chestItems.get(position).chestExerciseReps);
        holder.chestExerciseView.setVideoURI(Uri.parse("android.resource://" + context.getPackageName() + "/" + chestItems.get(position).chestExerciseVid));
        holder.chestExerciseView.setOnPreparedListener(mediaPlayer -> {
            // Ensure looping
            mediaPlayer.setLooping(true);
        });

        // Set up video completion listener
        holder.chestExerciseView.setOnCompletionListener(mediaPlayer -> {
            // Restart video when completed
            holder.chestExerciseView.start();
        });
        holder.chestExerciseView.start();
    }

    @Override
    public int getItemCount() {
        return chestItems.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        VideoView chestExerciseView;
        TextView chestExerciseName, chestExerciseReps;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            chestExerciseView = itemView.findViewById(R.id.ChestExerciseVideo);
            chestExerciseName = itemView.findViewById(R.id.ChestExerciseName);
            chestExerciseReps = itemView.findViewById(R.id.ChestExerciseReps);
        }
    }
}
