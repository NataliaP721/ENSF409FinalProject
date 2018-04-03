package SharedDataObjects;

public class User {
    private int userID;
    private String lastName;
    private String firstName;
    private String userEmail;
    private char userType;

    public User(int userID, String lastName, String firstName, String userEmail, char userType) {
        this.userID = userID;
        this.lastName = lastName;
        this.firstName = firstName;
        this.userEmail = userEmail;
        this.userType = userType;
    }
}
