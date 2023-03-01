package students;

import java.util.List;

public class Runnable {
    public static void main (String [] arg){
        StudentService sc = new StudentService();
        List<Student> studentList = sc.addStudentOnTheList();
        List<Student> searchedStudents = sc.searchStudents(studentList);
        sc.finalNote(searchedStudents);
    }
}
