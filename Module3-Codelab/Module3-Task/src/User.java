public class User {
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

    // Login method to be overridden
    public boolean login(String inputName, String inputId) {
        // Base implementation
        return false;
    }

    // Display info method to be overridden
    public void displayInfo() {
        System.out.println("User Information:");
        System.out.println("Name: " + name);
        System.out.println("Student ID: " + studentId);
    }
}