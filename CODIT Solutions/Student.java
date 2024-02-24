import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Student {
    private String name;
    private int rollNumber;
    private Map<String, Integer> subjectMarks;

    public Student(String name, int rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.subjectMarks = new HashMap<>();
    }

    public void addSubjectMark(String subject, int mark) {
        subjectMarks.put(subject, mark);
    }

    public void updateSubjectMark(String subject, int mark) {
        if (subjectMarks.containsKey(subject)) {
            subjectMarks.put(subject, mark);
        } else {
            System.out.println("Subject not found for this student.");
        }
    }

    public void deleteSubject(String subject) {
        if (subjectMarks.containsKey(subject)) {
            subjectMarks.remove(subject);
        } else {
            System.out.println("Subject not found for this student.");
        }
    }

    public double calculatePercentage() {
        if (subjectMarks.isEmpty()) {
            return 0;
        }
        int totalMarks = 0;
        for (int mark : subjectMarks.values()) {
            totalMarks += mark;
        }
        return (double) totalMarks / subjectMarks.size();
    }

    public String calculateGrade() {
        double percentage = calculatePercentage();
        if (percentage >= 90) {
            return "A";
        } else if (percentage >= 80) {
            return "B";
        } else if (percentage >= 70) {
            return "C";
        } else if (percentage >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String toString(){
        return this.name +" "+ this.rollNumber + this.subjectMarks.keySet() + this.subjectMarks.values();
    }
}

