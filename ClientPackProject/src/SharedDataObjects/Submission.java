package SharedDataObjects;

import java.io.Serializable;

public class Submission implements Serializable{
    private int submissionID;
    private int assignmentID;
    private int studentID;
    private String submissionPath;
    private int submissionGrade;
    private String submissionComment;
    private String submissionTimestamp;
    private String assignmentTitle;
    private String command;

    public Submission(int submissionID, int assignmentID, int studentID, String submissionPath, int submissionGrade,
                      String submissionComment, String submissionTimestamp, String assignmentTitle) {
        this.submissionID = submissionID;
        this.assignmentID = assignmentID;
        this.studentID = studentID;
        this.submissionPath = submissionPath;
        this.submissionGrade = submissionGrade;
        this.submissionComment = submissionComment;
        this.submissionTimestamp = submissionTimestamp;
        this.assignmentTitle = assignmentTitle;
        this.command = null;
    }
    // Helper methods
    // get
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
    public void setCommand(String com) { this.command = com;}
    public void setSubmissionGrade(int submissionGrade) {
        this.submissionGrade = submissionGrade;
    }
}
