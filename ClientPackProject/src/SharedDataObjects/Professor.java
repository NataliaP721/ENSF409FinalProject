package SharedDataObjects;

import java.io.Serializable;

/**
 * Represents a professor user with all it's corresponding fields of information.
 * @author  Natalia Pavlovic, Aysha Panatch, Eddy Gu
 * @version 2.0
 * @since April 11, 2018
 */

public class Professor extends User implements Serializable{
    /**
     * Constructs a Professor object with the specified values for lastName, firstName, userEmail and id.
     * The values for the fields are supplied by the given parameters.
     * @param lastName the last name of the Professor
     * @param firstName the first name of the Professor
     * @param userEmail the email of the Professor
     * @param id the id of the Professor
     */
    public Professor(String lastName, String firstName, String userEmail, int id) {
        super(lastName, firstName, userEmail, 'P');
        super.setID(id);
    }

    /**
     * Sets the command that tells the server what to do.
     */
    public void setCommand(String command) {
        super.setCommand(command);
    }
}
