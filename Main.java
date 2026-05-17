package main;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import file.FileManagement;
import model.Student;
import reports.ReportManager;
import threads.AutoSaveThread;
import threads.ReportThread;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        FileManagement fileManagement = new FileManagement();

        List<Student> students = new ArrayList<>();

        students.add(new Student("Ali", 1, 20, "IT", 4.5, 2));
        students.add(new Student("Sara", 2, 21, "CS", 4.8, 3));
        students.add(new Student("Omar", 3, 22, "SE", 4.2, 4));

        ReportManager reportManager =
                new ReportManager((ArrayList<Student>) students);

        int choice;

        do {

            System.out.println("\n===== SRMS MENU =====");
            System.out.println("1. View Students");
            System.out.println("2. GPA Report");
            System.out.println("3. Department Report");
            System.out.println("4. Year Report");
            System.out.println("5. Save Students");
            System.out.println("6. Load Students");
            System.out.println("7. Run Threads");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            choice = input.nextInt();

            switch (choice) {

                case 1:

                    System.out.println("\n---------------------------------------------------");
                    System.out.printf("%-5s %-10s %-15s %-5s\n",
                        "ID", "Name", "Department", "GPA");
                    System.out.println("---------------------------------------------------");

                   for (Student s : students) {

                    System.out.printf("%-5d %-10s %-15s %-5.2f\n",
                        s.getId(),
                        s.getName(),
                        s.getDepartment(),
                        s.getGpa());
}

                    System.out.println("---------------------------------------------------");

                    break;

                case 2:

                    reportManager.generateGPAReport();

                    break;

                case 3:

                    input.nextLine();

                    System.out.print("Enter Department: ");
                    String dept = input.nextLine();

                    reportManager.generateDepartmentReport(dept);

                    break;

                case 4:

                    System.out.println("\n===== YEAR REPORT =====");
                    System.out.println("Choose Academic Year:");
                    System.out.println("2 - Second Year");
                    System.out.println("3 - Third Year");
                    System.out.println("4 - Fourth Year");

                    System.out.print("Enter Year: ");
                    int year = input.nextInt();

                    reportManager.generateYearReport(year);

                    break;

                case 5:

                    fileManagement.saveStudents(students);

                    break;

                case 6:

                    students = fileManagement.loadStudents();

                    break;

                case 7:

                    AutoSaveThread autoSaveThread =
                            new AutoSaveThread(fileManagement);

                    ReportThread reportThread =
                            new ReportThread(reportManager);

                    autoSaveThread.start();
                    reportThread.start();

                    break;

                case 8:

                    System.out.println("Exiting System...");

                    break;

                default:

                    System.out.println("Invalid Choice!");

            }

        } while (choice != 8);

        input.close();
    }
}
