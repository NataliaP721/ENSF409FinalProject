package SharedDataObjects;

public class Course {
    private int courseID;
    private int professorID;
    private String courseName;
    private boolean active;

    public Course(int courseID, int professorID, String courseName, boolean active) {
        this.courseID = courseID;
        this.professorID = professorID;
        this.courseName = courseName;
        this.active = active;
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
    public boolean getActive() {
        return this.active;
    }
    // set
    public void setActive(boolean active) {
        this.active = active;
    }
}
