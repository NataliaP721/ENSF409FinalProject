import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.*;
import java.io.*;



import SharedDataObjects.*;

public class Worker implements Runnable {
    private DatabaseHelper databaseHelper;
    private EmailHelper emailHelper;
    private FileHelper fileHelper;
    private ObjectOutputStream out;
    private ObjectInputStream in;
    private Socket socket;

    Worker (DatabaseHelper database, EmailHelper emailService, FileHelper fileManager, Socket socket) {
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
                    out.reset();
                }
                else if(obj instanceof User) {
                    User user = (User) obj;
                    if(user.getCommand().equals("GETCOURSES")) {
                        ArrayList<Course> courseList = null;
                        if(user.getUserType()=='P') {
                            courseList= databaseHelper.searchAllCourses();
                        }
                        else{
                            courseList= databaseHelper.searchEnrolledActiveCourses();
                        }
                        databaseHelper.printCourseTable();
                        Course [] courses = courseList.toArray(new Course[courseList.size()]);
                        out.writeObject(courses);
                        out.reset();
                    }
                    else if (user.getCommand().equals("SEARCHENROLLEDBYLASTNAME")) {
                        ArrayList<StudentEnrollment> lastNamelist= databaseHelper.searchUsers(user.getLastName());
                        StudentEnrollment [] enrollments = lastNamelist.toArray(new StudentEnrollment [lastNamelist.size()]);
                        out.writeObject(enrollments);
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
                        Course [] courses = courseList.toArray(new Course[courseList.size()]);
                        out.writeObject(courses);
                        out.reset();
                    }
                    else if(course.getCommand().equals("DELETE")) {
                        databaseHelper.deleteCourse(course.getCourseID());
                        ArrayList<Course> courseList= databaseHelper.searchAllCourses();
                        Course [] courses = courseList.toArray(new Course[courseList.size()]);
                        out.writeObject(courses);
                        out.reset();
                    }
                    else if(course.getCommand().equals("MOD")) {
                        databaseHelper.modifyCourse(course);
                        ArrayList<Course> courseList= databaseHelper.searchAllCourses();
                        Course [] courses = courseList.toArray(new Course[courseList.size()]);
                        out.writeObject(courses);
                        out.reset();
                    }
                    else if(course.getCommand().equals("SEARCHBYID")) {
                        databaseHelper.searchCourses(course.getCourseID());
                    }
                    else if(course.getCommand().equals("GETASSIGNMENTS")) {
                        ArrayList<Assignment> assignmentList= databaseHelper.searchAllAssignments(course.getCourseID());
                        databaseHelper.printAssignmentTable();
                        Assignment [] assignments = assignmentList.toArray(new Assignment [assignmentList.size()]);
                        out.writeObject(assignments);
                        out.reset();
                    }
                    else if(course.getCommand().equals("GETSTUDENTS")) {
                        ArrayList<StudentEnrollment> enrollmentslist= databaseHelper.searchAllStudentEnrollments();
                        databaseHelper.printStudentEnrollmentTable();
                        System.out.println("Here");
                        StudentEnrollment [] enrollments = enrollmentslist.toArray(new StudentEnrollment [enrollmentslist.size()]);
                        out.writeObject(enrollments);
                        out.reset();
                    }
                    else if(course.getCommand().equals("DISPLAYCLASSLIST")) {
                        ArrayList<StudentEnrollment> enrollmentslist= databaseHelper.searchEnrolled();
                        StudentEnrollment [] enrollments = enrollmentslist.toArray(new StudentEnrollment [enrollmentslist.size()]);
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
                        ArrayList<StudentEnrollment> enrollmentsList= databaseHelper.searchAllStudentEnrollments();
                        StudentEnrollment [] enrollments = enrollmentsList.toArray(new StudentEnrollment[enrollmentsList.size()]);
                        out.writeObject(enrollments);
                        out.reset();
                    }
                    else if(studentEnrollment.getCommand().equals("SEARCHBYID")) {
                        ArrayList<StudentEnrollment> enrollmentslist = databaseHelper.searchStudentEnrollment(studentEnrollment.getStudentID());
                        StudentEnrollment [] enrollments = enrollmentslist.toArray(new StudentEnrollment [enrollmentslist.size()]);
                        out.writeObject(enrollments);
                        out.reset();
                    }
                }
                else if(obj instanceof Assignment) {
                    Assignment assignment = (Assignment) obj;
                    if(assignment.getCommand().equals("ADD")) {
                        databaseHelper.addAssignment(assignment);
                        ArrayList<Assignment> assignmentList= databaseHelper.searchAllAssignments();
                        databaseHelper.printAssignmentTable();
                        Assignment [] assignments = assignmentList.toArray(new Assignment[assignmentList.size()]);
                        out.writeObject(assignments);
                        out.reset();
                    }
                    else if(assignment.getCommand().equals("DELETE")) {
                        databaseHelper.deleteAssignment(assignment.getCourseID());
                        ArrayList<Assignment> assignmentList= databaseHelper.searchAllAssignments();
                        databaseHelper.printAssignmentTable();
                        Assignment [] assignments = assignmentList.toArray(new Assignment[assignmentList.size()]);
                        out.writeObject(assignments);
                        out.reset();
                    }
                    else if(assignment.getCommand().equals("MOD")) {
                        databaseHelper.modifyAssignment(assignment);
                        ArrayList<Assignment> assignmentList= databaseHelper.searchAllAssignments();
                        databaseHelper.printAssignmentTable();
                        System.out.println("MOD");
                        Assignment [] assignments = assignmentList.toArray(new Assignment[assignmentList.size()]);
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
                else if (obj instanceof Upload) {
                    System.out.println("here1");
                    String STORAGE_PATH = "/home/natalia/Server/";
                    Upload upload = (Upload) obj;
                    if(upload.getCommand().equals("ADDASSIGNMENT")|upload.getCommand().equals("ADDSUBMISSION")) {
                        String FILE_EXTENSION = upload.getFileExtension();
                        String FILE_NAME = upload.getFileName();
                        byte[] content = upload.getContent();
                        System.out.println(STORAGE_PATH);
                        System.out.println(FILE_NAME);
                        System.out.println(FILE_EXTENSION);
                        File newFile = new File(STORAGE_PATH + FILE_NAME + FILE_EXTENSION);
                        boolean exist = false;
                        try{
                            System.out.println(newFile.exists());
                            if(!newFile.exists())
                                exist = newFile.createNewFile();
                            if(exist == false)
                                System.out.println("no");
                            FileOutputStream writer = new FileOutputStream(newFile);
                            BufferedOutputStream bos = new BufferedOutputStream(writer);
                            bos.write(content);
                            bos.close();
                            System.out.println("Wrote to file");
                        } catch(IOException e){
                            e.printStackTrace();
                        }
                    }
                    out.writeObject(STORAGE_PATH);
                    out.reset();
                    System.out.println("here2");
                }
            }
            // ADD NECESSARY catch CLAUSES HERE
            catch (IOException e)
            {
                e.printStackTrace();
                //System.err.println( "Error reading object from socket." );
                closeConnection();
                break;
            } // end catch
            catch (ClassNotFoundException e)
            {
                System.err.println( "Class not found" );
            } // end catch
        }

    }

    void closeConnection() {
        try {
            databaseHelper.removeTables();
            socket.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
}
