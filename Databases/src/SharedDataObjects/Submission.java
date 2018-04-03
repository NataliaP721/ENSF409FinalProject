package SharedDataObjects;

public class Submission {
    private int submissionID;
    private int assignmentID;
    private int studentID;
    private String submissionPath;
    private int submissionGrade;
    private int submissionComment;
    private String submissionTimestamp;
    private String assignmentTitle;

    public Submission(int submissionID, int assignmentID, int studentID, String submissionPath, int submissionGrade,
                      int submissionComment, String submissionTimestamp, String assignmentTitle) {
        this.submissionID = submissionID;
        this.assignmentID = assignmentID;
        this.studentID = studentID;
        this.submissionPath = submissionPath;
        this.submissionGrade = submissionGrade;
        this.submissionComment = submissionComment;
        this.submissionTimestamp = submissionTimestamp;
        this.assignmentTitle = assignmentTitle;
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
    public int getSubmissionComment() {
        return this.submissionComment;
    }
    public String getSubmissionTimestamp() {
        return this.submissionTimestamp;
    }
    public String getAssignmentTitle() {
        return this.assignmentTitle;
    }
    // set
    public void setSubmissionGrade(int submissionGrade) {
        this.submissionGrade = submissionGrade;
    }
}
