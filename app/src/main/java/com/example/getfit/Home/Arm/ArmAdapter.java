package com.example.getfit.Home.Arm;

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
        holder.armExerciseName.setText(armItems.get(position).ArmExerciseName);
        holder.armExerciseReps .setText(armItems.get(position).ArmExerciseReps);
        LottieCompositionFactory.fromRawRes(context, armItems.get(position).getArmExerciseVid())
                .addListener(result -> {
                    holder.armExerciseView.setComposition(result);
                    holder.armExerciseView.playAnimation();
                });
        holder.cardView.setOnClickListener(view -> {
            // Show dialog fragment with clicked animation
            LottieAnimationDialogFragment dialogFragment = LottieAnimationDialogFragment.newInstance(armItems.get(position).getArmExerciseVid());
            dialogFragment.show(((AppCompatActivity) context).getSupportFragmentManager(), "LottieAnimationDialogFragment");
        });
    }

    @Override
    public int getItemCount() {
        return armItems.size();
    }

    public static class armViewHolder extends RecyclerView.ViewHolder{

        CardView cardView;
        LottieAnimationView armExerciseView;
        TextView armExerciseName, armExerciseReps;

        public armViewHolder(@NonNull View itemView) {
            super(itemView);

            cardView = itemView.findViewById(R.id.exercises);
            armExerciseView = itemView.findViewById(R.id.armExerciseVid);
            armExerciseName = itemView.findViewById(R.id.armExerciseName);
            armExerciseReps = itemView.findViewById(R.id.armExerciseReps);
        }
    }
}
