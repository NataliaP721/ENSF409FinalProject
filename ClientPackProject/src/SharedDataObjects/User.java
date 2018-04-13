package SharedDataObjects;

import java.io.Serializable;

/**
 * Represents a user with all it's corresponding fields of information that is sent between client and server as a Serialized object.
 * @author  Natalia Pavlovic
 * @version 2.0
 * @since April 11, 2018
 */

public class User implements Serializable{
    /**
     * corresponding last name, first name, email, user type and ID are all fields of data about the user.
     * command is the command sent to the server so the server knows what to execute according to what the user does in the GUI.
     */
    private String lastName;
    private String firstName;
    private String userEmail;
    private int id;
    private char userType;
    private String command;

    public User() {

    }
    public User(String lastName, String firstName, String userEmail, char userType) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.userEmail = userEmail;
        this.userType = userType;
        this.command = null;
    }
    /**
     * Listed below are helper methods that help us retrieve certain fields and data from the Assignment object.
     */
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
    public String getCommand() {
        return this.command;
    }
    public int getID() {
        return this.id;
    }
    /**
     * Sets the command that tells the server what to do.
     */
    public void setCommand(String command) {
        this.command = command;
    }
    public void setID(int studentID) {
        this.id = studentID;
    }
    /**
     * Sets the last name of the user.
     */
    public void setLastName(String last) { this.lastName = last;}

    /**
     * Overridden toString function for this object to allow us to print the desired data from the object as a String.
     */
    @Override
    public String toString() {
        String answer = lastName + "                "+id;
        return answer;
    }
}
