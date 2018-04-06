package ClientPack;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;


import net.miginfocom.swing.*;

import SharedDataObjects.*;
/*
 * Created by JFormDesigner on Sun Apr 01 10:57:59 MDT 2018
 */



/**
 * @author Aysha Panatch
 */
public class ManageAssignment extends JFrame implements ActionListener{
    ManageAssignment(ObjectInputStream in, ObjectOutputStream out, Course course) {
        this.in = in;
        this.out = out;
        this.course = course;
        initComponents();
        addAssignment.addActionListener(this);
        deleteAssignment.addActionListener(this);
        activatedeactivate.addActionListener(this);
        back.addActionListener(this);
        this.setSize(700,700);
        this.setVisible(true);

        try {
            course.setCommand("GETASSIGNMENTS");
            out.writeObject(course);
            out.reset();
            System.out.println(course.getCourseName());
            assignmentList.setListData((Assignment[]) (in.readObject()));
        }
        catch (ClassNotFoundException e) {
            System.err.println("Class not found");
        }
        catch(IOException e) {
            System.err.println("IO Error");
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Edward Gu
        panel2 = new JPanel();
        back = new JButton();
        courseName = new JLabel();
        panel1 = new JPanel();
        addAssignment = new JButton();
        deleteAssignment = new JButton();
        activatedeactivate = new JButton();
        label2 = new JLabel();
        scrollPane1 = new JScrollPane();
        assignmentList = new JList<>();

        //======== this ========
        setTitle("Manage Assignments");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
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
            back.setBackground(Color.black);
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
                    "[180,fill]" +
                    "[180,fill]" +
                    "[175,fill]",
                    // rows
                    "[]" +
                    "[]"));

                //---- addAssignment ----
                addAssignment.setText("Add New Assignment");
                addAssignment.setBackground(Color.black);
                addAssignment.setForeground(Color.black);
                panel1.add(addAssignment, "cell 0 1");

                //---- deleteAssignment ----
                deleteAssignment.setText("Delete Assignment");
                deleteAssignment.setBackground(Color.black);
                deleteAssignment.setForeground(Color.black);
                panel1.add(deleteAssignment, "cell 1 1");

                //---- activatedeactivate ----
                activatedeactivate.setText("Activate/Deactivate");
                activatedeactivate.setBackground(Color.black);
                activatedeactivate.setForeground(Color.black);
                panel1.add(activatedeactivate, "cell 2 1");
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
    // Generated using JFormDesigner Evaluation license - Edward Gu
    private JPanel panel2;
    private JButton back;
    private JLabel courseName;
    private JPanel panel1;
    private JButton addAssignment;
    private JButton deleteAssignment;
    private JButton activatedeactivate;
    private JLabel label2;
    private JScrollPane scrollPane1;
    private JList<Assignment> assignmentList;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    private Course course;
    private ObjectInputStream in;
    private ObjectOutputStream out;

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == back) {
            this.dispose();
        }
        else if(e.getSource() == addAssignment) {

            Upload upload = addFile();
            this.addAssign(upload);

            try {
                assignmentList.setListData((Assignment[])(in.readObject()));
            }
            catch(ClassNotFoundException c) {
                System.err.println("Object error");
            }
            catch(IOException d) {
                System.err.println("IO Error");
            }
        }
        else if(e.getSource() == deleteAssignment) {
            Assignment current = assignmentList.getSelectedValue();
            current.setCommand("DELETE");
            try {
                out.writeObject(current);
                out.reset();
                assignmentList.setListData((Assignment[])(in.readObject()));
            }
            catch(ClassNotFoundException c) {
                System.err.println("Object error");
            }
            catch(IOException d) {
                System.err.println("IO Error");
            }
        }
        else if(e.getSource() == activatedeactivate) {
            Assignment current = assignmentList.getSelectedValue();
            if(current.getActive() == '1') {
                current.setActive(false);
            }
            else if(current.getActive() == '0') {
                current.setActive(true);
            }
            current.setCommand("MOD");
            try {
                out.writeObject(current);
                out.reset();
                assignmentList.setListData((Assignment[])(in.readObject()));
            }
            catch(ClassNotFoundException c) {
                System.err.println("Object error");
            }
            catch(IOException d) {
                System.err.println("IO Error");
            }
        }
    }


    private Upload addFile() {
        JFileChooser fileBrowser = new JFileChooser();
        File selectedFile = null;
        if(fileBrowser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            selectedFile = fileBrowser.getSelectedFile();
        }
        assert selectedFile != null;
        long length = selectedFile.length();

        byte[] content = new byte[(int) length];
        try {
            BufferedInputStream reader = new BufferedInputStream(new FileInputStream(selectedFile));
            reader.read(content, 0, (int)length);
        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        catch(IOException f) {
            System.err.println("Error");
        }

        return new Upload(content, selectedFile.getName());
    }

    private void addAssign(Upload upload) {

        upload.setCommand("ADD");
        String path = null;
        try {
            out.writeObject(upload);
            out.flush();
            path = (String)in.readObject();
        }
        catch(ClassNotFoundException e) {
            System.err.println("Object Error");
        }
        catch(IOException e) {
            e.printStackTrace();
        }


        JTextField assignTitle = new JTextField(20);
        JTextField assignID = new JTextField(6);
        JTextField assignDueDate = new JTextField(8);

        //put all the things into the panel

        JPanel addAssignPanel = new JPanel();
        addAssignPanel.add(new JLabel("Enter the assignment title: "));
        addAssignPanel.add(assignTitle);
        addAssignPanel.add(new JLabel("Enter the assignment ID: "));
        addAssignPanel.add(assignID);
        addAssignPanel.add(new JLabel("Enter the assignment due date (DDMMYYYY): "));
        addAssignPanel.add(assignDueDate);

        int result = JOptionPane.showConfirmDialog(null, addAssignPanel,
                "Please Enter Assignment Information", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            Assignment newAssign = new Assignment(Integer.parseInt(assignID.getText()), course.getCourseID(), assignTitle.getText(), path, true, assignDueDate.getText());
            newAssign.setCommand("ADD");
            try {
                out.writeObject(newAssign);
                out.reset();
            }
            catch(IOException d) {
                System.err.println("IO Error");
            }
        }

    }
}

