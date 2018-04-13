package SharedDataObjects;

import java.io.Serializable;

/**
 * @author  Natalia Pavlovic
 * @version 2.0
 * @since April 11, 2018
 */


public class Course implements Serializable{
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
    // Helper methods
    // get
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
    public void setCommand(String com) {this.command = com;}
    public void setActive(boolean active) {
        this.active = active;
    }
    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }
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
