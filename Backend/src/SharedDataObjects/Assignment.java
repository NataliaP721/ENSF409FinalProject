package SharedDataObjects;

import java.io.Serializable;

/**
 * Represents an assignment with all it's corresponding fields of information that is sent between client and server as a Serialized object.
 * @author  Natalia Pavlovic, Aysha Panatch, Eddy Gu
 * @version 2.0
 * @since April 11, 2018
 */

public class Assignment implements Serializable{
    /**
     * generated assignmentID, corresponding courseID, assignmentTitle, assignmentPath in the server harddrive,
     * activity of the assignment (boolean) and dueDate of the assignment are all fields of data about the assignment.
     * command is the command sent to the server so the server knows what to execute according to what the user does in the GUI.
     */
    private int assignmentID;
    private int courseID;
    private String assignmentTitle;
    private String assignmentPath;
    private boolean active;
    private String dueDate;
    private String command;

    /**
     * Conctructs an Assignment object from the specified values for courseID,
     * assignmentTitle, assignmentOath, active and dueDate.
     * The values for the fields are supplied by the given parameters.
     * @param courseID the ID of the Course the Assignment is for
     * @param assignmentTitle the title of the Assignment
     * @param assignmentPath the path of the Assignment on the server harddrive
     * @param active a boolean containing information on if the Assignment is active or not
     * @param dueDate the Assignment due date
     */
    public Assignment(int courseID, String assignmentTitle,
                      String assignmentPath, boolean active, String dueDate) {
        this.courseID = courseID;
        this.assignmentTitle = assignmentTitle;
        this.assignmentPath = assignmentPath;
        this.active = active;
        this.dueDate = dueDate;
        this.command = null;
    }

    /**
     * Listed below are helper methods that help us retrieve certain fields and data from the Assignment object.
     */
    public int getAssignmentID() {
        return this.assignmentID;
    }
    public int getCourseID() {
        return this.courseID;
    }
    public String getAssignmentTitle() {
        return this.assignmentTitle;
    }
    public String getAssignmentPath() {
        return this.assignmentPath;
    }
    public char getActive() {
        if (!this.active) {
            return '0';
        }
        else
            return '1';
    }
    public String getDueDate() {
        return this.dueDate;
    }
    public String getCommand() {
        return this.command;
    }
    /**
     * Sets the command that tells the server what to do.
     */
    public void setCommand(String com) { this.command = com;}
    public void setActive(boolean active) {
        this.active = active;
    }
    public void setAssignmentID(int assignmentID) {
        this.assignmentID = assignmentID;
    }

    /**
     * Overridden toString function for this object to allow us to print the desired data from the object as a String in ManageAssignments.
     */
    @Override
    public String toString() {
        String answer = assignmentTitle;
        if(this.active){
            answer = answer + "          ACTIVE";
        }
        else {
            answer = answer + "          INACTIVE";
        }
        answer  = answer + "         DUE " + dueDate;
        return answer;
    }
}
