package SharedDataObjects;

public class LoginInfo {
    private int username;
    private String password;

    public LoginInfo(int username, String password) {
        this.username = username;
        this.password = password;
    }
    // Helper methods
    // get
    public int getUsername() {
        return this.username;
    }
    public String getPassword() {
        return this.password;
    }
    // set
    public void setPassword(String password) {
        this.password = password;
    }
}
