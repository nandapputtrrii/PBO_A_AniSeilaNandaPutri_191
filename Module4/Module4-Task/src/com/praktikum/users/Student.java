package com.praktikum.users;

import com.praktikum.actions.StudentActions;
import java.util.Scanner;

public class Student extends User implements StudentActions {

    // Constructor
    public Student(String name, String studentId) {
        super(name, studentId);
    }

    // Implementation of login from abstract User class
    @Override
    public boolean login(String inputName, String inputId) {
        return getName().equals(inputName) && getStudentId().equals(inputId);
    }

    // Override displayInfo method
    @Override
    public void displayInfo() {
        System.out.println("Student Login Successful!");
        super.displayInfo();
    }

    // Implementation of displayAppMenu from abstract User class
    @Override
    public void displayAppMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean inMenu = true;

        while (inMenu) {
            System.out.println("\n===== Student Menu =====");
            System.out.println("1. Report Found/Lost Items");
            System.out.println("2. View Report List");
            System.out.println("0. Logout");
            System.out.print("Choose option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    reportItem();
                    break;
                case 2:
                    viewReportedItems();
                    break;
                case 0:
                    System.out.println("Logging out...");
                    inMenu = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Implementation of StudentActions interface methods
    @Override
    public void reportItem() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n===== Report Found/Lost Item =====");
        System.out.print("Item Name: ");
        String itemName = scanner.nextLine();

        System.out.print("Item Description: ");
        String itemDesc = scanner.nextLine();

        System.out.print("Last Location/Found: ");
        String location = scanner.nextLine();

        System.out.println("\nItem reported successfully!");
        System.out.println("Item: " + itemName);
        System.out.println("Description: " + itemDesc);
        System.out.println("Location: " + location);
    }

    @Override
    public void viewReportedItems() {
        System.out.println(">> View Report Feature Not Available <<");
    }
}