package com.example.getfit.Home.Back;

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
        LottieCompositionFactory.fromRawRes(context, backItems.get(position).getBackExerciseVid())
                .addListener(result -> {
                    holder.backExerciseView.setComposition(result);
                    holder.backExerciseView.playAnimation();
                });
        holder.cardView.setOnClickListener(view -> {
            // Show dialog fragment with clicked animation
            LottieAnimationDialogFragment dialogFragment = LottieAnimationDialogFragment.newInstance(backItems.get(position).getBackExerciseVid());
            dialogFragment.show(((AppCompatActivity) context).getSupportFragmentManager(), "LottieAnimationDialogFragment");
        });
    }

    @Override
    public int getItemCount() {
        return backItems.size();
    }

    public static class backViewHolder extends RecyclerView.ViewHolder{

        CardView cardView;
        LottieAnimationView backExerciseView;
        TextView backExerciseName, backExerciseReps;

        public backViewHolder(@NonNull View itemView) {
            super(itemView);

            cardView = itemView.findViewById(R.id.exercises);
            backExerciseView = itemView.findViewById(R.id.BackExerciseVid);
            backExerciseName = itemView.findViewById(R.id.BackExerciseName);
            backExerciseReps = itemView.findViewById(R.id.BackExerciseReps);
        }
    }
}
