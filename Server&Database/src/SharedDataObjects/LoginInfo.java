package SharedDataObjects;

public class LoginInfo {
    private int username;
    private String password;
    private String command;

    public LoginInfo(int username, String password) {
        this.username = username;
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
    // set
    public void setPassword(String password) {
        this.password = password;
    }
}
