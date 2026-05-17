package reports;

import java.util.ArrayList;
import model.Student;

public class ReportManager {

    private ArrayList<Student> students;

    public ReportManager(ArrayList<Student> students) {
        this.students = students;
    }

    // GPA Report
    public void generateGPAReport() {

        System.out.println("\n===== GPA REPORT =====");

        for (Student s : students) {

            System.out.println(
                    "Name: " + s.getName()
                    + " | GPA: " + s.getGpa()
            );
        }
    }

    // Department Report
    public void generateDepartmentReport(String department) {

        System.out.println("\n===== DEPARTMENT REPORT =====");

        for (Student s : students) {

            if (s.getDepartment().equalsIgnoreCase(department)) {

                System.out.println(
                        "Name: " + s.getName()
                        + " | Department: " + s.getDepartment()
                );
            }
        }
    }

    // Year Report
    public void generateYearReport(int year) {

        System.out.println("\n===== YEAR REPORT =====");

        for (Student s : students) {

            if (s.getYear() == year) {

                System.out.println(
                        "Name: " + s.getName()
                        + " | Year: " + s.getYear()
                );
            }
        }
    }
}
