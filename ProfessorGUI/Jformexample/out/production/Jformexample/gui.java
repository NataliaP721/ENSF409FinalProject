import java.awt.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Sun Apr 01 13:21:23 MDT 2018
 */



/**
 * @author Aysha Panatch
 */
public class gui  {

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Aysha Panatch
        frame1 = new JFrame();
        panel1 = new JPanel();
        panel7 = new JPanel();
        hSpacer3 = new JPanel(null);
        hSpacer4 = new JPanel(null);
        hSpacer6 = new JPanel(null);
        hSpacer8 = new JPanel(null);
        hSpacer7 = new JPanel(null);
        hSpacer5 = new JPanel(null);
        hSpacer2 = new JPanel(null);
        hSpacer1 = new JPanel(null);
        comboBox1 = new JComboBox();
        panel8 = new JPanel();
        panel9 = new JPanel();
        label2 = new JLabel();
        panel10 = new JPanel();
        label3 = new JLabel();
        panel4 = new JPanel();
        panel5 = new JPanel();
        panel6 = new JPanel();
        scrollPane2 = new JScrollPane();
        list1 = new JList();

        //======== frame1 ========
        {
            frame1.setTitle("My Courses");
            frame1.setBackground(new Color(0, 153, 255));
            Container frame1ContentPane = frame1.getContentPane();
            frame1ContentPane.setLayout(new BorderLayout());

            //======== panel1 ========
            {

                // JFormDesigner evaluation mark
                panel1.setBorder(new javax.swing.border.CompoundBorder(
                    new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                        "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                        javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                        java.awt.Color.red), panel1.getBorder())); panel1.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

                panel1.setLayout(new GridLayout(4, 1));

                //======== panel7 ========
                {
                    panel7.setBackground(new Color(187, 187, 187));
                    panel7.setPreferredSize(new Dimension(1200, 34));
                    panel7.setMinimumSize(new Dimension(1200, 34));
                    panel7.setLayout(new GridLayout(1, 10));

                    //---- hSpacer3 ----
                    hSpacer3.setBackground(new Color(187, 187, 187));
                    panel7.add(hSpacer3);

                    //---- hSpacer4 ----
                    hSpacer4.setBackground(new Color(187, 187, 187));
                    panel7.add(hSpacer4);

                    //---- hSpacer6 ----
                    hSpacer6.setBackground(new Color(187, 187, 187));
                    panel7.add(hSpacer6);

                    //---- hSpacer8 ----
                    hSpacer8.setBackground(new Color(187, 187, 187));
                    panel7.add(hSpacer8);

                    //---- hSpacer7 ----
                    hSpacer7.setBackground(new Color(187, 187, 187));
                    panel7.add(hSpacer7);

                    //---- hSpacer5 ----
                    hSpacer5.setBackground(new Color(187, 187, 187));
                    panel7.add(hSpacer5);

                    //---- hSpacer2 ----
                    hSpacer2.setBackground(new Color(187, 187, 187));
                    panel7.add(hSpacer2);

                    //---- hSpacer1 ----
                    hSpacer1.setBackground(new Color(187, 187, 187));
                    panel7.add(hSpacer1);
                    panel7.add(comboBox1);
                }
                panel1.add(panel7);

                //======== panel8 ========
                {
                    panel8.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 1));
                }
                panel1.add(panel8);

                //======== panel9 ========
                {
                    panel9.setLayout(new FlowLayout());

                    //---- label2 ----
                    label2.setText("Welcome to the !D2L");
                    label2.setFont(label2.getFont().deriveFont(label2.getFont().getStyle() | Font.BOLD, label2.getFont().getSize() + 9f));
                    panel9.add(label2);
                }
                panel1.add(panel9);

                //======== panel10 ========
                {
                    panel10.setLayout(new FlowLayout());

                    //---- label3 ----
                    label3.setText("Courses");
                    label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 4f));
                    panel10.add(label3);
                }
                panel1.add(panel10);
            }
            frame1ContentPane.add(panel1, BorderLayout.NORTH);

            //======== panel4 ========
            {
                panel4.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 5));
            }
            frame1ContentPane.add(panel4, BorderLayout.WEST);

            //======== panel5 ========
            {
                panel5.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 30));
            }
            frame1ContentPane.add(panel5, BorderLayout.SOUTH);

            //======== panel6 ========
            {
                panel6.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 5));
            }
            frame1ContentPane.add(panel6, BorderLayout.EAST);

            //======== scrollPane2 ========
            {
                scrollPane2.setViewportView(list1);
            }
            frame1ContentPane.add(scrollPane2, BorderLayout.CENTER);
            frame1.pack();
            frame1.setLocationRelativeTo(frame1.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Aysha Panatch
    private JFrame frame1;
    private JPanel panel1;
    private JPanel panel7;
    private JPanel hSpacer3;
    private JPanel hSpacer4;
    private JPanel hSpacer6;
    private JPanel hSpacer8;
    private JPanel hSpacer7;
    private JPanel hSpacer5;
    private JPanel hSpacer2;
    private JPanel hSpacer1;
    private JComboBox comboBox1;
    private JPanel panel8;
    private JPanel panel9;
    private JLabel label2;
    private JPanel panel10;
    private JLabel label3;
    private JPanel panel4;
    private JPanel panel5;
    private JPanel panel6;
    private JScrollPane scrollPane2;
    private JList list1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
