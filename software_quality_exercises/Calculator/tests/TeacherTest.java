
import CalculateTypes.Arithmetic;
import CalculateTypes.Weighted;
import Semester.Exam;
import Semester.Teacher;
import Semester.Student;
import exceptions.InvalidScoreException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TeacherTest {

    Teacher teacher;
    Student student;
    ArrayList<Exam> exams;
    ArrayList<Student> students;
    Map<Student, ArrayList<Exam>> studentWithExam;

    @Before
    public void setUp() {
        teacher = new Teacher();
        student = new Student();
        exams = new ArrayList<Exam>();
        students = new ArrayList<Student>();
    }

    @Test
    public void createExam() {
        Assert.assertTrue(teacher.createExam(10) instanceof Exam);
    }

    @Test
    public void giveExamToStudents() {
        exams.add(teacher.createExam(10));

        students.add(new Student());
        students.add(new Student());
        studentWithExam = teacher.giveExamsToStudents(students, exams);

        Map<Student, ArrayList<Exam>> expected = new HashMap<Student, ArrayList<Exam>>();
        expected.put(students.get(0), exams);
        expected.put(students.get(1), exams);

        Assert.assertEquals(expected, studentWithExam);
    }

    @Test
    public void set7ToStudentScore() {
        exams.add(teacher.createExam(10));
        students.add(student);
        studentWithExam = teacher.giveExamsToStudents(students, exams);
        teacher.setScoreToStudentExam(student, 0, 7.0);
        Double resultedScore = studentWithExam.get(student).get(0).getScore();

        Assert.assertEquals(7.0, resultedScore, 0.1);
    }

    @Test(expected = InvalidScoreException.class)
    public void throwExceptionIfScoreLessThan0() {
        exams.add(teacher.createExam(10));
        students.add(student);
        studentWithExam = teacher.giveExamsToStudents(students, exams);
        teacher.setScoreToStudentExam(student, 0, -3.0);
    }

    @Test(expected = InvalidScoreException.class)
    public void throwExceptionIfScoreMoreThan10() {
        exams.add(teacher.createExam(10));
        students.add(student);
        studentWithExam = teacher.giveExamsToStudents(students, exams);
        teacher.setScoreToStudentExam(student, 0, 11.0);
    }

    @Test(expected = InvalidScoreException.class)
    public void throwExceptionIfScoreMoreThanMaxScore() {
        exams.add(teacher.createExam(5));
        students.add(student);
        studentWithExam = teacher.giveExamsToStudents(students, exams);
        teacher.setScoreToStudentExam(student, 0, 6.0);
    }

    @Test
    public void get6_3FinalResultOfAStudentWithAritmethicCalc() {
        students.add(student);
        exams.add(teacher.createExam(10));
        exams.add(teacher.createExam(10));
        exams.add(teacher.createExam(10));

        studentWithExam = teacher.giveExamsToStudents(students, exams);

        teacher.setScoreToStudentExam(student, 0, 9.0);
        teacher.setScoreToStudentExam(student, 1, 3.0);
        teacher.setScoreToStudentExam(student, 2, 7.0);

        Double resulted = teacher.calculateResultFrom(student, new Arithmetic());
        Assert.assertEquals(6.3, resulted, 0.1);
    }

    @Test
    public void get1_33FinalResultOfAStudentWithWeightedCalc() {
        students.add(student);
        exams.add(teacher.createExam(10));
        exams.add(teacher.createExam(10).setWeight(1.5));
        exams.add(teacher.createExam(10).setWeight(1.7));

        studentWithExam = teacher.giveExamsToStudents(students, exams);

        teacher.setScoreToStudentExam(student, 0, 9.0);
        teacher.setScoreToStudentExam(student, 1, 3.0);
        teacher.setScoreToStudentExam(student, 2, 7.0);

        Double resulted = teacher.calculateResultFrom(student, new Weighted());
        Assert.assertEquals(1.33, resulted, 0.1);
    }

}
