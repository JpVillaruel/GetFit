package com.example.getfit.Home.Abs;

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
        holder.absExerciseName.setText(absItems.get(position).absExerciseName);
        holder.absExerciseReps .setText(absItems.get(position).absExerciseReps);
        LottieCompositionFactory.fromRawRes(context, absItems.get(position).getAbsExerciseVid())
                .addListener(result -> {
                    holder.absExerciseVid.setComposition(result);
                    holder.absExerciseVid.playAnimation();
                });
        holder.cardView.setOnClickListener(view -> {
            // Show dialog fragment with clicked animation
            LottieAnimationDialogFragment dialogFragment = LottieAnimationDialogFragment.newInstance(absItems.get(position).getAbsExerciseVid());
            dialogFragment.show(((AppCompatActivity) context).getSupportFragmentManager(), "LottieAnimationDialogFragment");
        });
    }

    @Override
    public int getItemCount() {
        return absItems.size();
    }

    public static class absViewHolder extends RecyclerView.ViewHolder{

        CardView cardView;
        TextView absExerciseName, absExerciseReps;
        LottieAnimationView absExerciseVid;

        public absViewHolder(@NonNull View itemView) {
            super(itemView);

            cardView = itemView.findViewById(R.id.exercises);
            absExerciseVid = itemView.findViewById(R.id.absExerciseVid);
            absExerciseName = itemView.findViewById(R.id.absExerciseName);
            absExerciseReps = itemView.findViewById(R.id.absExerciseReps);

        }
    }
}
