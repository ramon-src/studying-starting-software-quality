package Semester;

public class ScoreValidation {

    private static Double result;

    private ScoreValidation() {
    }

    public static void setResult(Double newResult) {
        result = newResult;
    }

    public static double getResult() {
        return result;
    }

    public static boolean isScoreInvalid(Double score, Double maxScore) {
        return ((score < 0 || score > 10) || score > maxScore) ? true : false;
    }

    public static boolean studentIsApproved() {
        return (result >= 7) ? true : false;
    }

    public static boolean studentIsInExam() {
        return (result >= 5 && result <= 6.9) ? true : false;
    }

    public static boolean studentIsReproved() {
        return (result < 5) ? true : false;
    }

    public static String showMessageOfResult() {
        if (studentIsApproved()) {
            return "Approved";
        } else if (studentIsInExam()) {
            return "In Exam";
        } else if (studentIsReproved()) {
            return "Reproved";
        }
        return "Não há resposta";
    }

}
