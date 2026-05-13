package model;

public class Student extends Person {

    private String department;
    private double gpa;
    private int year;

    public Student() {
        super();
    }

    public Student(String name, int id, int age,
                   String department, double gpa, int year) {
        super(name, id, age);
        this.department = department;
        this.gpa = gpa;
        this.year = year;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}