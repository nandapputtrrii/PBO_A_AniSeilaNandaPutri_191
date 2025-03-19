// Student Class (Subclass of User)
public class Student extends User {
    // Constructor using super
    public Student(String name, String studentId) {
        super(name, studentId);
    }

    // Override login method
    @Override
    public boolean login(String inputName, String inputId) {
        return getName().equals(inputName) && getStudentId().equals(inputId);
    }

    // Override displayInfo method
    @Override
    public void displayInfo() {
        System.out.println("Student Login Successful!");
        System.out.println("Student Information:");
        System.out.println("Name: " + getName());
        System.out.println("Student ID: " + getStudentId());
    }
}
