package ClientPack;

import SharedDataObjects.*;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
/*
 * Created by JFormDesigner on Sun Apr 01 12:19:26 MDT 2018
 */


/**
 * Creates the student enrollment page with the ability to search all students, enroll/unenroll students, and view class list.
 * @author Aysha Panatch, Natalia Pavlovic, Eddy Gu
 * @version 2.0
 * @since April 11, 2018
 */

public class EnrollStudents extends JFrame implements ActionListener, ListSelectionListener{
    EnrollStudents(ObjectInputStream in, ObjectOutputStream out, Course course) {
        this.in = in;
        this.out = out;
        this.course = course;
        initComponents();
        ButtonGroup group= new ButtonGroup();
        group.add(lastNameradioButton);
        group.add(IDradioButton);
        search.addActionListener(this);
        back.addActionListener(this);
        enrollunenrollStudent.addActionListener(this);
        displayClassList.addActionListener(this);
        displayAll.addActionListener(this);
        enrollunenrollStudent.setEnabled(false);
        enrollList.addListSelectionListener(this);
        this.setSize(700, 700);
        this.setVisible(true);
        try {
            course.setCommand("GETSTUDENTS");
            out.writeObject(course);
            out.reset();
            System.out.println(course.getCourseName());
            enrollList.setListData((StudentEnrollment[]) (in.readObject()));
        }
        catch (ClassNotFoundException e) {
            System.err.println("Object Error");
        }
        catch(IOException e) {
            System.err.println("IO Error");
        }
    }

    private void displayClassListActionPerformed(ActionEvent e) {
        // TODO add your code here
    }
    /**
     * Intialises and creates the GUI.
     */
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Aysha Panatch
        panel1 = new JPanel();
        panel4 = new JPanel();
        panel2 = new JPanel();
        back = new JButton();
        label1 = new JLabel();
        label10 = new JLabel();
        IDradioButton = new JRadioButton();
        lastNameradioButton = new JRadioButton();
        label11 = new JLabel();
        searchparameter = new JTextField();
        search = new JButton();
        scrollPane5 = new JScrollPane();
        enrollList = new JList<>();
        displayAll = new JButton();
        displayClassList = new JButton();
        enrollunenrollStudent = new JButton();

        //======== this ========
        setTitle("Enroll Students");
        setBackground(new Color(115, 194, 251));
        Container contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "0[700]0",
            // rows
            "0[]0"));

        //======== panel1 ========
        {
            panel1.setBackground(new Color(115, 194, 251));

            // JFormDesigner evaluation mark
            panel1.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                    "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                    javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                    java.awt.Color.red), panel1.getBorder())); panel1.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

            panel1.setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "0[700,fill]0",
                // rows
                "0[700,grow,fill]0"));

            //======== panel4 ========
            {
                panel4.setBackground(new Color(115, 194, 251));
                panel4.setFont(panel4.getFont().deriveFont(panel4.getFont().getSize() + 1f));
                panel4.setLayout(new MigLayout(
                    "hidemode 3",
                    // columns
                    "[fill]10" +
                    "[700,grow,fill]10",
                    // rows
                    "0[0]0" +
                    "[]0" +
                    "[35]" +
                    "[27]" +
                    "[]" +
                    "[]" +
                    "[473]" +
                    "[]0" +
                    "[]"));

                //======== panel2 ========
                {
                    panel2.setBackground(new Color(115, 194, 251));
                    panel2.setLayout(new MigLayout(
                        "hidemode 3",
                        // columns
                        "0[51,fill]",
                        // rows
                        "0[]0"));

                    //---- back ----
                    back.setText("Back");
                    back.setBackground(Color.white);
                    back.setForeground(Color.black);
                    panel2.add(back, "cell 0 0");
                }
                panel4.add(panel2, "cell 1 1,alignx left,growx 0");

                //---- label1 ----
                label1.setText("Enroll Students");
                label1.setFont(new Font(".SF NS Text", Font.BOLD, 26));
                label1.setForeground(Color.black);
                label1.setHorizontalAlignment(SwingConstants.RIGHT);
                panel4.add(label1, "cell 1 1");

                //---- label10 ----
                label10.setText("  Search Students By:");
                label10.setFont(new Font(".SF NS Text", Font.PLAIN, 16));
                label10.setForeground(Color.black);
                label10.setBackground(new Color(115, 194, 251));
                panel4.add(label10, "cell 1 2");

                //---- IDradioButton ----
                IDradioButton.setText("ID");
                IDradioButton.setFont(new Font(".SF NS Text", Font.PLAIN, 15));
                IDradioButton.setBackground(new Color(115, 194, 251));
                IDradioButton.setForeground(Color.black);
                panel4.add(IDradioButton, "cell 1 3");

                //---- lastNameradioButton ----
                lastNameradioButton.setText("Last Name");
                lastNameradioButton.setFont(new Font(".SF NS Text", Font.PLAIN, 15));
                lastNameradioButton.setBackground(new Color(115, 194, 251));
                lastNameradioButton.setForeground(Color.black);
                panel4.add(lastNameradioButton, "cell 1 3");

                //---- label11 ----
                label11.setText("  Enter Search Parameter:");
                label11.setFont(new Font(".SF NS Text", Font.PLAIN, 16));
                label11.setForeground(Color.black);
                panel4.add(label11, "cell 1 4");

                //---- searchparameter ----
                searchparameter.setBackground(Color.white);
                panel4.add(searchparameter, "cell 1 5");

                //---- search ----
                search.setText("Search");
                search.setFont(new Font(".SF NS Text", Font.PLAIN, 15));
                search.setBackground(Color.white);
                search.setForeground(Color.black);
                panel4.add(search, "cell 1 5,alignx right,growx 0");

                //======== scrollPane5 ========
                {

                    //---- enrollList ----
                    enrollList.setBackground(Color.white);
                    enrollList.setForeground(Color.black);
                    scrollPane5.setViewportView(enrollList);
                }
                panel4.add(scrollPane5, "cell 1 6,grow");

                //---- displayAll ----
                displayAll.setText("Display All");
                displayAll.setBackground(Color.white);
                displayAll.setForeground(Color.black);
                displayAll.setFont(new Font(".SF NS Text", Font.PLAIN, 15));
                displayAll.addActionListener(e -> displayClassListActionPerformed(e));
                panel4.add(displayAll, "cell 1 7");

                //---- displayClassList ----
                displayClassList.setText("Display Class List");
                displayClassList.setBackground(Color.white);
                displayClassList.setForeground(Color.black);
                displayClassList.setFont(new Font(".SF NS Text", Font.PLAIN, 15));
                displayClassList.addActionListener(e -> displayClassListActionPerformed(e));
                panel4.add(displayClassList, "cell 1 7");

                //---- enrollunenrollStudent ----
                enrollunenrollStudent.setText("Enroll/Unenroll Student");
                enrollunenrollStudent.setFont(new Font(".SF NS Text", Font.PLAIN, 15));
                enrollunenrollStudent.setBackground(Color.white);
                enrollunenrollStudent.setForeground(Color.black);
                panel4.add(enrollunenrollStudent, "cell 1 7");
            }
            panel1.add(panel4, "cell 0 0,grow");
        }
        contentPane.add(panel1, "cell 0 0,grow");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Aysha Panatch
    private JPanel panel1;
    private JPanel panel4;
    private JPanel panel2;
    private JButton back;
    private JLabel label1;
    private JLabel label10;
    private JRadioButton IDradioButton;
    private JRadioButton lastNameradioButton;
    private JLabel label11;
    private JTextField searchparameter;
    private JButton search;
    private JScrollPane scrollPane5;
    private JList<StudentEnrollment> enrollList;
    private JButton displayAll;
    private JButton displayClassList;
    private JButton enrollunenrollStudent;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private ObjectInputStream in;
    private ObjectOutputStream out;
    private Course course;
    /**
     * The panel, scrollpanes, and labels fields help with the formatting of the GUI.
     * enrollList is the JList that displays searched students or students in the course.
     * Each JRadioButton is named the search criteria to find students.
     * Each JButton is named the action that is executed when they are pressed.
     * Course stores the current course of the GUI.
     * in and out are ObjectStreams used to help send data to the server from the client.
     */

    /**
     * Generates the correct response/actions depending on what buttons the professor clicks.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == back) {
            this.dispose();
        }
        else if(e.getSource() == search) {
            String param = searchparameter.getText();
            if(IDradioButton.isSelected()){
                StudentEnrollment current = new StudentEnrollment();
                current.setStudentID(Integer.parseInt(param));
                current.setCourseID(course.getCourseID());
                current.setCommand("SEARCHBYID");
                try {
                    out.writeObject(current);
                    out.reset();
                    enrollList.setListData((StudentEnrollment[]) (in.readObject()));
                }
                catch(ClassNotFoundException f) {
                    System.err.println("Object Error");
                }
                catch(IOException f) {
                    System.err.println("IO Error");
                }
            }
            else if (lastNameradioButton.isSelected()) {
                User current = new User();
                current.setLastName(param);
                current.setCommand("SEARCHENROLLEDBYLASTNAME");
                try {
                    out.writeObject(current);
                    out.reset();
                    enrollList.setListData((StudentEnrollment[])in.readObject());
                }
                catch(ClassNotFoundException f) {
                    System.err.println("Object Error");
                }
                catch(IOException f) {
                    System.err.println("IO Error");
                }
            }

        }
        else if(e.getSource() == displayClassList) {
            searchparameter.setText("");
            course.setCommand("DISPLAYCLASSLIST");
            try {
                out.writeObject(course);
                out.reset();
                enrollList.setListData((StudentEnrollment[]) in.readObject());
            }
            catch(ClassNotFoundException f) {
                System.err.println("Object Error");
            }
            catch(IOException f) {
                System.err.println("IO Error");
            }
        }
        else if(e.getSource() == enrollunenrollStudent) {
            StudentEnrollment current = enrollList.getSelectedValue();
            if(current.getEnrolling() == '1') {
                current.setEnrolling(false);
            }
            else if(current.getEnrolling() == '0') {
                current.setEnrolling(true);
            }

            current.setCommand("MOD");

            try {
                out.writeObject(current);
                out.reset();
                enrollList.setListData((StudentEnrollment[])in.readObject());
            }
            catch(ClassNotFoundException f) {
                System.err.println("Object Error");
            }
            catch(IOException f) {
                System.err.println("IO Error");
            }
        }
        else if(e.getSource() == displayAll) {
            try {
                course.setCommand("GETSTUDENTS");
                out.writeObject(course);
                out.reset();
                System.out.println(course.getCourseName());
                enrollList.setListData((StudentEnrollment[]) (in.readObject()));
            }
            catch (ClassNotFoundException d) {
                System.err.println("Object Error");
            }
            catch(IOException d) {
                System.err.println("IO Error");
            }
        }
    }

    /**
     * Enables certain buttons when the list is clicked.
     */
    public void valueChanged(ListSelectionEvent e){
        enrollunenrollStudent.setEnabled(true);
    }
}

