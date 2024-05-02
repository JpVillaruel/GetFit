package com.example.getfit.Home.Leg;

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
        holder.legExerciseName.setText(legItems.get(position).LegExerciseName);
        holder.legExerciseReps.setText(legItems.get(position).LegExerciseReps);
        LottieCompositionFactory.fromRawRes(context, legItems.get(position).getLegExerciseVid())
                .addListener(result -> {
                    holder.legExerciseVid.setComposition(result);
                    holder.legExerciseVid.playAnimation();
                });
        holder.cardView.setOnClickListener(view -> {
            // Show dialog fragment with clicked animation
            LottieAnimationDialogFragment dialogFragment = LottieAnimationDialogFragment.newInstance(legItems.get(position).getLegExerciseVid());
            dialogFragment.show(((AppCompatActivity) context).getSupportFragmentManager(), "LottieAnimationDialogFragment");
        });
    }

    @Override
    public int getItemCount() {
        return legItems.size();
    }

    public static class legViewHolder extends RecyclerView.ViewHolder{

        CardView cardView;
        TextView legExerciseName, legExerciseReps;
        LottieAnimationView legExerciseVid;

        public legViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.exercises);
            legExerciseName = itemView.findViewById(R.id.LegExerciseName);
            legExerciseReps = itemView.findViewById(R.id.LegExerciseReps);
            legExerciseVid = itemView.findViewById(R.id.LegExerciseVid);

        }
    }
}
