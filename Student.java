public class Student {

    private int id;
    private String name;
    private String course;
    private int totalClasses;
    private int presentClasses;

    public Student(int id, String name, String course) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.totalClasses = 0;
        this.presentClasses = 0;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    public void markPresent() {
        totalClasses++;
        presentClasses++;
    }

    public void markAbsent() {
        totalClasses++;
    }

    public double getAttendancePercentage() {

        if (totalClasses == 0) {
            return 0.0;
        }

        return (presentClasses * 100.0) / totalClasses;
    }

    public void displayStudent() {

        System.out.printf(
            "ID: %d | Name: %s | Course: %s | Present: %d | Total: %d | Attendance: %.2f%%%n",
            id,
            name,
            course,
            presentClasses,
            totalClasses,
            getAttendancePercentage()
        );
    }
}
```

### `StudentManagement.java`

```java
import java.util.ArrayList;

public class StudentManagement {

    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added successfully!");
    }

    public Student findStudent(int id) {

        for (Student student : students) {

            if (student.getId() == id) {
                return student;
            }
        }

        return null;
    }

    public void markAttendance(int id, boolean present) {

        Student student = findStudent(id);

        if (student == null) {
            System.out.println("Student not found!");
            return;
        }

        if (present) {
            student.markPresent();
            System.out.println("Student marked PRESENT.");
        } else {
            student.markAbsent();
            System.out.println("Student marked ABSENT.");
        }
    }

    public void displayAllStudents() {

        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        System.out.println("\n========== STUDENT ATTENDANCE ==========");

        for (Student student : students) {
            student.displayStudent();
        }
    }

    public void searchStudent(int id) {

        Student student = findStudent(id);

        if (student == null) {
            System.out.println("Student not found!");
        } else {
            System.out.println("\nStudent Details:");
            student.displayStudent();
        }
    }

    public void showLowAttendanceStudents() {

        boolean found = false;

        System.out.println("\n===== STUDENTS BELOW 75% ATTENDANCE =====");

        for (Student student : students) {

            if (student.getAttendancePercentage() < 75.0) {
                student.displayStudent();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No students are below 75% attendance.");
        }
    }
}
```

### `Main.java`

```java
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StudentManagement manager = new StudentManagement();

        while (true) {

            System.out.println("\n======================================");
            System.out.println(" STUDENT ATTENDANCE MANAGEMENT SYSTEM");
            System.out.println("======================================");

            System.out.println("1. Add Student");
            System.out.println("2. Mark Attendance");
            System.out.println("3. Display All Students");
            System.out.println("4. Search Student");
            System.out.println("5. Show Students Below 75%");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter Student ID: ");
                    int id = scanner.nextInt();

                    scanner.nextLine();

                    System.out.print("Enter Student Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Course: ");
                    String course = scanner.nextLine();

                    Student student = new Student(id, name, course);

                    manager.addStudent(student);

                    break;

                case 2:

                    System.out.print("Enter Student ID: ");
                    int studentId = scanner.nextInt();

                    System.out.println("1. Present");
                    System.out.println("2. Absent");

                    System.out.print("Enter attendance: ");
                    int attendance = scanner.nextInt();

                    if (attendance == 1) {
                        manager.markAttendance(studentId, true);
                    } else if (attendance == 2) {
                        manager.markAttendance(studentId, false);
                    } else {
                        System.out.println("Invalid attendance choice!");
                    }

                    break;

                case 3:

                    manager.displayAllStudents();

                    break;

                case 4:

                    System.out.print("Enter Student ID: ");
                    int searchId = scanner.nextInt();

                    manager.searchStudent(searchId);

                    break;

                case 5:

                    manager.showLowAttendanceStudents();

                    break;

                case 6:

                    System.out.println("Thank you for using the system!");
                    scanner.close();
                    return;

                default:

                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
```

### Example Output

```text
======================================
 STUDENT ATTENDANCE MANAGEMENT SYSTEM
======================================
1. Add Student
2. Mark Attendance
3. Display All Students
4. Search Student
5. Show Students Below 75%
6. Exit

Enter your choice: 1

Enter Student ID: 101
Enter Student Name: Rahul
Enter Course: Java

Student added successfully!

Enter your choice: 2
Enter Student ID: 101
1. Present
2. Absent
Enter attendance: 1

Student marked PRESENT.

======================================
 STUDENT ATTENDANCE MANAGEMENT SYSTEM
======================================
1. Add Student
2. Mark Attendance
3. Display All Students
4. Search Student
5. Show Students Below 75%
6. Exit

Enter your choice: 3

========== STUDENT ATTENDANCE ==========
ID: 101 | Name: Rahul | Course: Java | Present: 1 | Total: 1 | Attendance: 100.00%
```

### Attendance calculation

The program uses:

```text
Attendance Percentage =
(Present Classes / Total Classes) × 100
```

For example, if a student attended **36 out of 45 classes**:

```text
(36 / 45) × 100 = 80%
```

Students with attendance **below 75%** are automatically displayed using option 5.
