package students;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StudentService {
    ArrayList<Student> studentList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    private final static Logger LOGGER = Logger.getLogger("student.StudentService");


    public ArrayList<Student> addStudentOnTheList(){
        boolean flag;
        do{
            studentList.add(createStudent());
            LOGGER.log(Level.INFO,"Do you want to add another student? Write true or false.");
            flag = scanner.nextBoolean();
        } while(flag);
        return studentList;
    }
    public void finalNote(List<Student> studentList){
        studentList.forEach(student -> calculateFinalNote(student.getNotes()));
    }
    public List<Student> searchStudents(List<Student> studentList){
        LOGGER.log(Level.INFO,"Enter the name of the student to search.");
        String name = scanner.next();
        return studentList.stream().filter(student -> student.getName().equals(name)).toList();
    }
    private Student createStudent(){
        Student student = new Student();
        Integer[] aux = new Integer[3];

        LOGGER.log(Level.INFO,"Enter student's name.");
        student.setName(scanner.next());
        for (int i=0; i<3 ; i++){
            LOGGER.log(Level.INFO,"Enter the note number " + (i+1) +" of the student");
            aux[i] = scanner.nextInt();
        }
        student.setNotes(aux);
        return student;
    }
    private void calculateFinalNote(Integer[] notes){
        double finalNote = (notes[0] + notes[1] + notes[2]);
        finalNote = finalNote/3;
        LOGGER.log(Level.INFO,"The final note is: "+ finalNote);
    }
}
