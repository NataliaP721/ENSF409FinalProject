package SharedDataObjects;

import java.io.Serializable;

public class LoginInfo implements Serializable{
    private int username;
    private String password;
    private String command;

    public LoginInfo(String password) {
        this.password = password;
        this.command = null;
    }
    // Helper methods
    // get
    public int getUsername() {
        return this.username;
    }
    public String getPassword() {
        return this.password;
    }
    public String getCommand() {
        return this.command;
    }
    public void setCommand(String com) { this.command = com;}
    public void setUsername(int username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
