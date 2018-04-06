import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.*;

import SharedDataObjects.*;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class Worker implements Runnable {
    private DatabaseHelper databaseHelper;
    private EmailHelper emailHelper;
    private FileHelper fileHelper;
    private ObjectOutputStream out;
    private ObjectInputStream in;
    private Socket socket;

    public Worker (DatabaseHelper database, EmailHelper emailService, FileHelper fileManager, Socket socket) {
        this.databaseHelper = database;
        this.emailHelper = emailService;
        this.fileHelper = fileManager;
        this.socket = socket;
        try{
            out = new ObjectOutputStream(socket.getOutputStream());
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
                if(obj instanceof LoginInfo) {
                    LoginInfo loginInfo = (LoginInfo) obj;
                    User found = databaseHelper.searchUsers(loginInfo.getUsername());
                    out.writeObject(found);
//                    out.flush();
                    out.reset();
                }
                else if(obj instanceof User) {
                    User user = (User) obj;
                    if(user.getCommand().equals("GETCOURSES")) {
                        ArrayList<Course> courseList= databaseHelper.searchAllCourses();
                        databaseHelper.printCourseTable();
                        Course [] courses = (Course [])courseList.toArray(new Course[courseList.size()]);
                        out.writeObject(courses);
                        out.reset();
                    }
//                    if (user.getCommand().equals("ADD")) {
//                        databaseHelper.addUser(user, loginInfo);
//                    } else if (user.getCommand().equals("DEL")) {
//                        databaseHelper.deleteUser(loginInfo.getUsername());
//                    } else if (user.getCommand().equals("SEARCHBYID")) {
//                        databaseHelper.searchUsers(loginInfo.getUsername());
//                    } else if (user.getCommand().equals("SEARCHBYLASTNAME")) {
//                        databaseHelper.searchUsers(user.getLastName());
//                    }
                }
                else if(obj instanceof Course) {
                    Course course = (Course) obj;
                    if(course.getCommand().equals("ADD")) {
                        databaseHelper.addCourse(course);
                        ArrayList<Course> courseList= databaseHelper.searchAllCourses();
                        databaseHelper.printCourseTable();
                        Course [] courses = (Course [])courseList.toArray(new Course[courseList.size()]);
                        out.writeObject(courses);
                        out.reset();
                    }
                    else if(course.getCommand().equals("DELETE")) {
                        databaseHelper.deleteCourse(course.getCourseID());
                        ArrayList<Course> courseList= databaseHelper.searchAllCourses();
                        Course [] courses = (Course [])courseList.toArray(new Course[courseList.size()]);
                        out.writeObject(courses);
                        out.reset();
                    }
                    else if(course.getCommand().equals("MOD")) {
                        databaseHelper.modifyCourse(course);
                        ArrayList<Course> courseList= databaseHelper.searchAllCourses();
                        Course [] courses = (Course [])courseList.toArray(new Course[courseList.size()]);
                        out.writeObject(courses);
                        out.reset();
                    }
                    else if(course.getCommand().equals("SEARCHBYID")) {
                        databaseHelper.searchCourses(course.getCourseID());
                    }
                    else if(course.getCommand().equals("GETASSIGNMENTS")) {
                        ArrayList<Assignment> assignmentList= databaseHelper.searchAllAssignments();
                        databaseHelper.printAssignmentTable();
                        Assignment [] assignments = (Assignment [])assignmentList.toArray(new Assignment [assignmentList.size()]);
                        out.writeObject(assignments);
                        out.reset();
                    }
                    else if(course.getCommand().equals("GETSTUDENTS")) {
                        ArrayList<StudentEnrollment> enrollmentslist= databaseHelper.searchAllStudentEnrollments();
                        databaseHelper.printStudentEnrollmentTable();
                        System.out.println("Here");
                        StudentEnrollment [] enrollments = (StudentEnrollment [])enrollmentslist.toArray(new StudentEnrollment [enrollmentslist.size()]);
                        out.writeObject(enrollments);
                        out.reset();
                    }
                    else if(course.getCommand().equals("SEARCHENROLLED")) {
                        ArrayList<StudentEnrollment> enrollmentslist= databaseHelper.searchAllStudentEnrollments();
                        StudentEnrollment enrollment = enrollmentslist.get(0);
                        for (Iterator<StudentEnrollment> iter = enrollmentslist.iterator(); iter.hasNext(); ) {
                                if(enrollment.getEnrolling()==false) {
                                    enrollmentslist.remove(iter);
                                }
                                enrollment = iter.next();
                        }
                        databaseHelper.printAssignmentTable();
                        StudentEnrollment [] enrollments = (StudentEnrollment [])enrollmentslist.toArray(new StudentEnrollment [enrollmentslist.size()]);
                        out.writeObject(enrollments);
                        out.reset();
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
                    else if(studentEnrollment.getCommand().equals("SEARCH")) {
                        StudentEnrollment enrollment = databaseHelper.searchStudentEnrollment(studentEnrollment.getEnrollmentID());
                        out.writeObject(enrollment);
                        out.flush();
                        out.reset();

                    }
                }
                else if(obj instanceof Assignment) {
                    Assignment assignment = (Assignment) obj;
                    if(assignment.getCommand().equals("ADD")) {
                        databaseHelper.addAssignment(assignment);
                        ArrayList<Assignment> assignmentList= databaseHelper.searchAllAssignments();
                        databaseHelper.printAssignmentTable();
                        Assignment [] assignments = (Assignment [])assignmentList.toArray(new Assignment[assignmentList.size()]);
                        out.writeObject(assignments);
                        out.flush();
                        out.reset();
                    }
                    else if(assignment.getCommand().equals("DELETE")) {
                        databaseHelper.deleteAssignment(assignment.getCourseID());
                        ArrayList<Assignment> assignmentList= databaseHelper.searchAllAssignments();
                        databaseHelper.printAssignmentTable();
                        Assignment [] assignments = (Assignment [])assignmentList.toArray(new Assignment[assignmentList.size()]);
                        out.writeObject(assignments);
                        out.flush();
                        out.reset();
                    }
                    else if(assignment.getCommand().equals("MOD")) {
                        databaseHelper.modifyAssignment(assignment);
                        ArrayList<Assignment> assignmentList= databaseHelper.searchAllAssignments();
                        databaseHelper.printAssignmentTable();
                        System.out.println("MOD");
                        Assignment [] assignments = (Assignment [])assignmentList.toArray(new Assignment[assignmentList.size()]);
                        out.writeObject(assignments);
                        out.reset();
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
                closeConnection();
                break;
            } // end catch
            catch (ClassNotFoundException e)
            {
                System.err.println( "Class not found" );
            } // end catch
        }

    }

    public void closeConnection() {
        try {
            databaseHelper.removeTables();
            socket.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
}
