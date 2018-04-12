package SharedDataObjects;

import java.io.Serializable;

public class Student extends User implements Serializable{
    public Student(String lastName, String firstName, String userEmail, int id) {
        super(lastName, firstName, userEmail, 'S');
        super.setID(id);
    }


    // Should specify allowed commands for Students
    public void setCommand(String command) {
        super.setCommand(command);
    }
}
