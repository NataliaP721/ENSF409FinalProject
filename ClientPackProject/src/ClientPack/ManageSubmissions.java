package ClientPack;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;

import SharedDataObjects.*;
import net.miginfocom.swing.*;
/*
 * Created by JFormDesigner on Sun Apr 01 13:36:12 MDT 2018
 */



/**
 * @author Edward Gu
 */
    class ManageSubmissions extends JFrame implements ActionListener{
    ManageSubmissions(ObjectInputStream in, ObjectOutputStream out, Course course) {
        this.in = in;
        this.out = out;
        this.course = course;
        initComponents();
        selectAssignment.addActionListener(this);
        openSubmission.addActionListener(this);
        gradeSubmission.addActionListener(this);
        back.addActionListener(this);
        this.setSize(700,700);
        this.setVisible(true);
        try {
            course.setCommand("GETASSIGNMENTS");
            out.writeObject(course);
            out.reset();
            assignmentList.setListData((Assignment[])(in.readObject()));
        }
        catch(ClassNotFoundException e) {
            System.err.println("error");
        }
        catch(IOException e) {
            System.err.println("IO Error");
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Edward Gu
        panel4 = new JPanel();
        back = new JButton();
        panel3 = new JPanel();
        label1 = new JLabel();
        panel1 = new JPanel();
        label2 = new JLabel();
        label3 = new JLabel();
        scrollPane1 = new JScrollPane();
        assignmentList = new JList<>();
        panel2 = new JPanel();
        scrollPane2 = new JScrollPane();
        submissionList = new JList<>();
        selectAssignment = new JButton();
        openSubmission = new JButton();
        gradeSubmission = new JButton();

        //======== this ========
        setTitle("Manage Submissions");
        setBackground(new Color(115, 194, 251));
        setForeground(new Color(115, 194, 251));
        Container contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "0[700,grow,fill]0",
            // rows
            "0[]0" +
            "[700,grow,fill]0"));

        //======== panel4 ========
        {
            panel4.setBackground(new Color(115, 194, 251));

            // JFormDesigner evaluation mark
            panel4.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                    "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                    javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                    java.awt.Color.red), panel4.getBorder())); panel4.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

            panel4.setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "0[430,grow,fill]0",
                // rows
                "[]" +
                "[576]0"));

            //---- back ----
            back.setText("Back");
            back.setBackground(Color.white);
            back.setForeground(Color.black);
            panel4.add(back, "cell 0 0,alignx left,growx 0");

            //======== panel3 ========
            {
                panel3.setBackground(new Color(115, 194, 251));
                panel3.setLayout(new MigLayout(
                    "hidemode 3",
                    // columns
                    "0[fill]0" +
                    "[fill]",
                    // rows
                    "0[]0" +
                    "[]"));

                //---- label1 ----
                label1.setText("Manage Submissions");
                label1.setFont(new Font(".SF NS Text", Font.BOLD, 26));
                label1.setForeground(Color.black);
                label1.setHorizontalAlignment(SwingConstants.RIGHT);
                panel3.add(label1, "cell 1 0,align right bottom,grow 0 0");
            }
            panel4.add(panel3, "cell 0 0,alignx right,growx 0");

            //======== panel1 ========
            {
                panel1.setBackground(new Color(115, 194, 251));
                panel1.setLayout(new MigLayout(
                    "hidemode 3",
                    // columns
                    "[0,fill]0" +
                    "[330,fill]0" +
                    "[11,fill]0" +
                    "[330,fill]5",
                    // rows
                    "0[19]0" +
                    "[395]0" +
                    "[22]0" +
                    "[]"));

                //---- label2 ----
                label2.setText("Assignments");
                label2.setForeground(Color.black);
                label2.setFont(new Font(".SF NS Text", Font.BOLD, 20));
                panel1.add(label2, "cell 1 0");

                //---- label3 ----
                label3.setText("Submissions");
                label3.setFont(new Font(".SF NS Text", Font.BOLD, 20));
                label3.setForeground(Color.black);
                panel1.add(label3, "cell 3 0");

                //======== scrollPane1 ========
                {

                    //---- assignmentList ----
                    assignmentList.setBackground(Color.lightGray);
                    assignmentList.setForeground(Color.black);
                    scrollPane1.setViewportView(assignmentList);
                }
                panel1.add(scrollPane1, "cell 1 1,width 500,height 500");

                //======== panel2 ========
                {
                    panel2.setBackground(new Color(115, 194, 251));
                    panel2.setLayout(new MigLayout(
                        "hidemode 3",
                        // columns
                        "0[0,fill]0" +
                        "[202,grow,fill]0" +
                        "[0,fill]0",
                        // rows
                        "0[0]0" +
                        "[496]0" +
                        "[21]0"));

                    //======== scrollPane2 ========
                    {

                        //---- submissionList ----
                        submissionList.setBackground(Color.lightGray);
                        submissionList.setForeground(Color.black);
                        scrollPane2.setViewportView(submissionList);
                    }
                    panel2.add(scrollPane2, "cell 1 1,width 500,height 500");
                }
                panel1.add(panel2, "cell 3 1");

                //---- selectAssignment ----
                selectAssignment.setText("Select Assignment");
                selectAssignment.setBackground(Color.white);
                selectAssignment.setForeground(Color.black);
                panel1.add(selectAssignment, "cell 1 2");

                //---- openSubmission ----
                openSubmission.setText("Open Submission");
                openSubmission.setBackground(Color.white);
                openSubmission.setForeground(Color.black);
                panel1.add(openSubmission, "cell 3 2");

                //---- gradeSubmission ----
                gradeSubmission.setText("Grade Submission");
                gradeSubmission.setForeground(Color.black);
                gradeSubmission.setBackground(Color.white);
                panel1.add(gradeSubmission, "cell 3 3,aligny center,growy 0");
            }
            panel4.add(panel1, "cell 0 1,alignx left,growx 0");
        }
        contentPane.add(panel4, "cell 0 1");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Edward Gu
    private JPanel panel4;
    private JButton back;
    private JPanel panel3;
    private JLabel label1;
    private JPanel panel1;
    private JLabel label2;
    private JLabel label3;
    private JScrollPane scrollPane1;
    private JList<Assignment> assignmentList;
    private JPanel panel2;
    private JScrollPane scrollPane2;
    private JList<Submission> submissionList;
    private JButton selectAssignment;
    private JButton openSubmission;
    private JButton gradeSubmission;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    private Course course;
    private ObjectInputStream in;
    private ObjectOutputStream out;


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == back) {
            this.dispose();
        }
        else if(e.getSource() == selectAssignment) {
            Assignment current = (Assignment)assignmentList.getSelectedValue();
            current.setCommand("GETSUBMISSION");
            try {
                out.writeObject(current);
                out.reset();
                submissionList.setListData((Submission[])(in.readObject()));
            }
            catch(ClassNotFoundException c) {
                System.err.println("Object error");
            }
            catch(IOException d) {
                System.err.println("IO Error");
            }
        }
        else if(e.getSource() == openSubmission) {
            Submission current = (Submission) submissionList.getSelectedValue();
            current.setCommand("GETFILE");
            try {
                out.writeObject(current);
                out.reset();
                Upload content = (Upload)in.readObject();
                File newFile = new File("/home/natalia/Client/" + content.getFileName() + "." + content.getFileExtension());
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
        else if(e.getSource() == gradeSubmission) {
            Submission submit = (Submission) submissionList.getSelectedValue();
            this.grade(submit);
        }
    }


    private void grade(Submission submit) {

        JTextField gradeMark = new JTextField(3);


        JPanel addGradePanel = new JPanel();
        addGradePanel.add(new JLabel("Enter the grade for this submission: "));
        addGradePanel.add(gradeMark);


        int result = JOptionPane.showConfirmDialog(null, addGradePanel,
                "Please Enter Grade", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            Grade newGrade = new Grade(assignmentList.getSelectedValue().getAssignmentID(), submit.getStudentID(), course.getCourseID(), Integer.parseInt(gradeMark.getText()));
            newGrade.setCommand("NEWGRADE");
            try {
                //out.writeObject(newGrade);
                out.reset();
                submissionList.setListData((Submission[])(in.readObject()));
            }
            catch(ClassNotFoundException e) {
                System.err.println("error");
            }
            catch(IOException d) {
                System.err.println("IO Error");
            }
        }

    }
}
