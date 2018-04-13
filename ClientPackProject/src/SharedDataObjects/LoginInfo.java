package SharedDataObjects;

import java.io.Serializable;

/**
 * Represents an instance of login information with all it's corresponding fields of information that is sent between client and server as a Serialized object.
 * @author Natalia Pavlovic, Aysha Panatch, Eddy Gu
 * @version 2.0
 * @since April 11, 2018
 */

public class LoginInfo implements Serializable{
    /**
     * assignmentID and password are fields of data of any instance of login information.
     * command is the command sent to the server so the server knows what to execute according to what the user does in the GUI.
     */
    private int username;
    private String password;
    private String command;

    /**
     * Constructs a LoginInfo object with the specified value password.
     * The values for the fields are supplied by the given parameters.
     * @param password the password of the User used to Login
     */
    public LoginInfo(String password) {
        this.password = password;
        this.command = null;
    }
    /**
     * Listed below are helper methods that help us retrieve certain fields and data from the Assignment object.
     */
    public int getUsername() {
        return this.username;
    }
    public String getPassword() {
        return this.password;
    }
    public String getCommand() {
        return this.command;
    }
    /**
     * Sets the command that tells the server what to do.
     */
    public void setCommand(String com) { this.command = com;}
    public void setUsername(int username) {
        this.username = username;
    }
    /**
     * Sets the password corresponding to the username.
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
