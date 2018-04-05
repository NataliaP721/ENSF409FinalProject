import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import SharedDataObjects.*;

public class Worker implements Runnable {
    private DatabaseHelper databaseHelper;
    private EmailHelper emailHelper;
    private FileHelper fileHelper;
    private ObjectInputStream in;
    private ObjectOutputStream out;
    private Socket socket;

    public Worker (DatabaseHelper database, EmailHelper emailService, FileHelper fileManager, Socket socket) {
        this.databaseHelper = database;
        this.emailHelper = emailService;
        this.fileHelper = fileManager;
        this.socket = socket;
        try{
            in = new ObjectInputStream(socket.getInputStream());
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * {@InheritDoc}
     */
    @Override
    public void run() {
        while(true) {
            try {
                Object obj = in.readObject();
                if(obj instanceof User) {
                    User user = (User) obj;
                    obj =  in.readObject();
                    while((obj instanceof LoginInfo)==false) {
                        obj =  in.readObject();
                        // TODO add delay if in infinite loop???
                    }
                    LoginInfo loginInfo = (LoginInfo) obj;
                    // TODO CHANGE NAMES LATER TO MATCH
                    if (user.getCommand().equals("ADD")) {
                        databaseHelper.addUser(user, loginInfo);
                    } else if (user.getCommand().equals("DEL")) {
                        databaseHelper.deleteUser(loginInfo.getUsername());
                    } else if (user.getCommand().equals("SEARCHBYID")) {
                        databaseHelper.searchUsers(loginInfo.getUsername());
                    } else if (user.getCommand().equals("SEARCHBYLASTNAME")) {
                        databaseHelper.searchUsers(user.getLastName());
                    }
                }
                else if(obj instanceof Course) {
                    Course course = (Course) obj;
                    if(course.getCommand().equals("ADD")) {
                        databaseHelper.addCourse(course);
                    }
                    else if(course.getCommand().equals("DEL")) {
                        databaseHelper.deleteCourse(course.getCourseID());
                    }
                    else if(course.getCommand().equals("MOD")) {
                        databaseHelper.modifyCourse(course);
                    }
                    else if(course.getCommand().equals("SEARCHBYID")) {
                        databaseHelper.searchCourses(course.getCourseID());
                    }
                }
                else if(obj instanceof StudentEnrollment) {
                    StudentEnrollment studentEnrollment = (StudentEnrollment) obj;
                    if(studentEnrollment.getCommand().equals("ADD")) {
                        databaseHelper.addStudentEnrollment(studentEnrollment);
                    }
                    else if(studentEnrollment.getCommand().equals("DEL")) {
                        databaseHelper.deleteStudentEnrollment(studentEnrollment.getCourseID());
                    }
                    else if(studentEnrollment.getCommand().equals("MOD")) {
                        databaseHelper.modifyStudentEnrollment(studentEnrollment);
                    }
                    else if(studentEnrollment.getCommand().equals("SEARCHBYID")) {
                        databaseHelper.searchStudentEnrollment(studentEnrollment.getEnrollmentID());
                    }
                }
                else if(obj instanceof Assignment) {
                    Assignment assignment = (Assignment) obj;
                    if(assignment.getCommand().equals("ADD")) {
                        databaseHelper.addAssignment(assignment);
                    }
                    else if(assignment.getCommand().equals("DEL")) {
                        databaseHelper.deleteAssignment(assignment.getCourseID());
                    }
                    else if(assignment.getCommand().equals("MOD")) {
                        databaseHelper.modifyAssignment(assignment);
                    }
                    else if(assignment.getCommand().equals("SEARCHBYID")) {
                        databaseHelper.searchAssignments(assignment.getAssignmentID());
                    }
                }
                else if(obj instanceof Submission) {
                    Submission submission = (Submission) obj;
                    if (submission.getCommand().equals("ADD")) {
                        databaseHelper.addSubmission(submission);
                    } else if (submission.getCommand().equals("DEL")) {
                        databaseHelper.deleteSubmission(submission.getSubmissionID());
                    } else if (submission.getCommand().equals("SEARCHBYID")) {
                        databaseHelper.searchSubmissions(submission.getSubmissionID());
                    }
                }
                else if(obj instanceof Grade) {
                    Grade grade = (Grade) obj;
                    if (grade.getCommand().equals("ADD")) {
                        databaseHelper.addGrade(grade);
                    } else if (grade.getCommand().equals("DEL")) {
                        databaseHelper.deleteGrade(grade.getGradeID());
                    } else if (grade.getCommand().equals("SEARCHBYID")) {
                        databaseHelper.searchGrades(grade.getGradeID());
                    }
                }
            }
            // ADD NECESSARY catch CLAUSES HERE
            catch (IOException e)
            {
                System.err.println( "Error reading object from socket." );
            } // end catch
            catch (ClassNotFoundException e)
            {
                System.err.println( "Class not found" );
            } // end catch
        }

    }

    public void closeConnection() {
        try {
            socket.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
}
