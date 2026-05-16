package main;

import java.util.ArrayList;
import java.util.List;
import file.FileManagement;
import model.Student;

public class Main {

    public static void main(String[] args) {

        FileManagement fileManagement = new FileManagement();

        List<Student> students = new ArrayList<>();

        students.add(new Student("Ali", 1, 20, "IT", 4.5, 2));
        students.add(new Student("Sara", 2, 21, "CS", 4.8, 3));
        students.add(new Student("Omar", 3, 22, "SE", 4.2, 4));

        fileManagement.saveStudents(students);

        List<Student> loaded = fileManagement.loadStudents();

        System.out.println("---- Students ----");

        for (Student s : loaded) {
            System.out.println(
                    "Name: " + s.getName()
                    + " | ID: " + s.getId()
                    + " | Dept: " + s.getDepartment()
                    + " | GPA: " + s.getGpa()
            );
        }
    }
}
