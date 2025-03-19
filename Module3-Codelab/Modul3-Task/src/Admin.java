public class Admin extends User {
    // Additional attributes
    private String username;
    private String password;

    // Constructor using super
    public Admin(String name, String studentId, String username, String password) {
        super(name, studentId);
        this.username = username;
        this.password = password;
    }

    // Getters and setters for additional attributes
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

    // Override login method
    @Override
    public boolean login(String inputUsername, String inputPassword) {
        return username.equals(inputUsername) && password.equals(inputPassword);
    }

    // Override displayInfo method
    @Override
    public void displayInfo() {
        System.out.println("Admin Login Successful!");
        System.out.println("Admin Information:");
        System.out.println("Name: " + getName());
        System.out.println("Student ID: " + getStudentId());
        System.out.println("Username: " + username);
    }
}