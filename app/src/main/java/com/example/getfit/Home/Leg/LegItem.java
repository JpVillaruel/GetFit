package com.example.getfit.Home.Leg;

public class LegItem {

    String LegExerciseName, LegExerciseReps;
    int LegExerciseVid;

    public LegItem(String legExerciseName, String legExerciseReps, int legExerciseVid) {
        LegExerciseName = legExerciseName;
        LegExerciseReps = legExerciseReps;
        LegExerciseVid = legExerciseVid;
    }

    public String getLegExerciseName() {
        return LegExerciseName;
    }

    public String getLegExerciseReps() {
        return LegExerciseReps;
    }

    public int getLegExerciseVid() {
        return LegExerciseVid;
    }
}
