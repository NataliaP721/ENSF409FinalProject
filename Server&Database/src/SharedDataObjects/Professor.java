package SharedDataObjects;

public class Professor extends User{
    public Professor(String lastName, String firstName, String userEmail) {
        super(lastName, firstName, userEmail, 'P');
    }
    // Should specify allowed commands for Professor
    public void setCommand(String command) {
        super.setCommand(command);
    }
}
