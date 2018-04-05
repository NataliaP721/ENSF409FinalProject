package SharedDataObjects;

public class Assignment {
    private int assignmentID;
    private int courseID;
    private String assignmentTitle;
    private String assignmentPath;
    private boolean active;
    private String dueDate;
    private String command;

    public Assignment(int assignmentID, int courseID, String assignmentTitle,
                      String assignmentPath, boolean active, String dueDate) {
        this.assignmentID = assignmentID;
        this.courseID = courseID;
        this.assignmentTitle = assignmentTitle;
        this.assignmentPath = assignmentPath;
        this.active = active;
        this.dueDate = dueDate;
        this.command = null;
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
    public int getActive() {
        if(this.active) {
            return 1;
        }
        else
            return 0;
    }
    public String getDueDate() {
        return this.dueDate;
    }
    public String getCommand() {
        return this.command;
    }
    public void setCommand(String com) { this.command = com;}
    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        String answer = assignmentTitle;
        if(this.active){
            answer = answer + "          ACTIVE";
        }
        else {
            answer = answer + "          INACTIVE";
        }
        answer  = answer + "         DUE" + dueDate;
        return answer;
    }
}
