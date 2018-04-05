import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
/*
 * Created by JFormDesigner on Sun Apr 01 12:19:26 MDT 2018
 */


/**
 * @author Aysha Panatch
 */
public class EnrollStudents extends JFrame {
    public EnrollStudents() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Aysha Panatch
        panel4 = new JPanel();
        label10 = new JLabel();
        radioButton3 = new JRadioButton();
        radioButton4 = new JRadioButton();
        label11 = new JLabel();
        textField4 = new JTextField();
        button4 = new JButton();
        scrollPane5 = new JScrollPane();
        list1 = new JList();
        button5 = new JButton();
        button6 = new JButton();

        //======== this ========
        setTitle("Email Students");
        Container contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[662,fill]",
            // rows
            "[649]"));

        //======== panel4 ========
        {

            // JFormDesigner evaluation mark
            panel4.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                    "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                    javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                    java.awt.Color.red), panel4.getBorder())); panel4.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

            panel4.setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "0[671,fill]0",
                // rows
                "[35]" +
                "[27]" +
                "[]" +
                "[]" +
                "[448]" +
                "[]"));

            //---- label10 ----
            label10.setText("Search Students By:");
            label10.setFont(new Font("Geneva", Font.PLAIN, 13));
            panel4.add(label10, "cell 0 0");

            //---- radioButton3 ----
            radioButton3.setText("ID");
            radioButton3.setFont(new Font("Geneva", Font.PLAIN, 13));
            panel4.add(radioButton3, "cell 0 1");

            //---- radioButton4 ----
            radioButton4.setText("Last Name");
            radioButton4.setFont(new Font("Geneva", Font.PLAIN, 13));
            panel4.add(radioButton4, "cell 0 1");

            //---- label11 ----
            label11.setText("Enter Search Parameter:");
            label11.setFont(new Font("Geneva", Font.PLAIN, 13));
            panel4.add(label11, "cell 0 2");
            panel4.add(textField4, "cell 0 3 12 1");

            //---- button4 ----
            button4.setText("Search");
            button4.setFont(new Font("Geneva", Font.PLAIN, 11));
            panel4.add(button4, "cell 0 3 12 1,alignx right,growx 0");

            //======== scrollPane5 ========
            {
                scrollPane5.setViewportView(list1);
            }
            panel4.add(scrollPane5, "cell 0 4,grow");

            //---- button5 ----
            button5.setText("Display Class List");
            button5.setFont(new Font("Geneva", Font.PLAIN, 11));
            panel4.add(button5, "cell 0 5");

            //---- button6 ----
            button6.setText("Enroll/Unenroll Student");
            button6.setFont(button6.getFont().deriveFont(button6.getFont().getSize() - 2f));
            panel4.add(button6, "cell 0 5");
        }
        contentPane.add(panel4, "cell 0 0,grow");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Aysha Panatch
    private JPanel panel4;
    private JLabel label10;
    private JRadioButton radioButton3;
    private JRadioButton radioButton4;
    private JLabel label11;
    private JTextField textField4;
    private JButton button4;
    private JScrollPane scrollPane5;
    private JList list1;
    private JButton button5;
    private JButton button6;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public static void main(String[] args) {
        EnrollStudents obj = new EnrollStudents();
    }
}
