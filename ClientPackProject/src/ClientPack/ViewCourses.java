/*
 * Created by JFormDesigner on Sat Apr 07 21:02:33 MDT 2018
 */

package ClientPack;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.*;
import net.miginfocom.swing.*;
import SharedDataObjects.*;
/**
 * Creates the course homepage with the ability to navigate to other windows: Send Emails, View Grades, Submit Assignment, View Assignments, or go back to the homepage.
 * @author Aysha Panatch
 */
public class ViewCourses extends JFrame implements ActionListener{
    ViewCourses(ObjectInputStream in, ObjectOutputStream out, Course course, User student) {
        this.in = in;
        this.out = out;
        this.course = course;
        this.student = student;
        initComponents();
        viewAssignments.addActionListener(this);
        submitAssignments.addActionListener(this);
        emailProfessor.addActionListener(this);
        back.addActionListener(this);
        frame1.setSize(700, 700);
        frame1.setVisible(true);
    }
    /**
     * Intialises and creates the GUI.
     */
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Aysha Panatch
        frame1 = new JFrame();
        panel2 = new JPanel();
        back = new JButton();
        panel3 = new JPanel();
        courseName = new JLabel();
        panel6 = new JPanel();
        panel4 = new JPanel();
        panel1 = new JPanel();
        viewAssignments = new JButton();
        submitAssignments = new JButton();
        emailProfessor = new JButton();
        panel5 = new JPanel();
        panel7 = new JPanel();
        panel8 = new JPanel();

        //======== frame1 ========
        {
            frame1.setTitle("View Course");
            frame1.setBackground(UIManager.getColor("TextPane.selectionBackground"));
            frame1.setForeground(UIManager.getColor("TextPane.selectionBackground"));
            frame1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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
                panel2.setBorder(new javax.swing.border.CompoundBorder(
                    new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                        "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                        javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                        java.awt.Color.red), panel2.getBorder())); panel2.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

                panel2.setLayout(new MigLayout(
                    "hidemode 3",
                    // columns
                    "15[fill]",
                    // rows
                    "[]" +
                    "[]"));

                //---- back ----
                back.setText("Back");
                back.setForeground(Color.darkGray);
                back.setBackground(Color.white);
                back.setFont(back.getFont().deriveFont(back.getFont().getSize() + 2f));
                panel2.add(back, "cell 0 0,align leading top,grow 0 0");
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
                courseName.setHorizontalAlignment(SwingConstants.CENTER);
                courseName.setFont(new Font(".SF NS Text", Font.BOLD, 30));
                courseName.setBackground(new Color(51, 153, 255));
                courseName.setForeground(Color.black);
                courseName.setText("ENCM511");
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

                //---- viewAssignments ----
                viewAssignments.setText("View Assignments");
                viewAssignments.setFont(new Font(".SF NS Text", Font.PLAIN, 20));
                viewAssignments.setForeground(Color.darkGray);
                viewAssignments.setBackground(Color.white);
                panel1.add(viewAssignments, "cell 2 0");

                //---- submitAssignments ----
                submitAssignments.setText("Submit Assignments");
                submitAssignments.setFont(new Font(".SF NS Text", Font.PLAIN, 20));
                submitAssignments.setForeground(Color.darkGray);
                submitAssignments.setBackground(Color.white);
                panel1.add(submitAssignments, "cell 2 1");

                //---- emailProfessor ----
                emailProfessor.setText("Email Professor");
                emailProfessor.setFont(new Font(".SF NS Text", Font.PLAIN, 20));
                emailProfessor.setForeground(Color.darkGray);
                emailProfessor.setBackground(Color.white);
                panel1.add(emailProfessor, "cell 2 2");
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
    // Generated using JFormDesigner Evaluation license - Aysha Panatch
    private JFrame frame1;
    private JPanel panel2;
    private JButton back;
    private JPanel panel3;
    private JLabel courseName;
    private JPanel panel6;
    private JPanel panel4;
    private JPanel panel1;
    private JButton viewAssignments;
    private JButton submitAssignments;
    private JButton emailProfessor;
    private JPanel panel5;
    private JPanel panel7;
    private JPanel panel8;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private Course course;
    private ObjectInputStream in;
    private ObjectOutputStream out;
    private ViewAssignment assignManager;
    private SubmitAssignments subManager;
    private EmailProfessor emailManager;
    private User student;
    /**
     * The frame is the main frame of the GUI.
     * The panel, scrollpane and label fields help with the formatting of the GUI.
     * Each JButton is named the window that is opened when they are pressed.
     * in and out are ObjectStreams used to help send data to the server from the client.
     * Course stores the current course of the GUI.
     * assignManager is a ViewGrades object to help view data regarding assignments in and after this GUI.
     * subManager is a SubmitSubmissions object to help submit submissions in and after this GUI.
     * gradeManager is a ManageGrades object to help modify/create/delete data regarding courses in and after this GUI.
     * emailManager is a EmailProfessor object to help send professors emails in and after this GUI.
     */

    /**
     * Generates the correct response/actions depending on what buttons the professor clicks.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == back) {
            this.dispose();
        }
        else if(e.getSource() == viewAssignments) {
            assignManager = new ViewAssignment(in, out, course, student);
        }
        else if(e.getSource() == submitAssignments) {
            subManager = new SubmitAssignments(in, out, course, student);
        }
        else if(e.getSource() == emailProfessor) {
            emailManager = new EmailProfessor(in, out, course, student);
        }
    }
}
