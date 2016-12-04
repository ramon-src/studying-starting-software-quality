package Semester;

import java.util.ArrayList;

public class Student {
    private ArrayList<Double> scores;

    public Student() {
        scores = new ArrayList<Double>();
    }

    public void addScore(Double score) {
        scores.add(score);
    }

    public ArrayList<Double> getScores() {
        return scores;
    }
}
