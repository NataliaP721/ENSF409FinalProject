/*
 * Created by JFormDesigner on Sat Apr 07 21:11:52 MDT 2018
 */

package ClientPack;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

import net.miginfocom.swing.*;
import SharedDataObjects.*;

/**
 * Creates a page listing all assignments with options to view the assignment or view recorded grades for each assignment
 */
public class ViewAssignment extends JFrame implements ActionListener, ListSelectionListener {
    ViewAssignment(ObjectInputStream in, ObjectOutputStream out, Course course, User student) {
        this.in = in;
        this.out = out;
        this.course = course;
        this.student = student;
        initComponents();
        viewAssignment.addActionListener(this);
        back.addActionListener(this);
        courseName.setText(course.getCourseName());
        viewAssignment.setEnabled(false);
        assignmentList.addListSelectionListener(this);
        this.setSize(700, 700);
        this.setVisible(true);

        try {
            //REPLACE WITH THE DESIRED COMMAND
            course.setCommand("GETACTIVE");
            out.writeObject(course);
            out.reset();
            System.out.println(course.getCourseName());
            assignmentList.setListData((Assignment[]) (in.readObject()));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException f) {
            f.printStackTrace();
        }
    }

    /**
     * Intialises and creates the GUI.
     */
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Aysha Panatch
        panel2 = new JPanel();
        back = new JButton();
        courseName = new JLabel();
        panel1 = new JPanel();
        viewAssignment = new JButton();
        label2 = new JLabel();
        scrollPane1 = new JScrollPane();
        assignmentList = new JList<>();

        //======== this ========
        setTitle("View Assignments");
        Container contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "0[700,grow,fill]0",
            // rows
            "0[642,grow,fill]0"));

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
                "0[700,grow,fill]0",
                // rows
                "0[25]0" +
                "[]" +
                "[]" +
                "[]" +
                "[450]0"));

            //---- back ----
            back.setText("Back");
            back.setBackground(Color.white);
            back.setForeground(Color.black);
            panel2.add(back, "cell 0 0,alignx left,growx 0");

            //---- courseName ----
            courseName.setText("Course Name");
            courseName.setFont(new Font(".SF NS Text", Font.BOLD, 22));
            courseName.setForeground(Color.black);
            courseName.setBackground(new Color(115, 194, 251));
            panel2.add(courseName, "cell 0 0,alignx right,growx 0");

            //======== panel1 ========
            {
                panel1.setBackground(new Color(115, 194, 251));
                panel1.setLayout(new MigLayout(
                    "hidemode 3",
                    // columns
                    "[180,fill]",
                    // rows
                    "[]" +
                    "[]"));

                //---- viewAssignment ----
                viewAssignment.setText("Download Assignment");
                viewAssignment.setBackground(Color.white);
                viewAssignment.setForeground(Color.black);
                panel1.add(viewAssignment, "cell 0 1");
            }
            panel2.add(panel1, "cell 0 1 1 2,alignx center,growx 0");

            //---- label2 ----
            label2.setText("Assignments");
            label2.setFont(new Font(".SF NS Text", Font.BOLD, 15));
            label2.setBackground(new Color(115, 194, 251));
            label2.setForeground(Color.black);
            panel2.add(label2, "cell 0 3,alignx center,growx 0");

            //======== scrollPane1 ========
            {

                //---- assignmentList ----
                assignmentList.setBackground(Color.white);
                assignmentList.setForeground(Color.black);
                scrollPane1.setViewportView(assignmentList);
            }
            panel2.add(scrollPane1, "cell 0 4,grow");
        }
        contentPane.add(panel2, "cell 0 0");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Aysha Panatch
    private JPanel panel2;
    private JButton back;
    private JLabel courseName;
    private JPanel panel1;
    private JButton viewAssignment;
    private JLabel label2;
    private JScrollPane scrollPane1;
    private JList<Assignment> assignmentList;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private Course course;
    private ObjectInputStream in;
    private ObjectOutputStream out;
    private User student;
    private Grade grade;
    /**
     * The frame is the main frame of the GUI.
     * The panel, scrollpanes, and label fields help with the formatting of the GUI.
     * courseList is the JList that displays all the assignments in the course.
     * Each JButton is named the action that executed when they are pressed.
     * course stores the course in the GUI.
     * in and out are ObjectStreams used to help send data to the server from the client.
     */

    /**
     * Generates the correct response/actions depending on what buttons the professor clicks.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            this.dispose();
        }
        else if (e.getSource() == viewAssignment) {
            Assignment current = assignmentList.getSelectedValue();
            current.setCommand("GETFILE");
            System.out.println("GETASSIGNFILE");
            try {
                out.writeObject(current);
                out.reset();
                Upload content = (Upload) in.readObject();
                File newFile = new File("/home/natalia/Client/" + content.getFileName() + "."+content.getFileExtension());
                if (!newFile.exists())
                    newFile.createNewFile();
                FileOutputStream writer = new FileOutputStream(newFile);
                BufferedOutputStream bos = new BufferedOutputStream(writer);
                bos.write(content.getContent());
                bos.close();
            } catch (ClassNotFoundException f) {
                f.printStackTrace();
            } catch (IOException g) {
                g.printStackTrace();
            }
        }

    }

    public void valueChanged(ListSelectionEvent e){
        viewAssignment.setEnabled(true);
    }
}
