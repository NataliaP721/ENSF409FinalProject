package SharedDataObjects;

public class Professor extends User{
    public Professor(int userID, String lastName, String firstName, String userEmail, char userType) {
        super(userID, lastName, firstName, userEmail, 'P');
    }
}
