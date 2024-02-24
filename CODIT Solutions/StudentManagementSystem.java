//Task 3 >>> Student Grade Management System

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StudentManagementSystem {
    private static Map<Integer, Student> students = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            System.out.println("1. Add Student\n2. Update Student\n3. Delete Student\n4. Calculate Percentage and Grade\n5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    updateStudent();
                    break;
                case 3:
                    deleteStudent();
                    break;
                case 4:
                    calculatePercentageAndGrade();
                    break;
                case 5:
                    exit = true;
                    break;
                case 6:
                    // display();
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
    }

    private static void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student roll number: ");
        int rollNumber = scanner.nextInt();
        Student student = new Student(name, rollNumber);
        students.put(rollNumber, student);
        System.out.println("Enter subject to add: ");
        String subject = scanner.next();
            System.out.print("Enter mark for subject " + subject + ": ");
            int mark = scanner.nextInt();
        student.addSubjectMark(subject, mark);
        System.out.println("Student added successfully.");
        System.out.println("Details : "+student);
    }

    private static void updateStudent() {
        System.out.print("Enter student roll number to update: ");
        int rollNumber = scanner.nextInt();
        if (students.containsKey(rollNumber)) {
            Student student = students.get(rollNumber);
            System.out.println("Enter subject to update: ");
            String subject = scanner.next();
            System.out.print("Enter new mark for subject " + subject + ": ");
            int mark = scanner.nextInt();
            student.updateSubjectMark(subject, mark);
            System.out.println("Subject mark updated successfully.");
            // display();
            System.out.println(student);
        } else {
            System.out.println("Student not found with given roll number.");
        }
    }

    private static void deleteStudent() {
        System.out.print("Enter student roll number to delete: ");
        int rollNumber = scanner.nextInt();
        if (students.containsKey(rollNumber)) {
            students.remove(rollNumber);
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Student not found with given roll number.");
        }
    }

    private static void calculatePercentageAndGrade() {
        System.out.print("Enter student roll number: ");
        int rollNumber = scanner.nextInt();
        if (students.containsKey(rollNumber)) {
            Student student = students.get(rollNumber);
            double percentage = student.calculatePercentage();
            String grade = student.calculateGrade();
            System.out.println("Percentage: " + percentage);
            System.out.println("Grade: " + grade);
        } else {
            System.out.println("Student not found with given roll number.");
        }
    }
}
