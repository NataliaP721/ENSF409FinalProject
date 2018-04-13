package ClientPack;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.*;
import net.miginfocom.swing.*;
import SharedDataObjects.*;
/*
 * Created by JFormDesigner on Sun Apr 01 12:59:24 MDT 2018
 */

/**
 * * Creates the course homepage with the ability to navigate to other windows: Enroll Students, Send Emails, Manage Grades, Manage Submissions, Manage Assignments, or go back to the homepage.
 * @author  Natalia Pavlovic, Aysha Panatch, Eddy Gu
 * @version 2.0
 * @since April 11, 2018
 */

class ManageCourses extends JFrame implements ActionListener{

    ManageCourses(ObjectInputStream in, ObjectOutputStream out, Course course, User prof) {

        this.in = in;
        this.out = out;
        this.course = course;
        this.prof = prof;
        initComponents();
        manageAssignments.addActionListener(this);
        manageSubmissions.addActionListener(this);
        emailStudents.addActionListener(this);
        enrollStudents.addActionListener(this);
        backk.addActionListener(this);
        frame1.setSize(700, 700);
        frame1.setVisible(true);
     }

    /**
     * Intialises and creates the GUI.
     */
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Edward Gu
        frame1 = new JFrame();
        panel2 = new JPanel();
        backk = new JButton();
        panel3 = new JPanel();
        courseName = new JLabel();
        panel6 = new JPanel();
        panel4 = new JPanel();
        panel1 = new JPanel();
        manageAssignments = new JButton();
        manageSubmissions = new JButton();
        emailStudents = new JButton();
        enrollStudents = new JButton();
        panel5 = new JPanel();
        panel7 = new JPanel();
        panel8 = new JPanel();

        //======== frame1 ========
        {
            frame1.setTitle("Manage Course");
            frame1.setBackground(UIManager.getColor("TextPane.selectionBackground"));
            frame1.setForeground(UIManager.getColor("TextPane.selectionBackground"));
            frame1.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            frame1.setFont(new Font("Geneva", Font.PLAIN, 13));
            Container frame1ContentPane = frame1.getContentPane();
            frame1ContentPane.setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "0[236,fill]0" +
                "[198,fill]0" +
                "[260,fill]0",
                // rows
                "0[170]0" +
                "[208]0" +
                "[299]0"));

            //======== panel2 ========
            {
                panel2.setBackground(new Color(115, 194, 251));

                // JFormDesigner evaluation mark

                panel2.setLayout(new MigLayout(
                    "hidemode 3",
                    // columns
                    "15[fill]",
                    // rows
                    "[]" +
                    "[]"));

                //---- back ----
                backk.setText("Back");
                backk.setForeground(Color.darkGray);
                backk.setBackground(Color.white);
                backk.setFont(backk.getFont().deriveFont(backk.getFont().getSize() + 2f));
                panel2.add(backk, "cell 0 0,align leading top,grow 0 0");
            }
            frame1ContentPane.add(panel2, "cell 0 0,grow");

            //======== panel3 ========
            {
                panel3.setBackground(new Color(115, 194, 251));
                panel3.setLayout(new MigLayout(
                    "hidemode 3",
                    // columns
                    "0[306,fill]0",
                    // rows
                    "[67]" +
                    "[14]"));

                //---- courseName ----
                //courseName.setText("ENCM 511");
                courseName.setText(course.getCourseName());
                courseName.setHorizontalAlignment(SwingConstants.CENTER);
                courseName.setFont(new Font(".SF NS Text", Font.BOLD, 30));
                courseName.setBackground(new Color(51, 153, 255));
                courseName.setForeground(Color.black);
                panel3.add(courseName, "cell 0 0,alignx center,grow 0 100");
            }
            frame1ContentPane.add(panel3, "cell 1 0,grow");

            //======== panel6 ========
            {
                panel6.setBackground(new Color(115, 194, 251));
                panel6.setLayout(new MigLayout(
                    "hidemode 3",
                    // columns
                    "[fill]",
                    // rows
                    "[]"));
            }
            frame1ContentPane.add(panel6, "cell 2 0,grow");

            //======== panel4 ========
            {
                panel4.setBackground(new Color(115, 194, 251));
                panel4.setLayout(new MigLayout(
                    "hidemode 3",
                    // columns
                    "[fill]",
                    // rows
                    "[]"));
            }
            frame1ContentPane.add(panel4, "cell 0 1,grow");

            //======== panel1 ========
            {
                panel1.setBackground(new Color(115, 194, 251));
                panel1.setLayout(new MigLayout(
                    "hidemode 3",
                    // columns
                    "[0,fill]" +
                    "[0,fill]" +
                    "[175,fill]" +
                    "[7,fill]" +
                    "[fill]",
                    // rows
                    "0[90]0" +
                    "[90]" +
                    "[70]" +
                    "[79]20" +
                    "[33]" +
                    "[233]"));

                //---- manageAssignments ----
                manageAssignments.setText("Manage Assignments");
                manageAssignments.setFont(new Font(".SF NS Text", Font.PLAIN, 20));
                manageAssignments.setForeground(Color.darkGray);
                manageAssignments.setBackground(Color.white);
                panel1.add(manageAssignments, "cell 2 0");

                //---- manageSubmissions ----
                manageSubmissions.setText("Manage Submissions");
                manageSubmissions.setFont(new Font(".SF NS Text", Font.PLAIN, 20));
                manageSubmissions.setForeground(Color.darkGray);
                manageSubmissions.setBackground(Color.white);
                panel1.add(manageSubmissions, "cell 2 1");


                //---- emailStudents ----
                emailStudents.setText("Email Students");
                emailStudents.setFont(new Font(".SF NS Text", Font.PLAIN, 20));
                emailStudents.setForeground(Color.darkGray);
                emailStudents.setBackground(Color.white);
                panel1.add(emailStudents, "cell 2 2");

                //---- enrollStudents ----
                enrollStudents.setText("Enroll Students");
                enrollStudents.setFont(new Font(".SF NS Text", Font.PLAIN, 20));
                enrollStudents.setIcon(null);
                enrollStudents.setForeground(Color.darkGray);
                enrollStudents.setBackground(Color.white);
                panel1.add(enrollStudents, "cell 2 3");
            }
            frame1ContentPane.add(panel1, "cell 1 1 1 2");

            //======== panel5 ========
            {
                panel5.setBackground(new Color(115, 194, 251));
                panel5.setLayout(new MigLayout(
                    "hidemode 3",
                    // columns
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]",
                    // rows
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]"));
            }
            frame1ContentPane.add(panel5, "cell 2 1,grow");

            //======== panel7 ========
            {
                panel7.setBackground(new Color(115, 194, 251));
                panel7.setLayout(new MigLayout(
                    "hidemode 3",
                    // columns
                    "[fill]",
                    // rows
                    "[]"));
            }
            frame1ContentPane.add(panel7, "cell 0 2,grow");

            //======== panel8 ========
            {
                panel8.setBackground(new Color(115, 194, 251));
                panel8.setLayout(new MigLayout(
                    "hidemode 3",
                    // columns
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[157,fill]",
                    // rows
                    "[]" +
                    "[346]"));
            }
            frame1ContentPane.add(panel8, "cell 2 2,grow");
            frame1.pack();
            frame1.setLocationRelativeTo(frame1.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Edward Gu
    private JFrame frame1;
    private JPanel panel2;
    private JButton backk;
    private JPanel panel3;
    private JLabel courseName;
    private JPanel panel6;
    private JPanel panel4;
    private JPanel panel1;
    private JButton manageAssignments;
    private JButton manageSubmissions;
    private JButton emailStudents;
    private JButton enrollStudents;
    private JPanel panel5;
    private JPanel panel7;
    private JPanel panel8;
    private Course course;

    private ObjectInputStream in;
    private ObjectOutputStream out;
    private ManageAssignment assignManager;
    private ManageSubmissions subManager;
    private EmailStudents emailManager;
    private EnrollStudents enrollManager;
    private User prof;
    /**
     * The frame is the main frame of the GUI.
     * The panel, scrollpane and label fields help with the formatting of the GUI.
     * Each JButton is named the window that is opened when they are pressed.
     * in and out are ObjectStreams used to help send data to the server from the client.
     * Course stores the current course of the GUI.
     * assignManager is a ManageAssignment object to help modify/create/delete data regarding assignments in and after this GUI.
     * subManager is a ManageSubmissions object to help modify/create/delete data regarding submissions in and after this GUI.
     * gradeManager is a ManageGrades object to help modify/create/delete data regarding grades in and after this GUI.
     * emailManager is a EmailStudents object to help send emails enrolled in the course.
     * enrollManager is a EnrollStudent object to help modify/create/delete data regarding enrollment in and after this GUI.
     */

    /**
     * Generates the correct response/actions depending on what buttons the professor clicks.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == backk) {
            System.out.println("here");
            frame1.dispose();
        }
        else if(e.getSource() == manageAssignments) {
            assignManager = new ManageAssignment(in, out, course);
        }
        else if(e.getSource() == manageSubmissions) {
            subManager = new ManageSubmissions(in, out, course);
        }
        else if(e.getSource() == emailStudents) {
            emailManager = new EmailStudents(in, out, course, prof);
        }
        else if(e.getSource() == enrollStudents) {
            enrollManager = new EnrollStudents(in, out, course);
        }
    }
}
