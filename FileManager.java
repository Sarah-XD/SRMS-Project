package file;

import java.io.*;
import java.util.*;
import model.Student;

public class FileManager {

    private static final String FILE_NAME = "students.txt";

    // SAVE
    public void saveStudents(List<Student> students) {

        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {

            for (Student s : students) {
                writer.println(
                        s.getName() + "," +
                        s.getId() + "," +
                        s.getAge() + "," +
                        s.getDepartment() + "," +
                        s.getGpa() + "," +
                        s.getYear()
                );
            }

            System.out.println("Saved successfully");

        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }

    // LOAD
    public List<Student> loadStudents() {

        List<Student> students = new ArrayList<>();

        try (Scanner sc = new Scanner(new File(FILE_NAME))) {

            while (sc.hasNextLine()) {

                String line = sc.nextLine();
                String[] data = line.split(",");

                Student s = new Student(
                        data[0],
                        Integer.parseInt(data[1]),
                        Integer.parseInt(data[2]),
                        data[3],
                        Double.parseDouble(data[4]),
                        Integer.parseInt(data[5])
                );

                students.add(s);
            }

            System.out.println("Loaded successfully");

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        return students;
    }
}