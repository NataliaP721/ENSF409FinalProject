package ClientPack;

import java.awt.*;
import javax.swing.*;
import net.miginfocom.swing.*;
/*
 * Created by JFormDesigner on Sun Apr 01 12:59:24 MDT 2018
 */



/**
 * @author Edward Gu
 */
    class ManageCourses extends JFrame {
    ManageCourses() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Edward Gu
        frame1 = new JFrame();
        label2 = new JLabel();
        panel1 = new JPanel();
        button7 = new JButton();
        button8 = new JButton();
        button11 = new JButton();
        button9 = new JButton();
        button10 = new JButton();
        button12 = new JButton();

        //======== frame1 ========
        {
            frame1.setTitle("Manage Course");
            frame1.setBackground(UIManager.getColor("Button.darcula.defaultStartColor"));
            frame1.setForeground(SystemColor.textInactiveText);
            frame1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame1.setFont(new Font("Geneva", Font.PLAIN, 13));
            Container frame1ContentPane = frame1.getContentPane();
            frame1ContentPane.setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "[236,fill]" +
                "[215,fill]" +
                "[228,fill]",
                // rows
                "[101]" +
                "[205]" +
                "[116]"));

            //---- label2 ----
            label2.setText("Course: ENCM 511");
            label2.setHorizontalAlignment(SwingConstants.CENTER);
            label2.setFont(new Font("Geneva", Font.PLAIN, 15));
            frame1ContentPane.add(label2, "cell 1 0");

            //======== panel1 ========
            {

                // JFormDesigner evaluation mark
                panel1.setBorder(new javax.swing.border.CompoundBorder(
                    new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                        "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                        javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                        java.awt.Color.red), panel1.getBorder())); panel1.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

                panel1.setLayout(new MigLayout(
                    "hidemode 3",
                    // columns
                    "[106,fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]",
                    // rows
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]"));

                //---- button7 ----
                button7.setText("Manage Assignments");
                button7.setFont(new Font("Geneva", Font.PLAIN, 11));
                panel1.add(button7, "cell 2 0");

                //---- button8 ----
                button8.setText("Manage Submissions");
                button8.setFont(new Font("Geneva", Font.PLAIN, 11));
                panel1.add(button8, "cell 2 1");

                //---- button11 ----
                button11.setText("Manage Grades");
                button11.setFont(new Font("Geneva", Font.PLAIN, 11));
                panel1.add(button11, "cell 2 2");

                //---- button9 ----
                button9.setText("Email Students");
                button9.setFont(new Font("Geneva", Font.PLAIN, 11));
                panel1.add(button9, "cell 2 3");

                //---- button10 ----
                button10.setText("Enroll Students");
                button10.setFont(new Font("Geneva", Font.PLAIN, 11));
                button10.setIcon(null);
                button10.setPreferredSize(new Dimension(100, 100));
                panel1.add(button10, "cell 2 4");
            }
            frame1ContentPane.add(panel1, "cell 1 1");

            //---- button12 ----
            button12.setText("Back");
            button12.setFont(new Font("Geneva", Font.PLAIN, 11));
            frame1ContentPane.add(button12, "cell 2 2");
            frame1.pack();
            frame1.setLocationRelativeTo(frame1.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        frame1.setVisible(true);
        frame1.setSize(500, 500);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Edward Gu
    private JFrame frame1;
    private JLabel label2;
    private JPanel panel1;
    private JButton button7;
    private JButton button8;
    private JButton button11;
    private JButton button9;
    private JButton button10;
    private JButton button12;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

}