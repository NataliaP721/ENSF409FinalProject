package SharedDataObjects;

import java.io.Serializable;

public class User implements Serializable{
    private String lastName;
    private String firstName;
    private String userEmail;
    private int id;
    private char userType;
    private String command;

    public User() {

    }
    public User(String lastName, String firstName, String userEmail, int id, char userType) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.userEmail = userEmail;
        this.id = id;
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
    public String getCommand() {
        return this.command;
    }
    public int getID() {
        return this.id;
    }

    public void setLastName(String last) { this.lastName = last;}
}
