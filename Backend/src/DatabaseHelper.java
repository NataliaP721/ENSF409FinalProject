import java.sql.*;
import SharedDataObjects.*;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * This class allows you to create and manage a FinalProjectDB database.
 * It creates a database and several datatables, then populates them based on user input.
 * @author Natalia Pavlovic
 * @version 1.0
 * @since April 3, 2018
 */
public class DatabaseHelper {
    static private int totalUserEnteries = 1;
    static private int totalCourseEnteries = 1;
    static private int totalEnrollmentEnteries = 1;
    static private int totalAssignmentEnteries = 1;
    static private int totalSubmissionEnteries = 1;
    static private int totalGradeEnteries = 1;
    /**
     * The connection to the MySQL server
     */
    private Connection jdbc_connection;

    /**
     * The PreparedStatement object used to execute the statement in MySQL
     */
    private PreparedStatement statement;

    /**
     * databaseName is the name of the MySQL database
     * tableName is the name of the table in the database
     * dataFile is the name of the input text file
     */
    public String databaseName = "FinalProjectDB";
     public String dataFile = "UserInput.txt";

    public String userTableName = "UserTable";
    public String courseTableName = "CourseTable";
    public String studentEnrollmentTableName = "StudentEnrollmentTable";
    public String assignmentTableName = "AssignmentTable";
    public String submissionTableName = "SubmissionTable";
    public String gradeTableName = "GradeTable";

    // Students should configure these variables for their own MySQL environment
    // If you have not created your first database in mySQL yet, you can leave the
    // "[DATABASE NAME]" blank to get a connection and create one with the createDB() method.
    /**
     * connectionInfo is the information about the connection to the MySQL database
     * login is the username for the MySQL environment
     * password is the password for the MySQL environment
     */
    public String connectionInfo = "jdbc:mysql://localhost:3306/FinalProjectDB?useSSL=false",
            login          = "ENSF409FinalProject",
            password       = "1234";

    /**
     * Constructs a DatabaseHelper object from default values. Uses MySQL connector JAR
     * to connect to the server.
     */
    DatabaseHelper()
    {
        try{
            // If this throws an error, make sure you have added the mySQL connector JAR to the project
            Class.forName("com.mysql.jdbc.Driver");

            // If this fails make sure your connectionInfo and login/password are correct
            jdbc_connection = DriverManager.getConnection(connectionInfo, login, password);
            System.out.println("Connected to: " + connectionInfo + "\n");

            // You should comment this line out once the first database is created (either here or in MySQL workbench)
            // databaseHelper.createDB();

            // Create a text document for students
            createTables();
            addUser(new User("Pavlovic", "Natalia", "natalia.nzp@gmail.com", 'P' ), new LoginInfo("12345"));
            addUser(new User("Flintstone", "Fred", "fred@gmail.com",  'S' ), new LoginInfo("12345"));
            addUser(new User("Simpson", "Bart", "fred@gmail.com",  'S' ), new LoginInfo("12345"));

            addCourse(new Course( 1, "ENSF409", true));
            addCourse(new Course(1, "ENSF410", true));
            addCourse(new Course(1, "ENSF411", true));
            addCourse(new Course( 1, "ENSF412", true));
            addAssignment(new Assignment( 1, "abc", "test", false, "18:04:06"));
            addStudentEnrollment(new StudentEnrollment(2, 1, true));
            addStudentEnrollment(new StudentEnrollment(3, 2, true));

        }
        catch( SQLException e)
        {
            System.err.println("SQL Error");
        }
        catch (Exception e) {
            System.err.println("General Error");
        }
    }

    /**
     * Use the jdbc connection to create a new database in MySQL.
     * (e.g. if you are connected to "jdbc:mysql://localhost:3306", the database will be created at "jdbc:mysql://localhost:3306/FinalProjectDB")
     */
    void createDB()
    {
        try {
            statement = jdbc_connection.prepareStatement("CREATE DATABASE " + databaseName);
            statement.executeUpdate();
            System.out.println("Created Database " + databaseName);
        }
        catch( SQLException e)
        {
            System.err.println("SQL Error");
        }
        catch (Exception e) {
            System.err.println("General Error");
        }
    }

    /**
     * Create a data tables inside of the database
     */
    void createTables()
    {
        String userSql = "CREATE TABLE " + this.userTableName + "(" +
                "ID INT(8) NOT NULL, " +
                "PASSWORD VARCHAR(20) NOT NULL, " +
                "EMAIL VARCHAR(50) NOT NULL, " +
                "FIRSTNAME VARCHAR(30) NOT NULL," +
                "LASTNAME VARCHAR(30) NOT NULL," +
                "TYPE CHAR(1) NOT NULL, " +
                "PRIMARY KEY ( id ))";
        String courseSql = "CREATE TABLE " + this.courseTableName + "(" +
                "ID INT(8) PRIMARY KEY, " +
                "PROFESSORID INT(8) NOT NULL, " +
                "COURSENAME VARCHAR(50) NOT NULL, " +
                "ACTIVE BIT(1) NOT NULL ) ";
        String studentEnrollmentSql = "CREATE TABLE " + this.studentEnrollmentTableName + "(" +
                "ID INT(8) PRIMARY KEY, " +
                "STUDENTID INT(8) NOT NULL, " +
                "ACTIVE BIT(1) NOT NULL, "+
                "COURSEID INT(8) NOT NULL ) ";
        String assignmentSql = "CREATE TABLE " + this.assignmentTableName + "(" +
                "ID INT(8) PRIMARY KEY, " +
                "COURSEID INT(8) NOT NULL,"+
                "ASSIGNMENTTITLE VARCHAR(50) NOT NULL, " +
                "ASSIGNMENTPATH VARCHAR(100) NOT NULL, "+
                "ACTIVE BIT(1) NOT NULL, "+
                "DUEDATE CHAR(16) NOT NULL ) ";
        String submissionSql = "CREATE TABLE " + this.submissionTableName + "(" +
                "ID INT(8) PRIMARY KEY, " +
                "ASSIGNMENTID INT(8) NOT NULL,"+
                "STUDENTID INT(8) NOT NULL, " +
                "PATH VARCHAR(100) NOT NULL, "+
                "TITLE VARCHAR(50) NOT NULL, "+
                "SUBMISSIONGRADE INT(3) NOT NULL,"+
                "COMMENTS VARCHAR(140) NOT NULL, "+
                "TIMESTAMP CHAR(16) NOT NULL ) ";
        String gradeSql = "CREATE TABLE " + this.gradeTableName + "(" +
                "ID INT(8) PRIMARY KEY, " +
                "ASSIGNMENTID INT(8) NOT NULL,"+
                "STUDENTID INT(8) NOT NULL, " +
                "COURSEID INT(8) NOT NULL, " +
                "ASSIGNMENTGRADE INT(3) NOT NULL ) ";
        try{
            // Create user table
            statement = jdbc_connection.prepareStatement(userSql);
            statement.executeUpdate();
            System.out.println("Created Table " + userTableName);
            // Create course table
            statement = jdbc_connection.prepareStatement(courseSql);
            statement.executeUpdate();
            System.out.println("Created Table " + courseTableName);
            // Create studentEnrollment table
            statement = jdbc_connection.prepareStatement(studentEnrollmentSql);
            statement.executeUpdate();
            System.out.println("Created Table " + studentEnrollmentTableName);
            // Create assignment table
            statement = jdbc_connection.prepareStatement(assignmentSql);
            statement.executeUpdate();
            System.out.println("Created Table " + assignmentTableName);
            // Create submission table
            statement = jdbc_connection.prepareStatement(submissionSql);
            statement.executeUpdate();
            System.out.println("Created Table " + submissionTableName);
            // Create grade table
            statement = jdbc_connection.prepareStatement(gradeSql);
            statement.executeUpdate();
            System.out.println("Created Table " + gradeTableName);

        }
        catch(SQLException e)
        {
            // e.printStackTrace();
            removeTables();

        }
    }

    /**
     * Removes the data tables from the database (and all the data held within it!)
     */
    void removeTables()
    {
        String userSql = "DROP TABLE " + userTableName;
        String courseSql = "DROP TABLE " + courseTableName;
        String studentEnrollmentSql = "DROP TABLE " + studentEnrollmentTableName;
        String assignmentSql = "DROP TABLE " + assignmentTableName;
        String submissionSql = "DROP TABLE " + submissionTableName;
        String gradeSql = "DROP TABLE " + gradeTableName;

        try{
            // Remove user table
            statement = jdbc_connection.prepareStatement(userSql);
            statement.executeUpdate();
            System.out.println("Removed Table " + userTableName);
            // Remove course table
            statement = jdbc_connection.prepareStatement(courseSql);
            statement.executeUpdate();
            System.out.println("Removed Table " + courseTableName);
            // Remove studentEnrollment table
            statement = jdbc_connection.prepareStatement(studentEnrollmentSql);
            statement.executeUpdate();
            System.out.println("Removed Table " + studentEnrollmentTableName);
            // Remove assignment table
            statement = jdbc_connection.prepareStatement(assignmentSql);
            statement.executeUpdate();
            System.out.println("Removed Table " + assignmentTableName);
            // Remove submission table
            statement = jdbc_connection.prepareStatement(submissionSql);
            statement.executeUpdate();
            System.out.println("Removed Table " + submissionTableName);
            // Remove grade table
            statement = jdbc_connection.prepareStatement(gradeSql);
            statement.executeUpdate();
            System.out.println("Removed Table " + gradeTableName);
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        try {
            statement.close();
            jdbc_connection.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally
        {
            System.out.println("\nThe program is finished running");
        }
    }

    /**
     * Fills the data table with all the Clients from the text file 'clients.txt' if found
     */
    public void fillTable()
    {
        try{
            Scanner sc = new Scanner(new FileReader(dataFile));
            while(sc.hasNext())
            {
                String userInfo[] = sc.nextLine().split(";");
               // addUser( new User( clientInfo[0], clientInfo[1], clientInfo[2], clientInfo[3], clientInfo[4], clientInfo[5]));
            }
            sc.close();
        }
        catch(FileNotFoundException e)
        {
            System.err.println("File " + dataFile + " Not Found!");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    /**
     * Add a User to the User database table
     * @param user the User to be added to the User database Table
     * @param loginInfo the LoginInfo to be added to the User database table
     */
    void addUser(User user, LoginInfo loginInfo)
    {
        String sql = "INSERT INTO " + userTableName +
                " VALUES ( " +
                totalUserEnteries + ", '" +
                loginInfo.getPassword() + "', '"+
                user.getUserEmail() + "', '" +
                user.getFirstName() + "', '" +
                user.getLastName() + "', '" +
                user.getUserType()+ "');";
                totalUserEnteries++;
        try{
            statement = jdbc_connection.prepareStatement(sql);
            statement.executeUpdate();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
    /**
     * Add a Course to the Course database table
     * @param course the Course to be added to the Course database table
     */
    void addCourse(Course course)
    {
        String sql = "INSERT INTO " + courseTableName +
                " VALUES ( " +
                totalCourseEnteries + ", "+
                course.getProfessorID() + ", '" +
                course.getCourseName() + "', " +
                course.getActive()+ ");";
                totalCourseEnteries++;
                course.setCourseID(totalCourseEnteries);
                System.out.println("Added Course: "+ course.getCourseName());
        try{
            statement = jdbc_connection.prepareStatement(sql);
            statement.executeUpdate();
            printCourseTable();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
    /**
     * Add a StudentEnrollment to the studentEnrollent database table
     * @param studentEnrollment the studentEnrollment to be added to the studentEnrollment database table
     */
    void addStudentEnrollment(StudentEnrollment studentEnrollment)
    {
        String sql = "INSERT INTO " + studentEnrollmentTableName +
                " VALUES ( " +
                totalEnrollmentEnteries + ", " +
                studentEnrollment.getStudentID() + ", " +
                studentEnrollment.getEnrolling()+", "+
                studentEnrollment.getCourseID() + ");";
                totalEnrollmentEnteries++;
                studentEnrollment.setEnrollmentID(totalEnrollmentEnteries);
        try{
            statement = jdbc_connection.prepareStatement(sql);
            statement.executeUpdate();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
    /**
     * Add and Assignment to the Assignment database table
     * @param assignment the Assignment to be added to the Assignment database table
     */
    void addAssignment(Assignment assignment)
    {
        String sql = "INSERT INTO " + assignmentTableName +
                " VALUES ( " +
                totalAssignmentEnteries + ", " +
                assignment.getCourseID() + ", '" +
                assignment.getAssignmentTitle() + "', '" +
                assignment.getAssignmentPath() + "', " +
                assignment.getActive()+ ", '" +
                assignment.getDueDate()+ "');";
                totalAssignmentEnteries++;
                assignment.setAssignmentID(totalAssignmentEnteries);
                System.out.println("Added Assignment: "+ assignment.getAssignmentTitle());

        try{
            statement = jdbc_connection.prepareStatement(sql);
            statement.executeUpdate();
            printAssignmentTable();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
    /**
     * Add a Submission to the Submission database table
     * @param submission the Submission to be added to the Submission database table
     */
    void addSubmission(Submission submission)
    {
        String sql = "INSERT INTO " + submissionTableName +
                " VALUES ( " +
                totalSubmissionEnteries + ", " +
                submission.getAssignmentID() + ", " +
                submission.getStudentID() + ", '" +
                submission.getSubmissionPath() + "', '" +
                submission.getSubmissionGrade() + "', '" +
                submission.getSubmissionComment() + "', '" +
                submission.getSubmissionTimestamp() + "', '" +
                submission.getAssignmentTitle()+ "');";
                totalSubmissionEnteries++;
                submission.setSubmissionID(totalSubmissionEnteries);
                System.out.println("Added Submission: "+ submission.getAssignmentTitle());
        try{
            statement = jdbc_connection.prepareStatement(sql);
            statement.executeUpdate();
            printSubmissionTable();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
    /**
     * Add a Grade to the Grade database table
     * @param grade the Grade to be added to the Grade database table
     */
    void addGrade(Grade grade)
    {
        String sql = "INSERT INTO " + gradeTableName +
                " VALUES ( " +
                totalGradeEnteries + ", " +
                grade.getAssignmentID() + ", " +
                grade.getStudentID() + ", " +
                grade.getCourseID() + ", " +
                grade.getAssignmentGrade()+ ");";
                totalGradeEnteries++;
                grade.setGradeID(totalGradeEnteries);
                System.out.println("Added Grade: "+ grade.getAssignmentGrade());
        try{
            statement = jdbc_connection.prepareStatement(sql);
            statement.executeUpdate();
            printGradeTable();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
    /**
     * This method searches the database table for an Object matching the ID parameter and return that ResultSet.
     * @param tableName the name of the database table being searched.
     * @param ID the ID of the Object to be searched
     * @return the Object matching the ID. It should return null if no Objects matching that ID are found in the dataTable.
     */
    ResultSet searchByID(String tableName, int ID)
    {
        String sql = "SELECT * FROM " + tableName + "  WHERE ID =" + ID;
        ResultSet user;
        try {
            statement = jdbc_connection.prepareStatement(sql);
            user = statement.executeQuery();
            return user;
        } catch (SQLException e) { e.printStackTrace(); }
        return null;
    }
    /**
     * This method searches the Users database table for a User matching the ID parameter and return that User.
     * @param ID the ID of the User to be searched
     * @return the User matching the ID. It should return null if no Users matching that ID are found.
     */
    User searchUsers(int ID) {
        try {
            ResultSet users = searchByID(userTableName, ID);
            if(users == null) {
                return null;
            }
            User temp = null;
            while(users.next())
            {
                temp = new User (users.getString("EMAIL"),
                        users.getString("LASTNAME"),
                        users.getString("FIRSTNAME"),
                        users.getString("TYPE").charAt(0));
                temp.setID(users.getInt("ID"));
            }
            users.close();
            return temp;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * This method searches the Users database table for a User matching the lastName parameter and return that User.
     * @param lastName the lastName of the User to be searched
     * @return the User matching the lastName. It should return null if no Users matching that ID are found.
     */
    ArrayList<StudentEnrollment> searchUsers(String lastName) {
        try{
            printUserTable();
            String sql = "SELECT * FROM " + userTableName + "  WHERE LASTNAME = '" + lastName + "'";
            statement = jdbc_connection.prepareStatement(sql);
            ResultSet users = statement.executeQuery();
            ArrayList<StudentEnrollment> enrollmentList = new ArrayList<>();

            if(users == null) {
                return null;
            }
            User temp = null;
            while(users.next())
            {
                temp = new User (users.getString("EMAIL"),
                        users.getString("LASTNAME"),
                        users.getString("FIRSTNAME"),
                        users.getString("TYPE").charAt(0));
                temp.setID( users.getInt("ID"));
                System.out.println("HI");

                ArrayList<StudentEnrollment> se = searchStudentEnrollment(temp.getID());
                StudentEnrollment [] enrollments = se.toArray(new StudentEnrollment [se.size()]);
                if(enrollments[0]!=null) {
                    enrollmentList.add(enrollments[0]);
                }
            }
            users.close();
            return enrollmentList;
        }catch (SQLException e) { e.printStackTrace(); }
        return null;
    }
    /**
     * This method searches the Courses database table for a Course matching the ID parameter and return that Course.
     * @param userType the ID of the Course to be searched
     * @return the Course matching the ID. It should return null if no Courses matching that ID are found.
     */
    ArrayList<User> searchAllUsers(String userType) {
        try {
            String sql = "SELECT * FROM " + userTableName + "  WHERE TYPE =" + userType;
            statement = jdbc_connection.prepareStatement(sql);
            ResultSet users = statement.executeQuery();
            User temp;
            ArrayList<User> courseList = new ArrayList<>();
            while(users.next())
            {
                temp = new User (users.getString("LASTNAME"),
                        users.getString("FIRSTNAME"),
                        users.getString("EMAIL"),
                        users.getString("TYPE").charAt(0));

                temp.setID(users.getInt("ID"));
                courseList.add(temp);
            }
            users.close();
            return courseList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * This method searches the Courses database table for a Course matching the ID parameter and return that Course.
     * @param ID the ID of the Course to be searched
     * @return the Course matching the ID. It should return null if no Courses matching that ID are found.
     */
    Course searchCourses(int ID) {
        try {
            ResultSet courses = searchByID(courseTableName, ID);
            if(courses == null) {
                return null;
            }
            Course temp = null;
            while(courses.next())
            {
                boolean activeBoolean = false;
                if(courses.getString("ACTIVE").charAt(0)=='0') {
                    activeBoolean = false;
                }
                else if(courses.getString("ACTIVE").charAt(0)=='1') {
                    activeBoolean = true;
                }
                temp = new Course (courses.getInt("PROFESSORID"),
                        courses.getString("COURSENAME"),
                        activeBoolean);
                temp.setCourseID(courses.getInt("ID"));
            }
            courses.close();
            return temp;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * This method searches the Courses database table for a Course matching the ID parameter and return that Course.
     * @return the Course matching the ID. It should return null if no Courses matching that ID are found.
     */
    ArrayList<Course> searchAllCourses() {
        try {
            String sql = "SELECT * FROM " + courseTableName;
            statement = jdbc_connection.prepareStatement(sql);
            ResultSet courses = statement.executeQuery();
            Course temp;
            ArrayList<Course> courseList = new ArrayList<>();
            while(courses.next())
            {
                boolean activeBoolean = false;
                if(courses.getString("ACTIVE").charAt(0)=='0') {
                    activeBoolean = false;
                }
                else if(courses.getString("ACTIVE").charAt(0)=='1') {
                    activeBoolean = true;
                }
                temp = new Course (courses.getInt("PROFESSORID"),
                        courses.getString("COURSENAME"),
                        activeBoolean);
                temp.setCourseID(courses.getInt("ID"));
                courseList.add(temp);
            }
            courses.close();
            return courseList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    ArrayList<Course> searchEnrolledActiveCourses() {
        try {
            String sql = "SELECT * FROM " + courseTableName;
            statement = jdbc_connection.prepareStatement(sql);
            ResultSet courses = statement.executeQuery();
            Course temp;
            ArrayList<Course> courseList = new ArrayList<>();
            while(courses.next()) {
                boolean activeBoolean = false;
                if (courses.getString("ACTIVE").charAt(0) == '0') {
                    activeBoolean = false;
                } else if (courses.getString("ACTIVE").charAt(0) == '1') {
                    activeBoolean = true;
                }
                temp = new Course(courses.getInt("PROFESSORID"),
                        courses.getString("COURSENAME"),
                        activeBoolean);
                temp.setCourseID(courses.getInt("ID"));

                if (activeBoolean == true){
                    isEnrolled(temp.getCourseID());

                    if (activeBoolean == true) {
                        courseList.add(temp);
                    }
                }
            }
            courses.close();
            return courseList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public boolean isEnrolled(int courseID) {
        try {
            String sql = "SELECT * FROM " + studentEnrollmentTableName + "  WHERE COURSEID =" + courseID;
            ResultSet enrollments = statement.executeQuery();
            StudentEnrollment temp = null;
            boolean activeBoolean = false;

            while(enrollments.next())
            {
                if(enrollments.getString("ACTIVE").charAt(0)=='0') {
                    activeBoolean = false;
                }
                else if(enrollments.getString("ACTIVE").charAt(0)=='1') {
                    activeBoolean = true;
                }
                temp = new StudentEnrollment (enrollments.getInt("STUDENTID"),
                        enrollments.getInt("COURSEID"), activeBoolean);
                temp.setEnrollmentID(enrollments.getInt("ID"));
            }
            enrollments.close();
            if(activeBoolean==true){
                return true;
            }
            else
                return false;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    /**
     * This method searches the StudentEnrollment database table for a StudentEnrollment matching the ID parameter
     * and return that StudentEnrollment.
     * @param ID the ID of the StudentEnrollment to be searched
     * @return the StudentEnrollment matching the ID. It should return null if no StudentEnrollments matching that ID are found.
     */
    ArrayList<StudentEnrollment> searchStudentEnrollment(int ID) {
        try {
            printStudentEnrollmentTable();
            String sql = "SELECT * FROM " + studentEnrollmentTableName + "  WHERE STUDENTID =" + ID;
            ResultSet enrollments = statement.executeQuery();
            ArrayList<StudentEnrollment> enrollmentlist = new ArrayList<>();

            try {
                statement = jdbc_connection.prepareStatement(sql);
                enrollments = statement.executeQuery();
            } catch (SQLException e) { e.printStackTrace(); }

            if(enrollments == null) {
                return null;
            }
            StudentEnrollment temp = null;
            while(enrollments.next())
            {
                boolean activeBoolean = false;
                if(enrollments.getString("ACTIVE").charAt(0)=='0') {
                    activeBoolean = false;
                }
                else if(enrollments.getString("ACTIVE").charAt(0)=='1') {
                    activeBoolean = true;
                }
                temp = new StudentEnrollment (enrollments.getInt("STUDENTID"),
                        enrollments.getInt("COURSEID"), activeBoolean);
                temp.setEnrollmentID(enrollments.getInt("ID"));
                enrollmentlist.add(temp);
            }
            enrollments.close();
            return enrollmentlist;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * This method searches the Courses database table for a Course matching the ID parameter and return that Course.
     * @return the Course matching the ID. It should return null if no Courses matching that ID are found.
     */
    ArrayList<StudentEnrollment> searchAllStudentEnrollments() {
        try {
            String sql = "SELECT * FROM " + studentEnrollmentTableName;
            statement = jdbc_connection.prepareStatement(sql);
            ResultSet enrollments = statement.executeQuery();
            StudentEnrollment temp;
            ArrayList<StudentEnrollment> courseList = new ArrayList<>();
            while(enrollments.next())
            {
                boolean activeBoolean = false;
                if(enrollments.getString("ACTIVE").charAt(0)=='0') {
                    activeBoolean = false;
                }
                else if(enrollments.getString("ACTIVE").charAt(0)=='1') {
                    activeBoolean = true;
                }
                temp = new StudentEnrollment (enrollments.getInt("STUDENTID"),
                        enrollments.getInt("COURSEID"), activeBoolean);
                temp.setEnrollmentID(enrollments.getInt("ID"));

                courseList.add(temp);
            }
            enrollments.close();
            return courseList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    ArrayList<StudentEnrollment> searchEnrolled() {
        try {
            String sql = "SELECT * FROM " + studentEnrollmentTableName;
            statement = jdbc_connection.prepareStatement(sql);
            ResultSet enrollments = statement.executeQuery();
            StudentEnrollment temp;
            ArrayList<StudentEnrollment> courseList = new ArrayList<>();
            while(enrollments.next())
            {
                boolean activeBoolean = false;
                if(enrollments.getString("ACTIVE").charAt(0)=='1') {
                    activeBoolean = true;

                    temp = new StudentEnrollment(enrollments.getInt("STUDENTID"),
                            enrollments.getInt("COURSEID"), activeBoolean);

                    temp.setEnrollmentID(enrollments.getInt("ID"));

                    courseList.add(temp);
                }
            }
            enrollments.close();
            return courseList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * This method searches the Assignment database table for a Assignment matching the ID parameter and return that Assignment.
     * @param ID the ID of the Assignment to be searched
     * @return the Assignment matching the ID. It should return null if no Grades matching that ID are found.
     */
    Assignment searchAssignments(int ID) {
        try {
            ResultSet assignments = searchByID(assignmentTableName, ID);
            if(assignments == null) {
                return null;
            }
            Assignment temp = null;
            while(assignments.next())
            {
                boolean activeBoolean = false;
                if(assignments.getString("ACTIVE").charAt(0)=='0') {
                    activeBoolean = false;
                }
                else if(assignments.getString("ACTIVE").charAt(0)=='1') {
                    activeBoolean = true;
                }
                temp = new Assignment(assignments.getInt("COURSEID"),
                        assignments.getString("ASSIGNMENTTITLE"),
                        assignments.getString("ASSIGNMENTPATH"),
                        activeBoolean,
                        assignments.getString("DUEDATE"));
                temp.setAssignmentID(assignments.getInt("ID"));
            }
            assignments.close();
            return temp;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * This method searches the Courses database table for a Course matching the ID parameter and return that Course.
     * @return the Course matching the ID. It should return null if no Courses matching that ID are found.
     */
    ArrayList<Assignment> searchAllAssignments(int courseID) {
        try {
            String sql = "SELECT * FROM " + assignmentTableName;
            statement = jdbc_connection.prepareStatement(sql);
            ResultSet assignments = statement.executeQuery();
            Assignment temp;
            ArrayList<Assignment> courseList = new ArrayList<>();
            while(assignments.next())
            {
                boolean activeBoolean = false;
                if(assignments.getString("ACTIVE").charAt(0)=='0') {
                    activeBoolean = false;
                }
                else if(assignments.getString("ACTIVE").charAt(0)=='1') {
                    activeBoolean = true;
                }
                temp = new Assignment (assignments.getInt("COURSEID"),
                        assignments.getString("ASSIGNMENTTITLE"),
                        assignments.getString("ASSIGNMENTPATH"),
                        activeBoolean,
                        assignments.getString("DUEDATE"));

                temp.setAssignmentID(assignments.getInt("ID"));

                if(temp.getCourseID()==courseID){
                    courseList.add(temp);
                }
            }
            assignments.close();
            return courseList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    ArrayList<Assignment> searchAllAssignments() {
        try {
            String sql = "SELECT * FROM " + assignmentTableName;
            statement = jdbc_connection.prepareStatement(sql);
            ResultSet assignments = statement.executeQuery();
            Assignment temp;
            ArrayList<Assignment> courseList = new ArrayList<>();
            while(assignments.next())
            {
                boolean activeBoolean = false;
                if(assignments.getString("ACTIVE").charAt(0)=='0') {
                    activeBoolean = false;
                }
                else if(assignments.getString("ACTIVE").charAt(0)=='1') {
                    activeBoolean = true;
                }
                temp = new Assignment (assignments.getInt("COURSEID"),
                        assignments.getString("ASSIGNMENTTITLE"),
                        assignments.getString("ASSIGNMENTPATH"),
                        activeBoolean,
                        assignments.getString("DUEDATE"));

                temp.setAssignmentID(assignments.getInt("ID"));

                    courseList.add(temp);
            }
            assignments.close();
            return courseList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * This method searches the Submissions database table for a Submission matching the ID parameter and return that Submission.
     * @param ID the ID of the Submission to be searched
     * @return the Submission matching the ID. It should return null if no Submissions matching that ID are found.
     */
    Submission searchSubmissions(int ID) {
        try {
            ResultSet submissions = searchByID(submissionTableName, ID);
            if(submissions == null) {
                return null;
            }
            Submission temp = null;
            while(submissions.next())
            {
                temp = new Submission (submissions.getInt("ASSIGNMENTID"),
                        submissions.getInt("STUDENTID"),
                        submissions.getString("PATH"),
                        submissions.getInt("SUBMISSIONGRADE"),
                        submissions.getString("COMMENTS"),
                        submissions.getString("TIMESTAMP"),
                        submissions.getString("TITLE"));
                temp.setSubmissionID(submissions.getInt("ID"));
            }
            submissions.close();
            return temp;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * This method searches the Courses database table for a Course matching the ID parameter and return that Course.
     * @return the Course matching the ID. It should return null if no Courses matching that ID are found.
     */

    ArrayList<Submission> searchAllSubmissions() {
        try {
            String sql = "SELECT * FROM " + submissionTableName;
            statement = jdbc_connection.prepareStatement(sql);
            ResultSet submissions = statement.executeQuery();
            Submission temp;
            ArrayList<Submission> courseList = new ArrayList<>();
            while(submissions.next())
            {
                temp = new Submission (submissions.getInt("ASSIGNMENTID"),
                        submissions.getInt("STUDENTID"),
                        submissions.getString("PATH"),
                        submissions.getInt("SUBMISSIONGRADE"),
                        submissions.getString("TITLE"),
                        submissions.getString("COMMENTS"),
                        submissions.getString("TIMESTAMP"));

                temp.setSubmissionID(submissions.getInt("ID"));

                courseList.add(temp);
            }
            submissions.close();
            return courseList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * This method searches the Grade database table for a Grade matching the ID parameter and return that Grade.
     * @param ID the ID of the Grade to be searched
     * @return the Grade matching the ID. It should return null if no Grades matching that ID are found.
     */
    Grade searchGrades(int ID) {
        try {
            ResultSet submissions = searchByID(gradeTableName, ID);
            if(submissions == null) {
                return null;
            }
            Grade temp = null;
            while(submissions.next())
            {
                temp = new Grade (submissions.getInt("ASSIGNMENTID"),
                        submissions.getInt("STUDENTID"),
                        submissions.getInt("COURSEID"),
                        submissions.getInt("ASSIGNMENTGRADE"));
                temp.setGradeID(submissions.getInt("ID"));
            }
            submissions.close();
            return temp;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * This method searches the Courses database table for a Course matching the ID parameter and return that Course.
     * @return the Course matching the ID. It should return null if no Courses matching that ID are found.
     */

    ArrayList<Grade> searchAllGrades() {
        try {
            String sql = "SELECT * FROM " + gradeTableName;
            statement = jdbc_connection.prepareStatement(sql);
            ResultSet grades = statement.executeQuery();
            Grade temp;
            ArrayList<Grade> courseList = new ArrayList<>();
            while(grades.next())
            {
                temp = new Grade (grades.getInt("ASSIGNMENTID"),
                        grades.getInt("STUDENTID"),
                        grades.getInt("COURSEID"),
                        grades.getInt("ASSIGNMENTGRADE"));

                temp.setGradeID(grades.getInt("ID"));

                courseList.add(temp);
            }
            grades.close();
            return courseList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Prints all the items in the User database to console
     */
    void printUserTable()
    {
        try {
            String sql = "SELECT * FROM " + userTableName;
            statement = jdbc_connection.prepareStatement(sql);
            ResultSet users = statement.executeQuery();
            System.out.println("\nUsers:");
            while(users.next())
            {
                System.out.println(users.getString("ID") + " " +
                        users.getString("PASSWORD") + " " +
                        users.getString("EMAIL") + " " +
                        users.getString("FIRSTNAME") + " " +
                        users.getString("LASTNAME") + " " +
                        users.getString("TYPE")+ " ");
            }
            System.out.println();
            users.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Prints all the items in the Course database to console
     */
    void printCourseTable()
    {
        try {
            String sql = "SELECT * FROM " + courseTableName;
            statement = jdbc_connection.prepareStatement(sql);
            ResultSet courses = statement.executeQuery();
            System.out.println("\nCourses:");
            while(courses.next())
            {
                System.out.println(courses.getString("ID") + " " +
                        courses.getString("PROFESSORID") + " " +
                        courses.getString("COURSENAME")+ " "+
                        courses.getString("ACTIVE"));
            }
            System.out.println();
            courses.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Prints all the items in the StudentEnrollment database to console
     */
    void printStudentEnrollmentTable()
    {
        try {
            String sql = "SELECT * FROM " + studentEnrollmentTableName;
            statement = jdbc_connection.prepareStatement(sql);
            ResultSet enrollments = statement.executeQuery();
            System.out.println("\nStudent Enrollment:");
            while(enrollments.next())
            {
                System.out.println(enrollments.getString("ID") + " " +
                        enrollments.getString("STUDENTID") + " " +
                        enrollments.getString("COURSEID")+ " ");
            }
            System.out.println();
            enrollments.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Prints all the items in the Assignment database to console
     */
    void printAssignmentTable()
    {
        try {
            String sql = "SELECT * FROM " + assignmentTableName;
            statement = jdbc_connection.prepareStatement(sql);
            ResultSet assignments = statement.executeQuery();
            System.out.println("\nAssignments:");
            while(assignments.next())
            {
                System.out.println(assignments.getString("ID") + " " +
                        assignments.getString("COURSEID") + " " +
                        assignments.getString("ASSIGNMENTTITLE") + " " +
                        assignments.getString("ASSIGNMENTPATH") + " " +
                        assignments.getString("ACTIVE") + " " +
                        assignments.getString("DUEDATE")+ " ");
            }
            System.out.println();
            assignments.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Prints all the items in the Submission database to console
     */
    void printSubmissionTable()
    {
        try {
            String sql = "SELECT * FROM " + submissionTableName;
            statement = jdbc_connection.prepareStatement(sql);
            ResultSet submissions = statement.executeQuery();
            System.out.println("\nSubmission:");
            while(submissions.next())
            {
                System.out.println(submissions.getString("ID") + " " +
                        submissions.getString("ASSIGNMENTID") + " " +
                        submissions.getString("STUDENTID") + " " +
                        submissions.getString("PATH") + " " +
                        submissions.getString("TITLE") + " " +
                        submissions.getString("SUBMISSIONGRADE") + " " +
                        submissions.getString("COMMENTS") + " " +
                        submissions.getString("TIMESTAMP")+ " ");
            }
            System.out.println();
            submissions.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Prints all the items in the Grade database to console
     */
    void printGradeTable()
    {
        try {
            String sql = "SELECT * FROM " + gradeTableName;
            statement = jdbc_connection.prepareStatement(sql);
            ResultSet grades = statement.executeQuery();
            System.out.println("\nGrade:");
            while(grades.next())
            {
                System.out.println(grades.getString("ID") + " " +
                        grades.getString("ASSIGNMENTID") + " " +
                        grades.getString("STUDENTID") + " " +
                        grades.getString("COURSEID") + " " +
                        grades.getString("ASSIGNMENTGRADE")+ " ");
            }
            System.out.println();
            grades.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Deletes a User from the database with a matching id.
     * @param userID the userID of the User to be deleted.
     */
    public void deleteUser(int userID) {
        try {
            String sql = "DELETE FROM " + userTableName + " WHERE ID = "+userID;
            statement = jdbc_connection.prepareStatement(sql);
            statement.executeUpdate();
            System.out.println("Deleted User with ID = "+ userID);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Deletes a Course from the database with a matching id.
     * @param courseID the courseID of the Course to be deleted.
     */
    void deleteCourse(int courseID) {
        try {
            String sql = "DELETE FROM " + courseTableName + " WHERE ID = "+courseID;
            statement = jdbc_connection.prepareStatement(sql);
            statement.executeUpdate();
            System.out.println("Deleted Course with ID = "+ courseID);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Deletes a StudentEnrollment from the database with a matching id.
     * @param enrollmentID the enrollmentID of the StudentEnrollment to be deleted.
     */
    void deleteStudentEnrollment(int enrollmentID) {
        try {
            String sql = "DELETE FROM " + studentEnrollmentTableName + " WHERE ID = "+enrollmentID;
            statement = jdbc_connection.prepareStatement(sql);
            statement.executeUpdate();
            System.out.println("Deleted Enrollment with ID = "+ enrollmentID);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Deletes an Assignment from the database with a matching id.
     * @param assignmentID the assignmentID of the Assignment to be deleted.
     */
    void deleteAssignment(int assignmentID) {
        try {
            String sql = "DELETE FROM " + assignmentTableName + " WHERE ID = " + assignmentID;
            statement = jdbc_connection.prepareStatement(sql);
            statement.executeUpdate();
            System.out.println("Deleted Assignment with ID = "+ assignmentID);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Deletes a Submission from the database with a matching id.
     * @param submissionID the submissionID of the Submission to be deleted.
     */
    void deleteSubmission(int submissionID) {
        try {
            String sql = "DELETE FROM " + submissionTableName + " WHERE ID = " + submissionID;
            statement = jdbc_connection.prepareStatement(sql);
            statement.executeUpdate();
            System.out.println("Deleted Submission with ID = "+ submissionID);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Deletes a Grade from the database with a matching id.
     * @param gradeID the gradeID of the Grade to be deleted.
     */
    void deleteGrade(int gradeID) {
        try {
            String sql = "DELETE FROM " + gradeTableName + " WHERE ID = " + gradeID;
            statement = jdbc_connection.prepareStatement(sql);
            statement.executeUpdate();
            System.out.println("Deleted Grade with ID = "+ gradeID);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ID must be kept the same for all modifies
    /**
     * Modifies a Course from the database with a matching id.
     * @param course the updated Course to be modified in the database.
     */
    void modifyCourse(Course course) {
        String sql = "UPDATE " + courseTableName + " SET  " +
                " ID = '"+ course.getCourseID() + "', " +
                " PROFESSORID = '"+course.getProfessorID() + "', " +
                " COURSENAME ='"+ course.getCourseName() + "', " +
                " ACTIVE =" +course.getActive()+ " WHERE ID = "+course.getCourseID() +";";
        try {
            statement = jdbc_connection.prepareStatement(sql);
            statement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }

    // ID must be kept the same for all modifies
    /**
     * Modifies a StudentEnrollmet from the database with a matching id.
     * @param studentEnrollment the updated StudentEnrollment to be modified in the database.
     */
    void modifyStudentEnrollment(StudentEnrollment studentEnrollment) {
        String sql = "UPDATE " + studentEnrollmentTableName + " SET  " +
                " ID = "+ studentEnrollment.getEnrollmentID() + ", " +
                " STUDENTID = "+studentEnrollment.getStudentID() + ", " +
                " ACTIVE = "+studentEnrollment.getEnrolling() + ", "+
                " COURSEID =" +studentEnrollment.getCourseID() + " WHERE ID = "+studentEnrollment.getEnrollmentID() +";";
        try {
            statement = jdbc_connection.prepareStatement(sql);
            statement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ID must be kept the same for all modifies
    /**
     * Modifies an Assignment from the database with a matching id.
     * @param assignment the updated Assignment to be modified in the database.
     */
    void modifyAssignment(Assignment assignment) {
        String sql = "UPDATE " + assignmentTableName + " SET  " +
                " ID = '"+ assignment.getAssignmentID() + "', " +
                " COURSEID = '"+assignment.getCourseID() + "', " +
                " ASSIGNMENTTITLE ='"+ assignment.getAssignmentTitle() + "', " +
                " ASSIGNMENTPATH ='"+assignment.getAssignmentPath() + "', " +
                " ACTIVE ="+assignment.getActive() + ", " +
                " DUEDATE ='" +assignment.getDueDate()+ "'"+ " WHERE ID = "+assignment.getAssignmentID() +";";
        try {
            statement = jdbc_connection.prepareStatement(sql);
            statement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

