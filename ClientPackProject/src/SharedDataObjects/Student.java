package SharedDataObjects;

import java.io.Serializable;

/**
 * Represents a student user with all it's corresponding fields of information.
 * @author  Natalia Pavlovic, Aysha Panatch, Eddy Gu
 * @version 2.0
 * @since April 11, 2018
 */


public class Student extends User implements Serializable{
    public Student(String lastName, String firstName, String userEmail, int id) {
        super(lastName, firstName, userEmail, 'S');
        super.setID(id);
    }


    /**
     * Sets the command that tells the server what to do.
     */
    public void setCommand(String command) {
        super.setCommand(command);
    }
}
