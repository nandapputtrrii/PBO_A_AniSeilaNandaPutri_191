package com.praktikum.users;

import com.praktikum.actions.AdminActions;
import java.util.Scanner;

public class Admin extends User implements AdminActions {
    // additional attributes
    private String username;
    private String password;

    // constructor using super to access parent class
    public Admin(String name, String studentId, String username, String password) {
        super(name, studentId);
        this.username = username;
        this.password = password;
    }

    // getters and setters for additional attributes
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // No getter for password for security reasons
    public void setPassword(String password) {
        this.password = password;
    }

    // override login method to check whether username and password match
    @Override
    public boolean login(String inputUsername, String inputPassword) {
        return username.equals(inputUsername) && password.equals(inputPassword);
    }

    // override displayInfo method
    @Override
    public void displayInfo() {
        System.out.println("Admin Login Successful!");
        System.out.println("Admin Information:");
        System.out.println("Name: " + getName());
        System.out.println("Student ID: " + getStudentId());
        System.out.println("Username: " + username);
    }

    // Implementation of displayAppMenu from abstract User class
    @Override
    public void displayAppMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean inMenu = true;

        while (inMenu) {
            System.out.println("\n===== Admin Menu =====");
            System.out.println("1. Manage Item Reports");
            System.out.println("2. Manage Student Data");
            System.out.println("0. Logout");
            System.out.print("Choose option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    manageItems();
                    break;
                case 2:
                    manageUsers();
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

    // Implementation of AdminActions interface methods
    @Override
    public void manageItems() {
        System.out.println(">> Manage Items feature is not available <<");
    }

    @Override
    public void manageUsers() {
        System.out.println(">> Manage Students feature is not available <<");
    }
}