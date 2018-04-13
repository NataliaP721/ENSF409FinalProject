package SharedDataObjects;

import java.io.Serializable;

/**
 * Represents a submission with all it's corresponding fields of information that is sent between client and server as a Serialized object.
 * @author  Natalia Pavlovic, Aysha Panatch, Eddy Gu
 * @version 2.0
 * @since April 11, 2018
 */

public class Submission implements Serializable{
    /**
     * generated submissionID, corresponding assignmentID, corresponding studentID, submissionPath in the server harddrive,
     * submissionGrade, submissionComment, submissionTimestamp and assignmentTitle are all fields of data about the submission.
     * command is the command sent to the server so the server knows what to execute according to what the user does in the GUI.
     */
    private int submissionID;
    private int assignmentID;
    private int studentID;
    private String submissionPath;
    private int submissionGrade;
    private String submissionComment;
    private String submissionTimestamp;
    private String assignmentTitle;
    private String command;


    public Submission(int assignmentID, int studentID) {
        this.assignmentID = assignmentID;
        this.studentID = studentID;
    }
    public Submission(int assignmentID, int studentID, String submissionPath, int submissionGrade,
                      String submissionComment, String submissionTimestamp, String assignmentTitle) {
        this.assignmentID = assignmentID;
        this.studentID = studentID;
        this.submissionPath = submissionPath;
        this.submissionGrade = submissionGrade;
        this.submissionComment = submissionComment;
        this.submissionTimestamp = submissionTimestamp;
        this.assignmentTitle = assignmentTitle;
        this.command = null;
    }
    /**
     * Listed below are helper methods that help us retrieve certain fields and data from the Assignment object.
     */
    public int getSubmissionID() {
        return this.submissionID;
    }
    public int getAssignmentID() {
        return this.assignmentID;
    }
    public int getStudentID() {
        return this.studentID;
    }
    public String getSubmissionPath() {
        return this.submissionPath;
    }
    public int getSubmissionGrade() {
        return this.submissionGrade;
    }
    public String getSubmissionComment() {
        return this.submissionComment;
    }
    public String getSubmissionTimestamp() {
        return this.submissionTimestamp;
    }
    public String getAssignmentTitle() {
        return this.assignmentTitle;
    }
    public String getCommand() {
        return this.command;
    }
    /**
     * Sets the command that tells the server what to do.
     */
    public void setCommand(String com) { this.command = com;}
    /**
     * Sets the submission grade.
     */
    public void setSubmissionGrade(int submissionGrade) {
        this.submissionGrade = submissionGrade;
    }
    public void setSubmissionID(int submissionID) {
        this.submissionID = submissionID;
    }

    @Override
    public String toString() {
        return assignmentTitle + "    submitted: " + submissionTimestamp + "    Grade: " + submissionGrade;
    }
}