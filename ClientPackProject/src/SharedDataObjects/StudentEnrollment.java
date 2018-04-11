package SharedDataObjects;

import java.io.Serializable;

public class StudentEnrollment implements Serializable{
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
    // Helper methods
    // get
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
    public void setCommand(String com) { this.command = com;}
    public void setStudentID(int id) { this.studentID = id;}
    public void setEnrollmentID(int enrollmentID) {
        this.enrollmentID = enrollmentID;
    }
    public char getEnrolling() {
        if (!this.enrolling) {
            return '0';
        }
        else {
            return '1';
        }
    }
    @Override
    public String toString() {
        String answer = Integer.toString(studentID);
        if(this.enrolling){
            answer = answer + "          ENROLLED";
        }
        else {
            answer = answer + "          UNENROLLED";
        }
        return answer;
    }
}
