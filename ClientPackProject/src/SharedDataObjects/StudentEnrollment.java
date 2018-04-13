package SharedDataObjects;

import java.io.Serializable;

/**
 * Represents an instance of enrollment with all it's corresponding fields of information that is sent between client and server as a Serialized object.
 * @author  Natalia Pavlovic, Aysha Panatch, Eddy Gu
 * @version 2.0
 * @since April 11, 2018
 */

public class StudentEnrollment implements Serializable{
    /**
     * generated enrollmentID, corresponding studentID, corresponding courseID, and enrollment status (boolean) are all fields of data about the enrollment instance.
     * command is the command sent to the server so the server knows what to execute according to what the user does in the GUI.
     */
    private int enrollmentID;
    private int studentID;
    private int courseID;
    private boolean enrolling;
    private String command;

    public StudentEnrollment() {

    }

    public StudentEnrollment(int studentID, int courseID, boolean Enrolling) {
        this.studentID = studentID;
        this.courseID = courseID;
        this.enrolling = Enrolling;
        this.command = null;
    }
    /**
     * Listed below are helper methods that help us retrieve certain fields and data from the Assignment object.
     */
    public int getEnrollmentID() {
        return this.enrollmentID;
    }
    public int getStudentID() {
        return this.studentID;
    }
    public int getCourseID() {
        return this.courseID;
    }
    public void setEnrolling(boolean enroll) {
        this.enrolling = enroll;
    }
    public String getCommand() {
        return this.command;
    }
    /**
     * Sets the command that tells the server what to do.
     */
    public void setCommand(String com) { this.command = com;}
    public void setStudentID(int id) { this.studentID = id;}
    public void setEnrollmentID(int enrollmentID) {
        this.enrollmentID = enrollmentID;
    }
    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }
    public char getEnrolling() {
        if (!this.enrolling) {
            return '0';
        }
        else {
            return '1';
        }
    }
    /**
     * Overridden toString function for this object to allow us to print the desired data from the object as a String in Enroll Students.
     */
    @Override
    public String toString() {
        String answer = Integer.toString(studentID);
        if(this.enrolling){
            answer = answer + "          ENROLLED";
        }
        else {
            answer = answer + "          UNENROLLED";
        }
        answer += "            "+this.courseID;
        return answer;
    }
}

