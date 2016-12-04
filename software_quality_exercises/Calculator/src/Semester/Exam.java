package Semester;

public class Exam {
    private Double score;
    private Double maxScore;
    private Double weight;

    public Exam() {
        this.maxScore = 10.0;
        this.weight = 1.0;
    }

    public Exam(Double maxScore, Double weight) {
        this.maxScore = maxScore;
        this.weight = weight;
    }

    public Exam setScore(Double score) {
        this.score = score;
        return this;
    }

    public Double getScore() {
        return score;
    }

    public Exam setMaxScore(Double maxScore) {
        this.maxScore = maxScore;
        return this;
    }

    public Double getMaxScore() {
        return maxScore;
    }

    public Double getWeight() {
        return weight;
    }

    public Exam setWeight(Double weight) {
        this.weight = weight;
        return this;
    }
}
