package com.example.getfit.Home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.getfit.R;

import java.util.ArrayList;

public class ExerciseAdapter extends RecyclerView.Adapter<ExerciseAdapter.MyViewHolder> {

    private  final  ExerciseInterface exerciseInterface;
    Context context;
    ArrayList<ExerciseItem> exerciseItems;
    public ExerciseAdapter(Context context, ArrayList<ExerciseItem> exerciseItems, ExerciseInterface exerciseInterface){
        this.context = context;
        this.exerciseItems = exerciseItems;
        this.exerciseInterface = exerciseInterface;
    }

    @NonNull
    @Override
    public ExerciseAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_exercise, parent,false);


        return new ExerciseAdapter.MyViewHolder(view, exerciseInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull ExerciseAdapter.MyViewHolder holder, int position) {
        holder.tvDay.setText(exerciseItems.get(position).getRoutineDays());
        holder.tvRoutine.setText(exerciseItems.get(position).getRoutineName());
        holder.imgRoutine.setImageResource(exerciseItems.get(position).getRoutinePic());
    }

    @Override
    public int getItemCount() {
        return exerciseItems.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imgRoutine;
        TextView tvDay, tvRoutine;


        public MyViewHolder(@NonNull View itemView, ExerciseInterface exerciseInterface) {
            super(itemView);

            imgRoutine = itemView.findViewById(R.id.exPic);
            tvDay = itemView.findViewById(R.id.day);
            tvRoutine = itemView.findViewById(R.id.routine);

            itemView.setOnClickListener(v -> {
                if (exerciseInterface != null){
                    int pos = getAdapterPosition();

                    if (pos != RecyclerView.NO_POSITION){
                        exerciseInterface.onExerciseItemClick(pos);
                    }
                }
            });
        }
    }
}
