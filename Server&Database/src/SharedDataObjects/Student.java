package SharedDataObjects;

public class Student extends User {
    public Student(String lastName, String firstName, String userEmail) {
        super(lastName, firstName, userEmail, 'S');
    }
    // Should specify allowed commands for Students
    public void setCommand(String command) {
        super.setCommand(command);
    }
}
