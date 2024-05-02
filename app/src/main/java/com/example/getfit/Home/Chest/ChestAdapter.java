package com.example.getfit.Home.Chest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieCompositionFactory;
import com.example.getfit.Home.LottieAnimationDialogFragment;
import com.example.getfit.R;

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
        LottieCompositionFactory.fromRawRes(context, chestItems.get(position).getChestExerciseVid())
                .addListener(result -> {
                    holder.chestExerciseView.setComposition(result);
                    holder.chestExerciseView.playAnimation();
                });
        holder.cardView.setOnClickListener(view -> {
            // Show dialog fragment with clicked animation
            LottieAnimationDialogFragment dialogFragment = LottieAnimationDialogFragment.newInstance(chestItems.get(position).getChestExerciseVid());
            dialogFragment.show(((AppCompatActivity) context).getSupportFragmentManager(), "LottieAnimationDialogFragment");
        });
    }

    @Override
    public int getItemCount() {
        return chestItems.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        CardView cardView;

        LottieAnimationView chestExerciseView;
        TextView chestExerciseName, chestExerciseReps;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            cardView = itemView.findViewById(R.id.exercises);
            chestExerciseView = itemView.findViewById(R.id.ChestExerciseVideo);
            chestExerciseName = itemView.findViewById(R.id.ChestExerciseName);
            chestExerciseReps = itemView.findViewById(R.id.ChestExerciseReps);
        }
    }
}
