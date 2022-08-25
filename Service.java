package exercise03;

import javax.swing.*;
import java.util.ArrayList;

public class Service {
    public ArrayList<Student> service(){
        ArrayList<Student> list = new ArrayList<>();
        int op;
        do{
            list.add(createStudent());
            op = JOptionPane.showConfirmDialog(null,"Do you enter another student?");
        } while(op == 0);
        return list;
    }
    public Student createStudent(){
        Integer[] notes = new Integer[3];
        Student student = new Student();
        String name = JOptionPane.showInputDialog(null, "Enter student's name.");
        name = name.toUpperCase();
        student.setName(name);
        for (int i = 0; i < 3; i++) {
            int aux = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter note number " + (i + 1) + ":"));
            notes[i] = aux;
        }
        student.setNotes(notes);
        return student;
    }
    public int selectStudent(ArrayList<Student> listOfStudents){
        boolean flag = false;
        int index = 0;
        Student studentAux = new Student();
        while(!flag) {
            String name = JOptionPane.showInputDialog(null, "Enter a name to search.");
            name = name.toUpperCase();
            studentAux.setName(name);
            for (Student aux : listOfStudents) {
                studentAux.setName(name);
                if (listOfStudents.get(index).getName().equals(studentAux.getName())) {
                    flag = true;
                } else {
                    index = index + 1;
                }
            }
            if (!flag) {
                JOptionPane.showMessageDialog(null, "The student doesn't exist. Try again.");
                index = 0;
            }
        }
        return index;
    }
    public double finalNote(ArrayList<Student> listOfStudents, int index){
        double finalNote;
        Integer[] notes = listOfStudents.get(index).getNotes();
        finalNote = (notes[0] + notes[1] + notes[2]);
        finalNote = finalNote/3;
        finalNote = Math.round(finalNote * 100) / 100d;
        return finalNote;
    }
    public void print(double finalNote, ArrayList<Student> listOfStudents, int index){
        JOptionPane.showMessageDialog(null,"The final note of the student "+
                                        listOfStudents.get(index).getName()+" is: "+finalNote);
    }
}
