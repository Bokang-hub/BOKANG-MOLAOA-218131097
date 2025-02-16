/** Bokang Molaoa
 *  Due Date: 17 February 2025
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final String REGISTER_FILE = "register.txt"; // File to store student data persistently
    private final List<Student> students; // List to hold Student objects
    private final Scanner scanner; // Scanner object for reading user input

    /**
     * Constructor for the Main class.
     * Initializes the students list, the scanner, and loads existing student data
     * from the file.
     */
    public Main() {
        this.students = new ArrayList<>(); // Initialize the list of students
        this.scanner = new Scanner(System.in); // Initialize the scanner to read from the console
        loadRegisterFromFile(); // Load students from the file when the program starts
    }

    /**
     * Main method - entry point of the application.
     * 
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Main register = new Main(); // Create a Main object to run the register application
        register.run(); // Start the application
    }

    /**
     * Main application loop.
     * Displays the menu, gets user input, and performs actions based on the user's
     * choice.
     */
    public void run() {
        while (true) { // Infinite loop to keep the application running until the user chooses to exit
            displayMenu(); // Display the menu options to the user
            int choice = getUserChoice(); // Get the user's choice

            switch (choice) { // Perform actions based on the user's choice
                case 1:
                    addStudent(); // Add a new student to the register
                    break;
                case 2:
                    markAttendance(); // Mark attendance for the students
                    break;
                case 3:
                    viewRegister(); // View the current register
                    break;
                case 4:
                    System.out.println("Exiting...");
                    saveRegisterToFile(); // Save the register to the file before exiting
                    scanner.close(); // Close the scanner to prevent resource leaks
                    return; // Exit the application
                default:
                    System.out.println("Invalid choice. Please try again."); // Handle invalid input
            }
        }
    }

    /**
     * Displays the class register menu to the user.
     */
    private void displayMenu() {
        System.out.println("\nClass Register Menu:");
        System.out.println("1. Add Student");
        System.out.println("2. Mark Attendance");
        System.out.println("3. View Register");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    /**
     * Gets the user's choice from the console.
     * 
     * @return The user's choice as an integer, or -1 if the input is invalid.
     */
    private int getUserChoice() {
        try {
            return Integer.parseInt(scanner.nextLine()); // Parse the input as an integer
        } catch (NumberFormatException e) {
            return -1; // Indicate an invalid input
        }
    }

    /**
     * Adds a new student to the register.
     * Prompts the user for the student's name and ID, creates a new Student object,
     * and adds it to the list.
     */
    private void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine(); // Get the student's name from the user
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine(); // Get the student's ID from the user

        Student student = new Student(name, studentId); // Create a new Student object
        students.add(student); // Add the student to the list
        System.out.println("Student added successfully!");
    }

    /**
     * Marks attendance for all students in the register.
     * Prompts the user for each student's presence and updates the Student object
     * accordingly.
     */
    private void markAttendance() {
        if (students.isEmpty()) {
            System.out.println("No students in the register yet.");
            return;
        }

        System.out.println("\nMarking Attendance:");
        for (Student student : students) { // Iterate through the list of students
            System.out.print("Is " + student.getName() + " present? (y/n): ");
            String input = scanner.nextLine().toLowerCase(); // Get the user's input (y/n)
            student.setPresent(input.equals("y")); // Set the student's presence based on the input
        }
        System.out.println("Attendance marked successfully!");
    }

    /**
     * Displays the current class register, including student names, IDs, and
     * attendance status.
     */
    private void viewRegister() {
        if (students.isEmpty()) {
            System.out.println("No students in the register yet.");
            return;
        }

        System.out.println("\nClass Register:");
        System.out.println("------------------------------------");
        System.out.printf("%-20s %-15s %-10s\n", "Name", "Student ID", "Present");
        System.out.println("------------------------------------");

        for (Student student : students) { // Iterate through the list of students
            System.out.printf("%-20s %-15s %-10s\n", student.getName(), student.getStudentId(),
                    student.isPresent() ? "Yes" : "No"); // Print the student's details
        }
        System.out.println("------------------------------------");
    }

    /**
     * Loads student data from the register file when the program starts.
     * Reads each line from the file, parses the data, and creates Student objects.
     */
    private void loadRegisterFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(REGISTER_FILE))) { // Use try-with-resources for
                                                                                          // automatic resource
                                                                                          // management
            String line;
            while ((line = reader.readLine()) != null) { // Read the file line by line
                String[] parts = line.split(","); // Split the line into parts using comma as a delimiter
                if (parts.length == 3) { // Ensure that the line has the expected number of parts
                    String name = parts[0]; // Extract the student's name
                    String studentId = parts[1]; // Extract the student's ID
                    boolean present = Boolean.parseBoolean(parts[2]); // Extract the student's attendance status
                    Student student = new Student(name, studentId); // Create a new Student object
                    student.setPresent(present); // Set the student's attendance status
                    students.add(student); // Add the student to the list
                }
            }
        } catch (FileNotFoundException e) {
            // It's okay if the file doesn't exist yet.
            System.out.println("Register file not found. Starting with an empty register.");
        } catch (IOException e) {
            System.err.println("Error loading register from file: " + e.getMessage());
        }
    }

    /**
     * Saves the current register data to the file when the program exits.
     * Writes each student's data to a new line in the file, separated by commas.
     */
    private void saveRegisterToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(REGISTER_FILE))) { // Use try-with-resources for
                                                                                    // automatic resource management
            for (Student student : students) { // Iterate through the list of students
                writer.println(student.getName() + "," + student.getStudentId() + "," + student.isPresent()); // Write
                                                                                                              // the
                                                                                                              // student's
                                                                                                              // data to
                                                                                                              // the
                                                                                                              // file
            }
        } catch (IOException e) {
            System.err.println("Error saving register to file: " + e.getMessage());
        }
    }

    /**
     * Inner class to represent a student.
     * Encapsulates student data such as name, ID, and attendance status.
     */
    private static class Student {
        private final String name; // Student's name
        private final String studentId; // Student's ID
        private boolean present; // Student's attendance status

        /**
         * Constructor for the Student class.
         * 
         * @param name      The student's name.
         * @param studentId The student's ID.
         */
        public Student(String name, String studentId) {
            this.name = name;
            this.studentId = studentId;
            this.present = false; // Default to absent
        }

        /**
         * Gets the student's name.
         * 
         * @return The student's name.
         */
        public String getName() {
            return name;
        }

        /**
         * Gets the student's ID.
         * 
         * @return The student's ID.
         */
        public String getStudentId() {
            return studentId;
        }

        /**
         * Gets the student's attendance status.
         * 
         * @return True if the student is present, false otherwise.
         */
        public boolean isPresent() {
            return present;
        }

        /**
         * Sets the student's attendance status.
         * 
         * @param present The student's attendance status.
         */
        public void setPresent(boolean present) {
            this.present = present;
        }
    }
}
