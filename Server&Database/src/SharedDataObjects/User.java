package SharedDataObjects;

public class User {
    private String lastName;
    private String firstName;
    private String userEmail;
    private char userType;
    private String command;

    public User(String lastName, String firstName, String userEmail, char userType) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.userEmail = userEmail;
        this.userType = userType;
        this.command = null;
    }
    public String getLastName() {
        return this.lastName;
    }
    public String getFirstName() {
        return this.firstName;
    }
    public String getUserEmail() {
        return this.userEmail;
    }
    public char getUserType() {
        return this.userType;
    }
    public void setCommand(String command) {
        this.command = command;
    }
}
