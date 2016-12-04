
import CalculateTypes.Arithmetic;
import Semester.Bulletin;
import Semester.Exam;
import Semester.Teacher;
import Semester.Student;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Map;

public class BulletinTest {

    Teacher teacher;
    ArrayList<Exam> exams;
    ArrayList<Student> students;
    Map<Student, ArrayList<Exam>> studentWithExam;
    Student student;

    @Before
    public void setUp() {
        this.teacher = new Teacher();
        this.exams = new ArrayList<Exam>();
        this.students = new ArrayList<Student>();

        student = new Student();
        students.add(student);
        exams.add(teacher.createExam(10));
        exams.add(teacher.createExam(10));
        exams.add(teacher.createExam(10));

        studentWithExam = teacher.giveExamsToStudents(students, exams);
    }

    @Test
    public void showMessageApprovedIfFinalScoreMoreOrEqualThan7() {
        String expectedMessage = "Approved";
        teacher.setScoreToStudentExam(student, 0, 9.0);
        teacher.setScoreToStudentExam(student, 1, 5.0);
        teacher.setScoreToStudentExam(student, 2, 7.0);

        teacher.calculateResultFrom(student, new Arithmetic());

        Assert.assertEquals(expectedMessage, new Bulletin(teacher).getResult(student));
    }

    @Test
    public void showMessageReprovedIfFinalScoreLessOrEqualThan5() {
        String expectedMessage = "Reproved";
        teacher.setScoreToStudentExam(student, 0, 3.0);
        teacher.setScoreToStudentExam(student, 1, 2.0);
        teacher.setScoreToStudentExam(student, 2, 7.0);

        teacher.calculateResultFrom(student, new Arithmetic());
        Bulletin bulletin = new Bulletin(teacher);
        Assert.assertEquals(expectedMessage, bulletin.getResult(student));
    }

    @Test
    public void showMessageInExamIfFinalScoreBetween5And6_9() {
        String expectedMessage = "In Exam";
        teacher.setScoreToStudentExam(student, 0, 8.0);
        teacher.setScoreToStudentExam(student, 1, 5.0);
        teacher.setScoreToStudentExam(student, 2, 4.0);

        teacher.calculateResultFrom(student, new Arithmetic());

        Assert.assertEquals(expectedMessage, new Bulletin(teacher).getResult(student));
    }
}
