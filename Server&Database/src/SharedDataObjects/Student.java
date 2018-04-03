package SharedDataObjects;

public class Student extends User {
    public Student(int userID, String lastName, String firstName, String userEmail, char userType) {
        super(userID, lastName, firstName, userEmail, 'S');
    }
}
