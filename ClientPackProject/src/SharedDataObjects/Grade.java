package SharedDataObjects;

import java.io.Serializable;

/**
 * Represents a grade with all it's corresponding fields of information that is sent between client and server as a Serialized object.
 * @author  Natalia Pavlovic, Aysha Panatch, Eddy Gu
 * @version 2.0
 * @since April 11, 2018
 */

public class Grade implements Serializable{
    /**
     * generated gradeID, corresponding assignmentID, corresponding studentID, corresponding courseID,
     * and assignment grade are all fields of data about the grade.
     * command is the command sent to the server so the server knows what to execute according to what the user does in the GUI.
     */
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
    /**
     * Listed below are helper methods that help us retrieve certain fields and data from the Assignment object.
     */
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
    /**
     * Sets the command that tells the server what to do.
     */
    public void setCommand(String com) { this.command = com;}
    /**
     * Sets the corresponding grade to the assignment.
     */
    public void setAssignmentGrade(int assignmentGrade) {
        this.assignmentGrade = assignmentGrade;
    }
    public void setGradeID (int gradeID) {
        this.gradeID = gradeID;
    }
}
