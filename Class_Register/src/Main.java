import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClassRegister {

    private List<Student> students;
    private Scanner scanner;

    public ClassRegister() {
        this.students = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        ClassRegister register = new ClassRegister();
        register.run();
    }

    public void run() {
        while (true) {
            displayMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    markAttendance();
                    break;
                case 3:
                    viewRegister();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
