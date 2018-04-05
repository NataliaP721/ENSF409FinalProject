package SharedDataObjects;

public class Grade {
    private int gradeID;
    private int assignmentID;
    private int studentID;
    private int courseID;
    private int assignmentGrade;
    private String command;

    public Grade(int gradeID, int assignmentID, int studentID, int courseID, int assignmentGrade) {
        this.gradeID = gradeID;
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
    // set
    public void setAssignmentGrade(int assignmentGrade) {
        this.assignmentGrade = assignmentGrade;
    }
}
