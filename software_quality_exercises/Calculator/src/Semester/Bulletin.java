package Semester;

public class Bulletin {

    static Teacher teacher;

    public Bulletin(Teacher teacher) {
        this.teacher = teacher;
    }

    public static String getResult(Student student) {
        Double result = teacher.getStudentFinalScore(student);
        ScoreValidation.setResult(result);
        return ScoreValidation.showMessageOfResult();
    }

}
