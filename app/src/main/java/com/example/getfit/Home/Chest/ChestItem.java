package com.example.getfit.Home.Chest;

public class ChestItem {

    String chestExerciseName, chestExerciseReps;
    int chestExerciseVid;

    public ChestItem(String chestExerciseName, String chestExerciseReps, int chestExerciseVid) {
        this.chestExerciseName = chestExerciseName;
        this.chestExerciseReps = chestExerciseReps;
        this.chestExerciseVid = chestExerciseVid;
    }

    public String getChestExerciseName() {
        return chestExerciseName;
    }

    public String getChestExerciseReps() {
        return chestExerciseReps;
    }

    public int getChestExerciseVid() {
        return chestExerciseVid;
    }
}
