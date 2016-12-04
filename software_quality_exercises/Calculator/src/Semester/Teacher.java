package Semester;

import CalculateTypes.Calculation;
import exceptions.InvalidScoreException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Teacher {
    private Map<Student, ArrayList<Exam>> studentExams;
    private Map<Student, Double> studentsFinalScore;

    public Teacher() {
        studentExams = new HashMap<Student, ArrayList<Exam>>();
        studentsFinalScore = new HashMap<Student, Double>();
    }

    public ArrayList<Exam> getStudentExams(Student student) {
        return studentExams.get(student);
    }

    public Double getStudentFinalScore(Student student) {
        return studentsFinalScore.get(student);
    }

    public Exam createExam(double max_score) {
        Exam newExam = new Exam();
        newExam.setMaxScore(max_score);
        return newExam;
    }

    public Map<Student, ArrayList<Exam>> giveExamsToStudents(ArrayList<Student> students, ArrayList<Exam> exams) {
        for (Student student : students) {
            studentExams.put(student, exams);
        }
        return studentExams;
    }

    public void setScoreToStudentExam(Student student, int id_exam, Double score) {
        Exam exam = studentExams.get(student).get(id_exam);
        if (ScoreValidation.isScoreInvalid(score, exam.getMaxScore())) {
            throw new InvalidScoreException();
        }
        exam.setScore(score);
    }

    public Double calculateResultFrom(Student student, Calculation calcMethod) {
        Map<Integer, Map<Double, Double>> scores = new HashMap<Integer, Map<Double, Double>>();
        int i = 0;
        for (Exam exam : studentExams.get(student)) {
            Map<Double, Double> map = new HashMap<Double, Double>();
            scores.put(i, map);
            scores.get(i).put(exam.getScore(), exam.getWeight());
            i++;
        }
        Double result = calcMethod.calculate(scores);
        studentsFinalScore.put(student, result);
        return result;
    }
}

