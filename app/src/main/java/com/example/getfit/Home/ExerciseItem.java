package com.example.getfit.Home;

public class ExerciseItem {

    String routineDays;
    String routineName;
    int routinePic;

    public ExerciseItem(String routineDays, String routineName, int routinePic) {
        this.routineDays = routineDays;
        this.routineName = routineName;
        this.routinePic = routinePic;
    }

    public String getRoutineDays() {
        return routineDays;
    }

    public String getRoutineName() {
        return routineName;

    }

    public int getRoutinePic() {
        return routinePic;
    }
}
