package SharedDataObjects;

import java.io.Serializable;

/**
 * @author  Natalia Pavlovic
 * @version 2.0
 * @since April 11, 2018
 */


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
