/*
 * Created by JFormDesigner on Sat Apr 07 21:21:13 MDT 2018
 */

package ClientPack;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

import net.miginfocom.swing.*;
import SharedDataObjects.*;
import java.util.Random;

/**
 * Creates the assignment submission's homepage with all the assignments listed, including the ability to submit assignments
 * @author Aysha Panatch, Natalia Pavlovic, Eddy Gu
 * @version 1.0
 * @since April 11, 2018
 */
public class SubmitAssignments extends JFrame implements ActionListener, ListSelectionListener {
    /**
     * Constructs a SubmitAssignments object with the specified values for in, out, course and student.
     * The values for the fields are supplied by the given parameters.
     * @param in the ObjectInputStream used to read objects from the socket
     * @param out the ObjectOutputStream used to write objects to the socket
     * @param course the Course the Student is submitting the Assignments for
     * @param student the Student who is submitting their Assignments
     */
    SubmitAssignments(ObjectInputStream in, ObjectOutputStream out, Course course, User student) {
        this.in = in;
        this.out = out;
        this.course = course;
        this.student = student;
        random = new Random();
        initComponents();
        submitAssignment.addActionListener(this);
        viewSubmissions.addActionListener(this);
        back.addActionListener(this);
        courseName.setText(course.getCourseName());
        submitAssignment.setEnabled(false);
        assignmentList.addListSelectionListener(this);
        submissionList.addListSelectionListener(this);
        viewSubmissions.setEnabled(true);
        this.setSize(700,700);
        this.setVisible(true);
        try {
            course.setCommand("GETACTIVE");
            out.writeObject(course);
            out.reset();
            Assignment [] received = (Assignment[])(in.readObject());
            if(received!=null) {
                assignmentList.setListData(received);
            }
        }
        catch(ClassNotFoundException e) {
            System.err.println("error");
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
        submitAssignment = new JButton();
        label2 = new JLabel();
        scrollPane1 = new JScrollPane();
        assignmentList = new JList<>();
        label1 = new JLabel();
        scrollPane2 = new JScrollPane();
        submissionList = new JList<>();
        viewSubmissions = new JButton();

        //======== this ========
        setTitle("Submit Assignments");
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
                "0[700,grow,fill]0",
                // rows
                "0[25]0" +
                "[]" +
                "[]" +
                "[]" +
                "[231]0" +
                "[]" +
                "[235]" +
                "[]"));

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

                //---- submitAssignment ----
                submitAssignment.setText("Submit Completed Assignment");
                submitAssignment.setBackground(Color.white);
                submitAssignment.setForeground(Color.black);
                panel1.add(submitAssignment, "cell 1 1");
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

            //---- label1 ----
            label1.setText("Submissions");
            label1.setFont(label1.getFont().deriveFont(label1.getFont().getStyle() | Font.BOLD, label1.getFont().getSize() + 2f));
            label1.setForeground(Color.black);
            label1.setBackground(new Color(115, 194, 251));
            panel2.add(label1, "cell 0 5,alignx center,growx 0");

            //======== scrollPane2 ========
            {

                //---- submissionList ----
                submissionList.setBackground(Color.white);
                submissionList.setForeground(Color.black);
                scrollPane2.setViewportView(submissionList);
            }
            panel2.add(scrollPane2, "cell 0 6,grow");

            //---- viewSubmissions ----
            viewSubmissions.setText("View Submissions");
            viewSubmissions.setBackground(Color.white);
            viewSubmissions.setForeground(Color.black);
            panel2.add(viewSubmissions, "cell 0 7,alignx center,growx 0");
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
    private JButton submitAssignment;
    private JLabel label2;
    private JScrollPane scrollPane1;
    private JList<Assignment> assignmentList;
    private JLabel label1;
    private JScrollPane scrollPane2;
    private JList<Submission> submissionList;
    private JButton viewSubmissions;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private Course course;
    private ObjectInputStream in;
    private ObjectOutputStream out;
    private Assignment selected;
    private User student;
    private Random random;
    private Boolean submitted;
    /**
     * The frame is the main frame of the GUI.
     * The panel, scrollpanes, and labels fields help with the formatting of the GUI.
     * courseList is the JList that displays all the assignments
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
        else if (e.getSource() == submitAssignment) {
            selected = assignmentList.getSelectedValue();
            this.addSub(this.addFile());
            try {
                Submission[] received = (Submission[])in.readObject();
                if(received!=null) {
                    submissionList.setListData(received);
                }
            }
            catch(ClassNotFoundException f) {
                f.printStackTrace();
            }
            catch(IOException g) {
                g.printStackTrace();
            }
        }
        else if (e.getSource() == viewSubmissions) {
            selected = assignmentList.getSelectedValue();
            Submission view = new Submission(selected.getAssignmentID(), student.getID());
            view.setCommand("SEARCHSUBMISSION");
            try {
                out.writeObject(view);
                out.reset();
                Submission[] received = (Submission[])in.readObject();
                if(received!=null) {
                    submissionList.setListData(received);
                }
            }
            catch(ClassNotFoundException f) {
                f.printStackTrace();
            }
            catch(IOException g) {
                g.printStackTrace();
            }
        }
    }

    /**
     * Allows the student to add the file to upload.
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
        upload.setCommand("ADDSUBMISSION");
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
     * Allows the student to add to submission to a particular assignment.
     */
    private void addSub(String filePath) {

        DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

        Date today = Calendar.getInstance().getTime();
        String reportDate = df.format(today);
        JTextField comments = new JTextField(20);


        JPanel addComPanel = new JPanel();
        addComPanel.add(new JLabel("Submission comments: "));
        addComPanel.add(comments);
        String comment = "";

        int result = JOptionPane.showConfirmDialog(null, addComPanel,
                "Please Enter Submission Comments", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            comment = comments.getText();
            System.out.println(comment);

            Submission newSub = new Submission(selected.getAssignmentID(), student.getID(), filePath, -1, comment, reportDate, selected.getAssignmentTitle());
            newSub.setCommand("ADD");

            try {
                out.writeObject(newSub);
                out.reset();
            } catch (IOException d) {
                d.printStackTrace();
            }
        }
    }

    /**
     * Enables certain buttons when the list is clicked.
     */
    public void valueChanged(ListSelectionEvent e){
        if(e.getSource()==assignmentList){
            submitAssignment.setEnabled(true);
        }
    }
}
