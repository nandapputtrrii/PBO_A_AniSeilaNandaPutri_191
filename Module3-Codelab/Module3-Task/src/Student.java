// Student class (subclass of User)
public class Student extends User {
    // constructor using super to access parent class
    public Student(String name, String studentId) {
        super(name, studentId);
    }

    // override login method
    @Override
    public boolean login(String inputName, String inputId) {
        return getName().equals(inputName) && getStudentId().equals(inputId);
    }

    // override displayInfo method
    @Override
    public void displayInfo() {
        System.out.println("Student Login Successful!");
        System.out.println("Student Information:");
        System.out.println("Name: " + getName());
        System.out.println("Student ID: " + getStudentId());
    }
}
