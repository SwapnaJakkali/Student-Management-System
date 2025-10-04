import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {
    private ArrayList<Student> students = new ArrayList<>();
    private static final int MAX_STUDENTS = 8;
    private static final String[] VALID_COURSES = {"CS", "ECE", "IT", "MECH", "CIVIL"};
    private Scanner sc = new Scanner(System.in);

    // Constructor adds predefined students
    public StudentManager() {
        students.add(new Student(1, "Ravi", "CS", 85));
        students.add(new Student(2, "Priya", "ECE", 92));
        
    }

    private boolean isValidCourse(String course) {
        for (String c : VALID_COURSES) {
            if (c.equalsIgnoreCase(course)) return true;
        }
        return false;
    }

    // Add Student
    public void addStudent() {
        if (students.size() >= MAX_STUDENTS) {
            System.out.println("Cannot add more than 8 students!");
            return;
        }

        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Student s : students) {
            if (s.getId() == id) {
                System.out.println("Student with this ID already exists!");
                return;
            }
        }

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Course (CS, ECE, IT, MECH, CIVIL): ");
        String course = sc.nextLine().toUpperCase();
        if (!isValidCourse(course)) {
            System.out.println("Invalid course! Allowed: CS, ECE, IT, MECH, CIVIL.");
            return;
        }

        System.out.print("Enter Marks: ");
        int marks = sc.nextInt();

        students.add(new Student(id, name, course, marks));
        System.out.println("Student added successfully!");
    }

    // View Students
    public void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found!");
            return;
        }
        System.out.println("\n===== Student List =====");
        System.out.printf("%-5s %-15s %-10s %-5s%n", "ID", "Name", "Course", "Marks");
        for (Student s : students) {
            s.display();
        }
    }

    // Search Student
    public void searchStudent() {
        if (students.isEmpty()) {
            System.out.println("No students available!");
            return;
        }

        System.out.print("Enter ID or Name to search: ");
        String input = sc.nextLine().trim();

        boolean found = false;

        try {
            int id = Integer.parseInt(input);
            for (Student s : students) {
                if (s.getId() == id) {
                    System.out.printf("%-5s %-15s %-10s %-5s%n", "ID", "Name", "Course", "Marks");
                    s.display();
                    found = true;
                    break;
                }
            }
        } catch (NumberFormatException e) {
            // Search by name
            for (Student s : students) {
                if (s.getName().equalsIgnoreCase(input)) {
                    System.out.printf("%-5s %-15s %-10s %-5s%n", "ID", "Name", "Course", "Marks");
                    s.display();
                    found = true;
                    break;
                }
            }
        }

        if (!found) {
            System.out.println("Student not found!");
        }
    }

    //  Update Student
    public void updateStudent() {
        if (students.isEmpty()) {
            System.out.println("No students to update!");
            return;
        }

        System.out.print("Enter student ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Student s : students) {
            if (s.getId() == id) {
                System.out.println("1. Update Course");
                System.out.println("2. Update Marks");
                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();
                sc.nextLine();

                if (choice == 1) {
                    System.out.print("Enter new course: ");
                    String newCourse = sc.nextLine().toUpperCase();
                    if (isValidCourse(newCourse)) {
                        s.setCourse(newCourse);
                        System.out.println("Course updated successfully!");
                    } else {
                        System.out.println("Invalid course!");
                    }
                } else if (choice == 2) {
                    System.out.print("Enter new marks: ");
                    int newMarks = sc.nextInt();
                    s.setMarks(newMarks);
                    System.out.println("Marks updated successfully!");
                } else {
                    System.out.println("Invalid choice!");
                }
                return;
            }
        }
        System.out.println("Student ID not found!");
    }

    //  Delete Student
    public void deleteStudent() {
        if (students.isEmpty()) {
            System.out.println("No students to delete!");
            return;
        }

        System.out.print("Enter student ID to delete: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Student s : students) {
            if (s.getId() == id) {
                students.remove(s);
                System.out.println("Student deleted successfully!");
                return;
            }
        }

        System.out.println("Student not found!");
    }
}
