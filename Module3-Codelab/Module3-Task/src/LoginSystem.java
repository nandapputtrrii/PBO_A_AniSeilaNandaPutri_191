import java.util.Scanner;

public class LoginSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // create sample users (objek)
        Admin admin = new Admin("Alan", "382", "admin", "password123");
        Student student = new Student("Nanda", "191");

        boolean running = true;

        while (running) {
            System.out.println("\n===== Login System =====");
            System.out.println("1. Login as Admin");
            System.out.println("2. Login as Student");
            System.out.println("3. Exit");
            System.out.print("Choose option (1-3): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    // Admin login
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();

                    if (admin.login(username, password)) {
                        admin.displayInfo();
                    } else {
                        System.out.println("Admin login failed! Invalid username or password.");
                    }
                    break;

                case 2:
                    // Student login
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student ID: ");
                    String studentId = scanner.nextLine();

                    if (student.login(name, studentId)) {
                        student.displayInfo();
                    } else {
                        System.out.println("Student login failed! Invalid name or student ID.");
                    }
                    break;

                case 3:
                    // Exit program
                    System.out.println("Exiting program. Thank you!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option please choose 1-3.");
            }
        }

        scanner.close();
    }
}