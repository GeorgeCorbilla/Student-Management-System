package studentmanagementsystem;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class represents a student and contains their name, age, and course.
 */
class Student {

    private String name;
    private int age;
    private String course;

    /**
     * Constructor for creating a new student with the given name, age, and
     * course.
     *
     * @param name The student's name.
     * @param age The student's age.
     * @param course The student's course.
     */
    public Student(String name, int age, String course) {
        this.name = name;
        this.age = age;
        this.course = course;
    }

    /**
     * @return The student's name.
     */
    public String getName() {
        return name;
    }

    //return students age
    public int getAge() {
        return age;
    }

    // return students course
    public String getCourse() {
        return course;
    }
}

/**
 * This is a student management system that allows users to add, view, and
 * delete students. The program uses an ArrayList to store the students and a
 * Scanner for user input. The main method contains a while loop that runs until
 * the user chooses to exit the program. The loop presents the user with several
 * options, including adding a student, viewing all students, deleting a
 * student, and exiting the program.
 */
public class StudentManagementSystem {

    static ArrayList<Student> students = new ArrayList<Student>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean running = true;

        System.out.println("======================================");
        System.out.println("      STUDENT MANAGEMENT SYSTEM       ");

        //print menu 
        while (running) {
            System.out.println("======================================");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Delete Student");
            System.out.println("4. Exit");
            System.out.println("======================================");
            System.out.print("Enter your choice[1/2/3]: ");

            //ask for user input
            int choice = input.nextInt();
            input.nextLine();

            // check input using a switch case
            switch (choice) {
                case 1:
                    System.out.println("\n          ADD A STUDENT            ");
                    System.out.print("\nEnter student name: ");
                    String name = input.nextLine();
                    System.out.print("Enter student age: ");
                    int age = input.nextInt();
                    input.nextLine();
                    System.out.print("Enter student course: ");
                    String course = input.nextLine();

                    // creating a new student object and add it to the arraylist
                    Student student = new Student(name, age, course);
                    students.add(student);
                    System.out.println("Student added successfully!\n");
                    break;
                case 2:
                    /**
                     * View all students in the ArrayList If the ArrayList is
                     * empty, it will display "No students found." If there are
                     * students in the ArrayList, it will display their name,
                     * age, and course.
                     */
                    if (students.size() == 0) {
                        System.out.println("No students found.");
                    } else {
                        System.out.println("\n          STUDENTS            ");
                        for (Student s : students) {
                            System.out.println("--------------------------------------");
                            System.out.println("Name: " + s.getName());
                            System.out.println("Age: " + s.getAge());
                            System.out.println("Course: " + s.getCourse());
                            System.out.println("--------------------------------------\n");
                        }
                    }
                    break;
                case 3:
                    /**
                     * This case handles the option to delete a student from the
                     * ArrayList If the ArrayList is empty, it will display "No
                     * students found." If there are students in the ArrayList,
                     * the user will be prompted to enter the name of the
                     * student to be deleted. If the student is found, it will
                     * be removed from the ArrayList and "Student deleted
                     * successfully!" will be displayed. If the student is not
                     * found, "No student with the given name found." will be
                     * displayed.
                     */
                    if (students.size() == 0) {
                        System.out.println("No students found.");
                    } else {
                        System.out.print("Enter the name of student to be deleted: ");
                        String delName = input.nextLine();
                        int flag = 0;
                        for (Student s : students) {
                            if (s.getName().equals(delName)) {
                                students.remove(s);
                                System.out.println("Student deleted successfully!");
                                flag = 1;
                                break;
                            }
                        }
                        if (flag == 0) {
                            System.out.println("No student with the given name found.");
                        }
                    }
                    break;
                case 4:
                    /**
                     * This case handles the option to exit the program. It will
                     * display "Program Terminated" and the developer's name. It
                     * will also set the running variable to false, causing the
                     * while loop to terminate.
                     */
                    System.out.println("\nProgram Terminated");
                    System.out.println("Developed by: Grenela Dimaangay | BSOA-2A");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }
}
