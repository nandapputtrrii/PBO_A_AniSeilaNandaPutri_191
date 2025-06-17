public class Admin extends User {
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
}