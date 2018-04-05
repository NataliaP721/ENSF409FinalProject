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

class ManageCourses extends JFrame implements ActionListener{

    ManageCourses(ObjectInputStream in, ObjectOutputStream out) {

        this.in = in;
        this.out = out;
        initComponents();
        manageAssignments.addActionListener(this);
        manageSubmissions.addActionListener(this);
        emailStudents.addActionListener(this);
        enrollStudents.addActionListener(this);
        back.addActionListener(this);
        manageGrades.addActionListener(this);

        assignManager = new ManageAssignment(in, out);
        assignManager.setVisible(false);
        subManager = new ManageSubmissions(in, out);
        subManager.setVisible(false);
        gradeManager = new ManageGrades(in, out);
        gradeManager.setVisible(false);
        emailManager = new EmailStudents(in, out);
        emailManager.setVisible(false);
        enrollManager = new EnrollStudents(in, out);
        enrollStudents.setVisible(false);

        frame1.setSize(700, 700);
        frame1.setVisible(true);
     }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Edward Gu
        frame1 = new JFrame();
        panel2 = new JPanel();
        back = new JButton();
        panel3 = new JPanel();
        courseName = new JLabel();
        panel6 = new JPanel();
        panel4 = new JPanel();
        panel1 = new JPanel();
        manageAssignments = new JButton();
        manageSubmissions = new JButton();
        manageGrades = new JButton();
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
                back.setBackground(Color.black);
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
                courseName.setText("ENCM 511");
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
                manageAssignments.setBackground(Color.black);
                panel1.add(manageAssignments, "cell 2 0");

                //---- manageSubmissions ----
                manageSubmissions.setText("Manage Submissions");
                manageSubmissions.setFont(new Font(".SF NS Text", Font.PLAIN, 20));
                manageSubmissions.setForeground(Color.darkGray);
                manageSubmissions.setBackground(Color.black);
                panel1.add(manageSubmissions, "cell 2 1");

                //---- manageGrades ----
                manageGrades.setText("Manage Grades");
                manageGrades.setFont(new Font(".SF NS Text", Font.PLAIN, 20));
                manageGrades.setForeground(Color.darkGray);
                manageGrades.setBackground(Color.black);
                panel1.add(manageGrades, "cell 2 2");

                //---- emailStudents ----
                emailStudents.setText("Email Students");
                emailStudents.setFont(new Font(".SF NS Text", Font.PLAIN, 20));
                emailStudents.setForeground(Color.darkGray);
                emailStudents.setBackground(Color.black);
                panel1.add(emailStudents, "cell 2 3");

                //---- enrollStudents ----
                enrollStudents.setText("Enroll Students");
                enrollStudents.setFont(new Font(".SF NS Text", Font.PLAIN, 20));
                enrollStudents.setIcon(null);
                enrollStudents.setPreferredSize(new Dimension(120, 100));
                enrollStudents.setForeground(Color.darkGray);
                enrollStudents.setBackground(Color.black);
                panel1.add(enrollStudents, "cell 2 4,aligny center,growy 0");
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
    private JButton back;
    private JPanel panel3;
    private JLabel courseName;
    private JPanel panel6;
    private JPanel panel4;
    private JPanel panel1;
    private JButton manageAssignments;
    private JButton manageSubmissions;
    private JButton manageGrades;
    private JButton emailStudents;
    private JButton enrollStudents;
    private JPanel panel5;
    private JPanel panel7;
    private JPanel panel8;
    private Course course;

    private ObjectInputStream in;
    private ObjectOutputStream out;
    private boolean visible;
    private ManageAssignment assignManager;
    private ManageSubmissions subManager;
    private ManageGrades gradeManager;
    private EmailStudents emailManager;
    private EnrollStudents enrollManager;

    void setCourse(Course x) {
        courseName.setText(course.getCourseName());
        this.course = x;
        visible = true;
    }

    boolean getVisible() {
        return visible;
    }

//    public static void main(String [] args){
//        ManageCourses obj= new ManageCourses();
//    }

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == back) {
                this.setVisible(false);
                visible = false;
            }
            else if(e.getSource() == manageAssignments) {
                assignManager.setCourse(course);
                assignManager.setVisible(true);
                this.setVisible(false);
                while(!assignManager.getVisible()){}
                this.setVisible(true);
            }
            else if(e.getSource() == manageSubmissions) {
                subManager.setCourse(course);
                subManager.setVisible(true);
                this.setVisible(false);
                while(!subManager.getVisible()){}
                this.setVisible(true);
            }
            else if(e.getSource() == manageGrades) {
                gradeManager.setCourse(course);
                gradeManager.setVisible(true);
                this.setVisible(false);
                while(!gradeManager.getVisible()){}
                this.setVisible(true);
            }
            else if(e.getSource() == emailStudents) {
                emailManager.setCourse(course);
                emailManager.setVisible(true);
                this.setVisible(false);
                while(!emailManager.getVisible()){}
                this.setVisible(true);
            }
            else if(e.getSource() == enrollStudents) {
                enrollManager.setCourse(course);
                enrollManager.setVisible(true);
                this.setVisible(false);
                while(!enrollManager.getVisible()){}
                this.setVisible(true);
            }
        }
    }