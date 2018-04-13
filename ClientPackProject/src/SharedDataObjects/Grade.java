package SharedDataObjects;

import java.io.Serializable;

/**
 * @author  Natalia Pavlovic
 * @version 2.0
 * @since April 11, 2018
 */

public class Grade implements Serializable{
    private int gradeID;
    private int assignmentID;
    private int studentID;
    private int courseID;
    private int assignmentGrade;
    private String command;

    public Grade(int assignmentID, int studentID, int courseID, int assignmentGrade) {
        this.assignmentID = assignmentID;
        this.studentID = studentID;
        this.courseID = courseID;
        this.assignmentGrade = assignmentGrade;
        this.command = null;
    }
    // Helper methods
    // get
    public int getGradeID() {
        return this.gradeID;
    }
    public int getAssignmentID() {
        return this.assignmentID;
    }
    public int getStudentID() {
        return this.studentID;
    }
    public int getCourseID() {
        return this.courseID;
    }
    public int getAssignmentGrade() {
        return this.assignmentGrade;
    }
    public String getCommand() {
        return this.command;
    }
    public void setCommand(String com) { this.command = com;}
    public void setAssignmentGrade(int assignmentGrade) {
        this.assignmentGrade = assignmentGrade;
    }
    public void setGradeID (int gradeID) {
        this.gradeID = gradeID;
    }
}
