package com.example.getfit.Home.Back;

public class BackItem {

    String backExerciseName, backExerciseReps;
    int backExerciseVid;

    public BackItem(String backExerciseName, String backExerciseRoutine, int backExerciseVid) {
        this.backExerciseName = backExerciseName;
        this.backExerciseReps = backExerciseRoutine;
        this.backExerciseVid = backExerciseVid;
    }

    public String getBackExerciseName() {
        return backExerciseName;
    }

    public String getBackExerciseRoutine() {
        return backExerciseReps;
    }

    public int getBackExerciseVid() {
        return backExerciseVid;
    }
}
