package ClientPack;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import net.miginfocom.swing.*;
/*
 * Created by JFormDesigner on Sun Apr 01 13:36:12 MDT 2018
 */



/**
 * @author Edward Gu
 */
    class ManageSubmissions extends JFrame implements ActionListener, ListSelectionListener{
    ManageSubmissions() {
        initComponents();
        selectAssignment.addActionListener(this);
        openSubmission.addActionListener(this);
        gradeSubmission.addActionListener(this);
        back.addActionListener(this);
        assignmentList.addListSelectionListener(this);
        submissionList.addListSelectionListener(this);
        this.setSize(700,700);
        this.setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Aysha Panatch
        panel4 = new JPanel();
        back = new JButton();
        panel3 = new JPanel();
        label1 = new JLabel();
        panel1 = new JPanel();
        scrollPane1 = new JScrollPane();
        assignmentList = new JList();
        panel2 = new JPanel();
        scrollPane2 = new JScrollPane();
        submissionList = new JList();
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
            back.setBackground(Color.black);
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
                        "[395]0" +
                        "[18]0"));

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
                selectAssignment.setBackground(Color.black);
                selectAssignment.setForeground(Color.black);
                panel1.add(selectAssignment, "cell 1 2");

                //---- openSubmission ----
                openSubmission.setText("Open Submission");
                openSubmission.setBackground(Color.black);
                openSubmission.setForeground(Color.black);
                panel1.add(openSubmission, "cell 3 2");

                //---- gradeSubmission ----
                gradeSubmission.setText("Grade Submission");
                gradeSubmission.setForeground(Color.black);
                gradeSubmission.setBackground(Color.black);
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
    // Generated using JFormDesigner Evaluation license - Aysha Panatch
    private JPanel panel4;
    private JButton back;
    private JPanel panel3;
    private JLabel label1;
    private JPanel panel1;
    private JScrollPane scrollPane1;
    private JList assignmentList;
    private JPanel panel2;
    private JScrollPane scrollPane2;
    private JList submissionList;
    private JButton selectAssignment;
    private JButton openSubmission;
    private JButton gradeSubmission;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public static void main(String[] args) {
        ManageSubmissions obj = new ManageSubmissions();
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public void valueChanged(ListSelectionEvent e){
    }
}
