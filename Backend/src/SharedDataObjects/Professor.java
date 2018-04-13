package SharedDataObjects;

import java.io.Serializable;

/**
 * @author  Natalia Pavlovic
 * @version 2.0
 * @since April 11, 2018
 */

public class Professor extends User implements Serializable{
    public Professor(String lastName, String firstName, String userEmail, int id) {
        super(lastName, firstName, userEmail, 'P');
        super.setID(id);
    }

    // Should specify allowed commands for Professor
    public void setCommand(String command) {
        super.setCommand(command);
    }
}
