package SharedDataObjects;

import java.io.Serializable;

/**
 * @author  Natalia Pavlovic
 * @version 2.0
 * @since April 11, 2018
 */

public class Assignment implements Serializable{
    private int assignmentID;
    private int courseID;
    private String assignmentTitle;
    private String assignmentPath;
    private boolean active;
    private String dueDate;
    private String command;

    public Assignment(int courseID, String assignmentTitle,
                      String assignmentPath, boolean active, String dueDate) {
        this.courseID = courseID;
        this.assignmentTitle = assignmentTitle;
        this.assignmentPath = assignmentPath;
        this.active = active;
        this.dueDate = dueDate;
        this.command = null;
    }

    // Helper methods
    // get
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
    public void setCommand(String com) { this.command = com;}
    public void setActive(boolean active) {
        this.active = active;
    }
    public void setAssignmentID(int assignmentID) {
        this.assignmentID = assignmentID;
    }

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
