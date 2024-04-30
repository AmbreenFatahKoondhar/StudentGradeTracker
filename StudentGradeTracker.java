import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class StudentGradeTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();

        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();

        List<Student> students = new ArrayList<>();

        for (int i = 0; i < numStudents; i++) {
            System.out.println("\nEnter details for Student " + (i + 1));
            System.out.print("Name: ");
            String name = scanner.next();

            Map<String, Integer> subjectGrades = new HashMap<>();
            for (int j = 0; j < numSubjects; j++) {
                System.out.print("Enter grade for Subject " + (j + 1) + ": ");
                int grade = scanner.nextInt();
                subjectGrades.put("Subject " + (j + 1), grade);
            }

            students.add(new Student(name, subjectGrades));
        }

        System.out.println("\n\nMark Sheet\n");

        for (Student student : students) {
            System.out.println("Name: " + student.getName());
            System.out.println("Subjects\tMarks");

            int totalMarks = 0;
            for (Map.Entry<String, Integer> entry : student.getSubjectGrades().entrySet()) {
                System.out.println(entry.getKey() + "\t\t" + entry.getValue());
                totalMarks += entry.getValue();
            }

            double averageMarks = (double) totalMarks / numSubjects;
            System.out.println("Total Marks: " + totalMarks);
            System.out.println("Average Marks: " + String.format("%.2f", averageMarks));
            System.out.println("Grade: " + calculateGrade(averageMarks));
            System.out.println();
        }
    }

    private static String calculateGrade(double averageMarks) {
        if (averageMarks >= 90) {
            return "A+";
        } else if (averageMarks >= 80) {
            return "A";
        } else if (averageMarks >= 70) {
            return "B";
        } else if (averageMarks >= 60) {
            return "C";
        } else if (averageMarks >= 50) {
            return "D";
        } else {
            return "F";
        }
    }
}

class Student {
    private String name;
    private Map<String, Integer> subjectGrades;

    public Student(String name, Map<String, Integer> subjectGrades) {
        this.name = name;
        this.subjectGrades = subjectGrades;
    }

    public String getName() {
        return name;
    }

    public Map<String, Integer> getSubjectGrades() {
        return subjectGrades;
    }
}
