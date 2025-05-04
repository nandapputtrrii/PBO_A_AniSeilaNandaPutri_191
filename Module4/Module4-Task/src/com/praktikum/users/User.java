package com.praktikum.users;

public abstract class User {
    // Encapsulated attributes
    private String name;
    private String studentId;

    // Constructor
    public User(String name, String studentId) {
        this.name = name;
        this.studentId = studentId;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    // Abstract methods
    public abstract boolean login(String input1, String input2);
    public abstract void displayAppMenu();

    // Display info method
    public void displayInfo() {
        System.out.println("User Information:");
        System.out.println("Name: " + name);
        System.out.println("Student ID: " + studentId);
    }
}