package SharedDataObjects;

import java.io.Serializable;

public class StudentEnrollment implements Serializable{
    private int enrollmentID;
    private int studentID;
    private int courseID;
    private boolean Enrolling;
    private String command;

    public StudentEnrollment(int enrollmentID, int studentID, int courseID, boolean Enrolling) {
        this.enrollmentID = enrollmentID;
        this.studentID = studentID;
        this.courseID = courseID;
        this.Enrolling = Enrolling;
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
    public boolean getEnrolling() {
        return this.Enrolling;
    }
    public String getCommand() {
        return this.command;
    }
    // set
    public void setEnrolling(boolean Enrolling) {
        this.Enrolling = Enrolling;
    }

    @Override
    public String toString() {
        String answer = Integer.toString(studentID);
        if(this.Enrolling){
            answer = answer + "          ENROLLED";
        }
        else {
            answer = answer + "          UNENROLLED";
        }
        return answer;
    }
}
