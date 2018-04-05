package ClientPack;

import SharedDataObjects.*;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/*
 * Created by JFormDesigner on Sun Apr 01 12:19:26 MDT 2018
 */


/**
 * @author Aysha Panatch
 */
public class ManageGrades extends JFrame implements ActionListener, ListSelectionListener{
    ManageGrades(ObjectInputStream in, ObjectOutputStream out) {
        this.in = in;
        this.out = out;
        initComponents();
        search.addActionListener(this);
        back.addActionListener(this);
        downloadSubmission.addActionListener(this);
        enterGrade.addActionListener(this);
        gradeList.addListSelectionListener(this);
        this.setSize(700, 700);
        this.setVisible(true);
    }

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
        gradeList = new JList();
        enterGrade = new JButton();
        downloadSubmission = new JButton();

        //======== this ========
        setTitle("Grades Students");
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
                panel4.setLayout(new MigLayout(
                    "hidemode 3",
                    // columns
                    "10[700,grow,fill]10" +
                    "[fill]",
                    // rows
                    "0[0]0" +
                    "[]0" +
                    "[35]" +
                    "[27]" +
                    "[]" +
                    "[]" +
                    "[473]" +
                    "[]0"));

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
                    back.setBackground(Color.black);
                    back.setForeground(Color.darkGray);
                    panel2.add(back, "cell 0 0");
                }
                panel4.add(panel2, "cell 0 1,alignx left,growx 0");

                //---- label1 ----
                label1.setFont(new Font(".SF NS Text", Font.BOLD, 26));
                label1.setForeground(Color.black);
                label1.setHorizontalAlignment(SwingConstants.RIGHT);
                label1.setText("Manage Grades");
                panel4.add(label1, "cell 0 1");

                //---- label10 ----
                label10.setText("  Search Grades By:");
                label10.setFont(new Font(".SF NS Text", Font.PLAIN, 16));
                label10.setForeground(Color.black);
                label10.setBackground(new Color(115, 194, 251));
                panel4.add(label10, "cell 0 2");

                //---- IDradioButton ----
                IDradioButton.setText("ID");
                IDradioButton.setFont(new Font(".SF NS Text", Font.PLAIN, 15));
                IDradioButton.setBackground(new Color(115, 194, 251));
                IDradioButton.setForeground(Color.black);
                panel4.add(IDradioButton, "cell 0 3");

                //---- lastNameradioButton ----
                lastNameradioButton.setText("Last Name");
                lastNameradioButton.setFont(new Font(".SF NS Text", Font.PLAIN, 15));
                lastNameradioButton.setBackground(new Color(115, 194, 251));
                lastNameradioButton.setForeground(Color.black);
                panel4.add(lastNameradioButton, "cell 0 3");

                //---- label11 ----
                label11.setText("  Enter Search Parameter:");
                label11.setFont(new Font(".SF NS Text", Font.PLAIN, 16));
                label11.setForeground(Color.black);
                panel4.add(label11, "cell 0 4");

                //---- searchparameter ----
                searchparameter.setBackground(Color.white);
                panel4.add(searchparameter, "cell 0 5");

                //---- search ----
                search.setText("Search");
                search.setFont(new Font(".SF NS Text", Font.PLAIN, 15));
                search.setBackground(Color.black);
                search.setForeground(Color.black);
                panel4.add(search, "cell 0 5,alignx right,growx 0");

                //======== scrollPane5 ========
                {

                    //---- gradeList ----
                    gradeList.setBackground(Color.white);
                    gradeList.setForeground(Color.black);
                    scrollPane5.setViewportView(gradeList);
                }
                panel4.add(scrollPane5, "cell 0 6,grow");

                //---- enterGrade ----
                enterGrade.setText("Enter Grade");
                enterGrade.setFont(enterGrade.getFont().deriveFont(enterGrade.getFont().getSize() + 1f));
                enterGrade.setBackground(Color.black);
                enterGrade.setForeground(Color.black);
                panel4.add(enterGrade, "cell 0 7");

                //---- downloadSubmission ----
                downloadSubmission.setText("Download Submission");
                downloadSubmission.setBackground(Color.black);
                downloadSubmission.setForeground(Color.black);
                downloadSubmission.setFont(downloadSubmission.getFont().deriveFont(downloadSubmission.getFont().getSize() + 1f));
                panel4.add(downloadSubmission, "cell 0 7");
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
    private JList gradeList;
    private JButton enterGrade;
    private JButton downloadSubmission;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    private Course course;
    private boolean visible;
    private ObjectInputStream in;
    private ObjectOutputStream out;
//    public static void main(String[] args) {
//        ManageGrades obj = new ManageGrades();
//    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public void valueChanged(ListSelectionEvent e){
    }

    void setCourse(Course x) {
        this.course = x;
        visible = true;
    }

    boolean getVisible() {
        return visible;
    }
}
