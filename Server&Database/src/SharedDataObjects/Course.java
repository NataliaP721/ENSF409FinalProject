package SharedDataObjects;

public class Course {
    private int courseID;
    private int professorID;
    private String courseName;
    private boolean active;
    private String command;

    public Course(int courseID, int professorID, String courseName, boolean active) {
        this.courseID = courseID;
        this.professorID = professorID;
        this.courseName = courseName;
        this.active = active;
        this.command = null;
    }
    // Helper methods
    // get
    public int getCourseID() {
        return this.courseID;
    }
    public int getProfessorID() {
        return this.professorID;
    }
    public String getCourseName() {
        return this.courseName;
    }
    public char getActive() {
        if (!this.active) {
            return '0';
        }
        else
            return '1';
    }
    public String getCommand() {
        return this.command;
    }
    // set
    public void setActive(boolean active) {
        this.active = active;
    }
    @Override
     public String toString() {
       String answer = courseName;
       if(this.active){
         answer = answer + "          ACTIVE";
       }
       else {
         answer = answer + "          INACTIVE";
       }
       return answer;
     }
}
