package com.example.getfit.Home.Abs;

public class AbsItem {

    String absExerciseName, absExerciseReps;
    int absExerciseVid;

    public AbsItem(String absExerciseName, String absExerciseReps, int absExerciseVid) {
        this.absExerciseName = absExerciseName;
        this.absExerciseReps = absExerciseReps;
        this.absExerciseVid = absExerciseVid;
    }

    public String getAbsExerciseName() {
        return absExerciseName;
    }

    public String getAbsExerciseReps() {
        return absExerciseReps;
    }

    public int getAbsExerciseVid() {
        return absExerciseVid;
    }
}
