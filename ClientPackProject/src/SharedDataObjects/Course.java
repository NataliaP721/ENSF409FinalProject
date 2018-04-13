package SharedDataObjects;

import java.io.Serializable;

/**
 * Represents a course with all it's corresponding fields of information that is sent between client and server as a Serialized object.
 * @author  Natalia Pavlovic, Aysha Panatch, Eddy Gu
 * @version 2.0
 * @since April 11, 2018
 */


public class Course implements Serializable{
    /**
     * generated courseID, corresponding professorID, courseName, and activity of the course (boolean) are all fields of data about the course.
     * command is the command sent to the server so the server knows what to execute according to what the user does in the GUI.
     */
    private int courseID;
    private int professorID;
    private String courseName;
    private boolean active;
    private String command;

    public Course(int professorID, String courseName, boolean active) {
        this.professorID = professorID;
        this.courseName = courseName;
        this.active = active;
        this.command = null;
    }
    /**
     * Listed below are helper methods that help us retrieve certain fields and data from the Assignment object.
     */
    public int getCourseID() {
        return this.courseID;
    }
    public int getProfessorID() {
        return this.professorID;
    }
    public String getCourseName() {
        return this.courseName;
    }
    public char getActive() {
        if (!this.active) {
            return '0';
        }
        else
            return '1';
    }
    public String getCommand() {
        return this.command;
    }
    /**
     * Sets the command that tells the server what to do.
     */
    public void setCommand(String com) {this.command = com;}
    public void setActive(boolean active) {
        this.active = active;
    }
    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }
    /**
     * Overridden toString function for this object to allow us to print the desired data from the object as a String in the homepage.
     */
    @Override
     public String toString() {
       String answer = courseName;
       if(this.active){
         answer = answer + "          ACTIVE";
       }
       else {
         answer = answer + "          INACTIVE";
       }
       return answer;
     }
}
