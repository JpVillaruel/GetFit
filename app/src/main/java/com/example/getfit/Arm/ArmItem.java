package com.example.getfit.Arm;

public class ArmItem {

    String ArmExerciseName, ArmExerciseReps;
    int ArmExerciseVid;

    public ArmItem(String armExerciseName, String armExerciseReps, int armExerciseVid) {
        ArmExerciseName = armExerciseName;
        ArmExerciseReps = armExerciseReps;
        ArmExerciseVid = armExerciseVid;
    }

    public String getArmExerciseName() {
        return ArmExerciseName;
    }

    public String getArmExerciseReps() {
        return ArmExerciseReps;
    }

    public int getArmExerciseVid() {
        return ArmExerciseVid;
    }
}
