import java.util.ArrayList;
import java.util.List;

class Student {
    private int id;
    private String name;
    private int age;

    // Constructor
    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    // Print student details
    public void printInfo() {
        System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age);
    }
}

class StudentManager {
    private List<Student> students = new ArrayList<>();

    // Add new student
    public void addStudent(Student s) {
        students.add(s);
        System.out.println("Student added: " + s);
    }

    // Display all students
    public void showAllStudents() {
        System.out.println("\nAll Students:");
        for (Student s : students) {
            s.printInfo();
        }
    }
}

public class Main {
    public static void main(String[] args) {

        StudentManager manager = new StudentManager();

        // Adding students
        manager.addStudent(new Student(101, "Rahul", 20));
        manager.addStudent(new Student(102, "Aisha", 19));
        manager.addStudent(new Student(103, "Karan", 22));

        // Show all
        manager.showAllStudents();
    }
}
