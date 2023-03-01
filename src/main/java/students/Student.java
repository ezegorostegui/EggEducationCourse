package students;


import java.util.Arrays;
import java.util.Objects;

/**
 * Crear una clase llamada Alumno que mantenga información sobre las notas de distintos
 * alumnos. La clase Alumno tendrá como atributos, su nombre y una lista de tipo Integer
 * con sus 3 notas.
 * En el servicio de Alumno deberemos tener un bucle que crea un objeto Alumno. Se pide
 * toda la información al usuario y ese Alumno se guarda en una lista de tipo Alumno y se le
 * pregunta al usuario si quiere crear otro Alumno o no.
 * Después de ese bucle tendremos el siguiente método en el servicio de Alumno:
 * Método notaFinal(): El usuario ingresa el nombre del alumno que quiere calcular su nota
 * final y se lo busca en la lista de Alumnos. Si está en la lista, se llama al método. Dentro
 * del método se usará la lista notas para calcular el promedio final de alumno. Siendo este
 * promedio final, devuelto por el método y mostrado en el main.
 */
public class Student {
    private String name;
    private Integer[] notes = new Integer[3];


    public Student() {
    }

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return name.equals(student.name) && Arrays.equals(notes, student.notes);
    }
    @Override
    public int hashCode() {
        int result = Objects.hash(name);
        result = 31 * result + Arrays.hashCode(notes);
        return result;
    }
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", notes=" + Arrays.toString(notes) +
                '}';
    }
}
