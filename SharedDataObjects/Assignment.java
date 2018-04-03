package SharedDataObjects;

public class Assignment {
    private int assignmentID;
    private int courseID;
    private String assignmentTitle;
    private String assignmentPath;
    private boolean active;
    private String dueDate;

    public Assignment(int assignmentID, int courseID, String assignmentTitle,
                      String assignmentPath, boolean active, String dueDate) {
        this.assignmentID = assignmentID;
        this.courseID = courseID;
        this.assignmentTitle = assignmentTitle;
        this.assignmentPath = assignmentPath;
        this.active = active;
        this.dueDate = dueDate;
    }

    // Helper methods
    // get
    public int getAssignmentID() {
        return this.assignmentID;
    }
    public int getCourseID() {
        return this.courseID;
    }
    public String getAssignmentTitle() {
        return this.assignmentTitle;
    }
    public String getAssignmentPath() {
        return this.assignmentPath;
    }
    public boolean getActive() {
        return this.active;
    }
    public String getDueDate() {
        return this.dueDate;
    }
    // set
    public void setActive(boolean active) {
        this.active = active;
    }
}
