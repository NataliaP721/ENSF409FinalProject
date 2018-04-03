package ClientPack;

import java.awt.*;
import javax.swing.*;
import net.miginfocom.swing.*;
/*
 * Created by JFormDesigner on Sun Apr 01 13:36:12 MDT 2018
 */



/**
 * @author Edward Gu
 */
    class ManageSubmissions extends JFrame {
    ManageSubmissions() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Edward Gu
        panel1 = new JPanel();
        scrollPane1 = new JScrollPane();
        list1 = new JList();
        button2 = new JButton();
        panel2 = new JPanel();
        scrollPane2 = new JScrollPane();
        list2 = new JList();
        button3 = new JButton();
        button5 = new JButton();
        button4 = new JButton();

        //======== this ========
        setTitle("Manage Submissions");
        Container contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[193,fill]" +
            "[195,fill]" +
            "[198,fill]",
            // rows
            "[43]" +
            "[454]" +
            "[174]"));

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
                "[12,fill]" +
                "[167,fill]" +
                "[11,fill]",
                // rows
                "[19]" +
                "[329]" +
                "[22]"));

            //======== scrollPane1 ========
            {
                scrollPane1.setViewportView(list1);
            }
            panel1.add(scrollPane1, "cell 1 1,width 500,height 500");

            //---- button2 ----
            button2.setText("Select Assignment");
            panel1.add(button2, "cell 1 2");
        }
        contentPane.add(panel1, "cell 0 1");

        //======== panel2 ========
        {
            panel2.setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "[0,fill]" +
                "[184,fill]" +
                "[10,fill]",
                // rows
                "[0]" +
                "[303]" +
                "[18]"));

            //======== scrollPane2 ========
            {
                scrollPane2.setViewportView(list2);
            }
            panel2.add(scrollPane2, "cell 1 1,width 500,height 500");

            //---- button3 ----
            button3.setText("Open Submission");
            panel2.add(button3, "cell 1 2");
        }
        contentPane.add(panel2, "cell 1 1");

        //---- button5 ----
        button5.setText("Grade Submission");
        contentPane.add(button5, "cell 2 1");

        //---- button4 ----
        button4.setText("Back");
        contentPane.add(button4, "cell 2 2");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Edward Gu
    private JPanel panel1;
    private JScrollPane scrollPane1;
    private JList list1;
    private JButton button2;
    private JPanel panel2;
    private JScrollPane scrollPane2;
    private JList list2;
    private JButton button3;
    private JButton button5;
    private JButton button4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
