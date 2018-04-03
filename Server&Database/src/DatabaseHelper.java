import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.*;
import java.util.Scanner;
import SharedDataObjects.*;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 * This class allows you to create and manage a client database.
 * It creates a database and datatable, then populates that table with tools from
 * clients.txt.
 * @author Natalia Pavlovic
 * @version 1.0
 * @since April 3, 2018
 */
public class DatabaseHelper {
    static private int totalEnteries = 1;

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
    public String dataFile = "sampleInput.txt";

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
     * Constructs a ClientManager object from default values. Uses MySQL connector JAR
     * to connect to the server.
     */
    public DatabaseHelper()
    {
        try{
            // If this throws an error, make sure you have added the mySQL connector JAR to the project
            Class.forName("com.mysql.jdbc.Driver");

            // If this fails make sure your connectionInfo and login/password are correct
            jdbc_connection = DriverManager.getConnection(connectionInfo, login, password);
            System.out.println("Connected to: " + connectionInfo + "\n");
        }
        catch(SQLException e) { e.printStackTrace(); }
        catch(Exception e) { e.printStackTrace(); }
    }

    /**
     * Use the jdbc connection to create a new database in MySQL.
     * (e.g. if you are connected to "jdbc:mysql://localhost:3306", the database will be created at "jdbc:mysql://localhost:3306/InventoryDB")
     */
    public void createDB()
    {
        try {
            statement = jdbc_connection.prepareStatement("CREATE DATABASE " + databaseName);
            statement.executeUpdate();
            System.out.println("Created Database " + databaseName);
        }
        catch( SQLException e)
        {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create a data table inside of the database to hold Clients
     */
    public void createTables()
    {
        String userSql = "CREATE TABLE " + this.userTableName + "(" +
                "USERID INT(8) PRIMARY KEY, " +
                "PASSWORD VARCHAR(20) NOT NULL, " +
                "EMAIL VARCHAR(50) NOT NULL, " +
                "FIRSTNAME VARCHAR(30) NOT NULL," +
                "LASTNAME VARCHAR(30) NOT NULL," +
                "TYPE CHAR(1) NOT NULL ) ";
        String courseSql = "CREATE TABLE " + this.courseTableName + "(" +
                "COURSEID INT(8) PRIMARY KEY, " +
                "PROFESSORID INT(8) NOT NULL, " +
                "COURSENAME VARCHAR(50) NOT NULL, " +
                "ACTIVE BIT(1) NOT NULL ) ";
        String studentEnrollmentSql = "CREATE TABLE " + this.studentEnrollmentTableName + "(" +
                "ENROLLMENTID INT(8) PRIMARY KEY, " +
                "STUDENTID INT(8) NOT NULL, " +
                "COURSEID INT(8) NOT NULL ) ";
        String assignmentSql = "CREATE TABLE " + this.assignmentTableName + "(" +
                "ASSIGNMENTID INT(8) PRIMARY KEY, " +
                "COURSEID INT(8) NOT NULL,"+
                "ASSIGNMENTTITLE VARCHAR(50) NOT NULL, " +
                "ASSIGNMENTPATH VARCHAR(100) NOT NULL, "+
                "ACTIVE BIT(1) NOT NULL, "+
                "DUEDATE CHAR(16) NOT NULL ) ";
        String submissionSql = "CREATE TABLE " + this.submissionTableName + "(" +
                "SUBMISSIONID INT(8) PRIMARY KEY, " +
                "ASSIGNMENTID INT(8) NOT NULL,"+
                "STUDENTID INT(8) NOT NULL, " +
                "PATH VARCHAR(100) NOT NULL, "+
                "TITLE VARCHAR(50) NOT NULL, "+
                "SUBMISSIONGRADE INT(3) NOT NULL,"+
                "COMMENTS VARCHAR(140) NOT NULL, "+
                "TIMESTAMP CHAR(16) NOT NULL ) ";
        String gradeSql = "CREATE TABLE " + this.gradeTableName + "(" +
                "GRADEID INT(8) PRIMARY KEY, " +
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
            // Create assignment Table
            statement = jdbc_connection.prepareStatement(assignmentSql);
            statement.executeUpdate();
            System.out.println("Created Table " + assignmentTableName);
            // Create submission Table
            statement = jdbc_connection.prepareStatement(submissionSql);
            statement.executeUpdate();
            System.out.println("Created Table " + submissionTableName);            // Create submission Table
            statement = jdbc_connection.prepareStatement(gradeSql);
            statement.executeUpdate();
            System.out.println("Created Table " + gradeTableName);

        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Removes the data table from the database (and all the data held within it!)
     */
    public void removeTables()
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
                String assignmentInfo[] = sc.nextLine().split(";");
                addAssignment( new Assignment(totalEnteries, Integer.parseInt(assignmentInfo[0]), assignmentInfo[1], assignmentInfo[2], Boolean.valueOf(assignmentInfo[3]), assignmentInfo[4]));
                totalEnteries++;

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
     * Add a Client to the database table
     */
//    public void addAssignment(Assignment assignment)
//    {
//        String sql = "INSERT INTO " + assignmentTableName +
//                " VALUES ( " +
//                assignment.getAssignmentID() + ", '" +
//                assignment.getCourseID() + "', '" +
//                assignment.getAssignmentTitle() + "', '" +
//                assignment.getAssignmentPath() + "', " +
//                assignment.getActive()+ ", '" +
//                assignment.getDueDate()+ "');";
//
//        try{
//            statement = jdbc_connection.prepareStatement(sql);
//            statement.executeUpdate();
//        }
//        catch(SQLException e)
//        {
//            e.printStackTrace();
//        }
//    }
//    public void addAssignment(Assignment assignment)
//    {
//        String sql = "INSERT INTO " + assignmentTableName +
//                " VALUES ( " +
//                assignment.getAssignmentID() + ", '" +
//                assignment.getCourseID() + "', '" +
//                assignment.getAssignmentTitle() + "', '" +
//                assignment.getAssignmentPath() + "', " +
//                assignment.getActive()+ ", '" +
//                assignment.getDueDate()+ "');";
//
//        try{
//            statement = jdbc_connection.prepareStatement(sql);
//            statement.executeUpdate();
//        }
//        catch(SQLException e)
//        {
//            e.printStackTrace();
//        }
//    }
    public void addStudentEnrollment(StudentEnrollment studentEnrollment)
    {
        String sql = "INSERT INTO " + assignmentTableName +
                " VALUES ( " +
                studentEnrollment.getAssignmentID() + ", '" +
                studentEnrollment.getCourseID() + "', '" +
                studentEnrollment.getAssignmentTitle() + "', '" +
                studentEnrollment.getAssignmentPath() + "', " +
                studentEnrollment.getActive()+ ", '" +
                studentEnrollment.getDueDate()+ "');";

        try{
            statement = jdbc_connection.prepareStatement(sql);
            statement.executeUpdate();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
    public void addAssignment(Assignment assignment)
    {
        String sql = "INSERT INTO " + assignmentTableName +
                " VALUES ( " +
                assignment.getAssignmentID() + ", '" +
                assignment.getCourseID() + "', '" +
                assignment.getAssignmentTitle() + "', '" +
                assignment.getAssignmentPath() + "', " +
                assignment.getActive()+ ", '" +
                assignment.getDueDate()+ "');";

        try{
            statement = jdbc_connection.prepareStatement(sql);
            statement.executeUpdate();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

//    /**
//     * This method searches the database table for a Client matching the ClientType parameter and return that Client.
//     * @param ClientType the clientType of the Client to be searched
//     * @return the Client matching the ClientType. It should return null if no Clients matching that type are found.
//     */
//    public void searchByClientType(String ClientType)
//    {
//        String sql = "SELECT * FROM " + tableName + "  WHERE CLIENTTYPE =" + ClientType;
//        ResultSet client;
//        try {
//            statement = jdbc_connection.prepareStatement(sql);
//            client = statement.executeQuery();
//            while(client.next())
//            {
//                new Client (client.getInt("ID"),
//                        client.getString("FIRSTNAME"),
//                        client.getString("LASTNAME"),
//                        client.getString("ADDRESS"),
//                        client.getString("POSTALCODE"),
//                        client.getString("PHONENUMBER"),
//                        client.getString("CLIENTTYPE"));
//
//                view.updateJlist(Integer.toString(client.getInt("ID"))+ " " +
//                        client.getString("FIRSTNAME") + " " +
//                        client.getString("LASTNAME") + " " +
//                        client.getString("CLIENTTYPE"));
//            }
//
//        } catch (SQLException e) { e.printStackTrace(); }
//
//    }
//
//    /**
//     * This method searches the database table for a Client matching the lastName parameter and return that Client.
//     * @param LastName the lastName of the Client to be searched
//     * @return the Client matching the lastName. It should return null if no Clients matching that lastName are found.
//     */
//    public void searchByLastName(String LastName)
//    {
//        String sql = "SELECT * FROM " + tableName + "  WHERE LASTNAME =" + LastName;
//        ResultSet client;
//        try {
//            statement = jdbc_connection.prepareStatement(sql);
//            client = statement.executeQuery();
//            while(client.next())
//            {
//                new Client (client.getInt("ID"),
//                        client.getString("FIRSTNAME"),
//                        client.getString("LASTNAME"),
//                        client.getString("ADDRESS"),
//                        client.getString("POSTALCODE"),
//                        client.getString("PHONENUMBER"),
//                        client.getString("CLIENTTYPE"));
//
//                view.updateJlist(Integer.toString(client.getInt("ID"))+ " " +
//                        client.getString("FIRSTNAME") + " " +
//                        client.getString("LASTNAME") + " " +
//                        client.getString("CLIENTTYPE"));
//            }
//
//
//        } catch (SQLException e) { e.printStackTrace(); }
//
//    }
//
//    /**
//     * This method searches the database table for a Client matching the clientID parameter and return that Client.
//     * @param clientID the ID of the Client to be searched
//     * @param JListDisplay if true, means the result should be displayed on the GUI. Otherwise it should not be displayed.
//     * @return the Client matching the clientID. It should return null if no Clients matching that ID are found.
//     */
//    public Client searchByID(int clientID, boolean JListDisplay)
//    {
//        String sql = "SELECT * FROM " + tableName + "  WHERE ID =" + clientID;
//        ResultSet client;
//        try {
//            statement = jdbc_connection.prepareStatement(sql);
//            client = statement.executeQuery();
//            Client temp = null;
//            if(client.next())
//            {
//                temp =  new Client (client.getInt("ID"),
//                        client.getString("FIRSTNAME"),
//                        client.getString("LASTNAME"),
//                        client.getString("ADDRESS"),
//                        client.getString("POSTALCODE"),
//                        client.getString("PHONENUMBER"),
//                        client.getString("CLIENTTYPE"));
//
//                if(JListDisplay == true) {
//                    view.updateJlist(Integer.toString(client.getInt("ID")) + " " +
//                            client.getString("FIRSTNAME") + " " +
//                            client.getString("LASTNAME") + " " +
//                            client.getString("CLIENTTYPE"));
//                }
//            }
//            return temp;
//
//        } catch (SQLException e) { e.printStackTrace(); }
//        return null;
//    }
//
    /**
     * Prints all the items in the database to console
     */
    public void printTable()
    {
        try {
            String sql = "SELECT * FROM " + assignmentTableName;
            statement = jdbc_connection.prepareStatement(sql);
            ResultSet assignments = statement.executeQuery();
            System.out.println("\nAssignments:");
            while(assignments.next())
            {
                System.out.println(assignments.getString("ASSIGNMENTID") + " " +
                        assignments.getString("COURSEID") + " " +
                        assignments.getString("ASSIGNMENTTITLE") + " " +
                        assignments.getString("ASSIGNMENTPATH") + " " +
                        assignments.getString("ACTIVE") + " " +
                        assignments.getString("DUEDATE")+ " ");
            }
            System.out.println("");
            assignments.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    /**
//     * Deletes a Client from the database with a matching id.
//     * @param clientID the clientID of the Client to be deleted.
//     */
//    public void deleteClient(int clientID) {
//        try {
//            String sql = "DELETE FROM " + tableName + " WHERE ID = "+clientID;
//            statement = jdbc_connection.prepareStatement(sql);
//            statement.executeUpdate();
//        }
//        catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * Modifies a Client from the database with a matching id.
//     * @param client the updated Client to be modified in the database.
//     */
//    public void modifyClient(Client client) {
//        String sql = "UPDATE " + tableName + " SET  " +
//                " FIRSTNAME = '"+ client.getFirstName() + "', " +
//                " LASTNAME = '"+client.getLastName() + "', " +
//                " ADDRESS ='"+ client.getAddress() + "', " +
//                " POSTALCODE ='"+client.getPostalCode() + "', " +
//                " PHONENUMBER ='"+client.getPhoneNumber() + "', " +
//                " CLIENTTYPE ='" +client.getClientType()+ "'"+ " WHERE ID = "+client.getID() +";";
//        try {
//            statement = jdbc_connection.prepareStatement(sql);
//            statement.executeUpdate();
//        }
//        catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//    }

    /**
     * @param args a string array for input parameters passed to main
     */
    public static void main(String args[])
    {
        DatabaseHelper databaseHelper = new DatabaseHelper();

        // You should comment this line out once the first database is created (either here or in MySQL workbench)
        // databaseHelper.createDB();

        databaseHelper.createTables();
        databaseHelper.fillTable();
        databaseHelper.printTable();
        databaseHelper.removeTables();
    }

}
