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
/*
 * Created by JFormDesigner on Sun Apr 01 10:57:59 MDT 2018
 */



/**
 *  * Creates the manage assignments page with the ability to add, delete, activate/deactivate and view all assignments.
 * @author Aysha Panatch, Natalia Pavlovic, Eddy Gu
 * @version 2.0
 * @since April 11, 2018
 */

public class ManageAssignment extends JFrame implements ActionListener, ListSelectionListener{
    /**
     * Constructs a ManageAssignment object with the specified values for in, out and course.
     * The values for the fields are supplied by the given parameters.
     * @param in the ObjectInputStream used to read objects from the socket
     * @param out the ObjectOutputStream used to write objects to the socket
     * @param course the Course whose Assignments are being managed
     */
    ManageAssignment(ObjectInputStream in, ObjectOutputStream out, Course course) {
        this.in = in;
        this.out = out;
        this.course = course;
        initComponents();
        addAssignment.addActionListener(this);
        deleteAssignment.addActionListener(this);
        activatedeactivate.addActionListener(this);
        activatedeactivate.setEnabled(false);
        deleteAssignment.setEnabled(false);
        assignmentList.addListSelectionListener(this);
        back.addActionListener(this);
        this.setSize(700,700);
        this.setVisible(true);

        try {
            course.setCommand("GETASSIGNMENTS");
            out.writeObject(course);
            out.reset();
            courseName.setText(course.getCourseName());
            Assignment[] received = (Assignment[])(in.readObject());
            if(received!=null) {
                assignmentList.setListData(received);
            }
        }
        catch (ClassNotFoundException e) {
            System.err.println("Class not found");
        }
        catch(IOException e) {
            System.err.println("IO Error");
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
        addAssignment = new JButton();
        deleteAssignment = new JButton();
        activatedeactivate = new JButton();
        label2 = new JLabel();
        scrollPane1 = new JScrollPane();
        assignmentList = new JList<>();

        //======== this ========
        setTitle("Manage Assignments");
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

            panel2.setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "10[700,grow,fill]10",
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
                    "[180,fill]" +
                    "[180,fill]" +
                    "[175,fill]",
                    // rows
                    "[]" +
                    "[]"));

                //---- addAssignment ----
                addAssignment.setText("Add New Assignment");
                addAssignment.setBackground(Color.white);
                addAssignment.setForeground(Color.black);
                panel1.add(addAssignment, "cell 0 1");

                //---- deleteAssignment ----
                deleteAssignment.setText("Delete Assignment");
                deleteAssignment.setBackground(Color.white);
                deleteAssignment.setForeground(Color.black);
                panel1.add(deleteAssignment, "cell 1 1");

                //---- activatedeactivate ----
                activatedeactivate.setText("Activate/Deactivate");
                activatedeactivate.setBackground(Color.white);
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
    // Generated using JFormDesigner Evaluation license - Aysha Panatch
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
    /**
     * The panel, scrollpanes, and labels fields help with the formatting of the GUI.
     * assignmentList is the JList that displays assignments in the course.
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
        else if(e.getSource() == addAssignment) {

            String filePath = addFile();
            boolean r = false;
            if(filePath!=null) {
                r = this.addAssign(filePath);
            }

            try {
                if(r==true){
                    Assignment[] received = (Assignment[])(in.readObject());
                    if(received!=null) {
                        assignmentList.setListData(received);
                    }
                }
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
                Assignment[] received = (Assignment[])(in.readObject());
                if(received!=null) {
                    assignmentList.setListData(received);
                }
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
                Assignment[] received = (Assignment[])(in.readObject());
                if(received!=null) {
                    assignmentList.setListData(received);
                }
            }
            catch(ClassNotFoundException c) {
                System.err.println("Object error");
            }
            catch(IOException d) {
                System.err.println("IO Error");
            }
        }
    }

    /**
     * Allows the professor to add the file to the server's harddrive.
     */
    private String addFile() {
        JFileChooser fileBrowser = new JFileChooser();
        File selectedFile = null;
        String fileExtension = null;
        String fileName = null;
        String filePath = null;
        if(fileBrowser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            selectedFile = fileBrowser.getSelectedFile();
            // Gets extension or type of file
            fileName = fileBrowser.getSelectedFile().getName();
           // System.out.println(fileName);
            String[] splitString = fileName.split("\\.");
            fileExtension = splitString[1];
            System.out.println(fileExtension);
            fileName = splitString[0];

        }
        else {
            return null;
        }
        assert selectedFile != null;
        long length = selectedFile.length();

        byte[] content = new byte[(int) length];
        try {
            FileInputStream fis = new FileInputStream(selectedFile);
            BufferedInputStream bos = new BufferedInputStream(fis);
            bos.read(content, 0, (int)length);
        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        catch(IOException f) {
            f.printStackTrace();
        }

        Upload upload = new Upload(content, fileName, fileExtension);
        upload.setCommand("ADDASSIGNMENT");
        try{
            out.writeObject(upload);
            out.reset();
            filePath = (String) in.readObject();
            System.out.println(filePath);
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }

        return filePath;
    }
    /**
     * Creates the dialog box prompting the professor for the assignment they'd like to add.
     */
    private boolean addAssign(String filePath) {


        JTextField assignTitle = new JTextField(20);
        JTextField assignID = new JTextField(6);
        JTextField assignDueDate = new JTextField(8);

        //put all the things into the panel

        JPanel addAssignPanel = new JPanel();
        addAssignPanel.add(new JLabel("Enter the assignment title: "));
        addAssignPanel.add(assignTitle);
        addAssignPanel.add(new JLabel("Enter the assignment due date (DDMMYYYY): "));
        addAssignPanel.add(assignDueDate);

        int result = JOptionPane.showConfirmDialog(null, addAssignPanel,
                "Please Enter Assignment Information", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            Assignment newAssign = new Assignment(course.getCourseID(), assignTitle.getText(), filePath, true, assignDueDate.getText());
            newAssign.setCommand("ADD");
            try {
                out.writeObject(newAssign);
                out.reset();
            }
            catch(IOException d) {
                d.printStackTrace();
            }
            return true;
        }
        return false;
    }
    /**
     * Enables certain buttons when the list is clicked.
     */
    public void valueChanged(ListSelectionEvent e){
        activatedeactivate.setEnabled(true);
        deleteAssignment.setEnabled(true);
    }
}

