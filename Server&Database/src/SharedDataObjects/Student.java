package SharedDataObjects;

public class Student extends User {
    public Student(String lastName, String firstName, String userEmail, int id) {
        super(lastName, firstName, userEmail, id,'S');
    }
    // Should specify allowed commands for Students
    public void setCommand(String command) {
        super.setCommand(command);
    }
}
