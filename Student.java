package exercise03;

import java.util.Arrays;

public class Student {
    private String name;
    private Integer[] notes = new Integer[3];


    public Student(){}

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Integer[] getNotes() {
        return notes;
    }
    public void setNotes(Integer[] notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", notes=" + Arrays.toString(notes) +
                '}';
    }
}
