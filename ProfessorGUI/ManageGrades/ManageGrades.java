import java.awt.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Sun Apr 01 13:57:38 MDT 2018
 */



/**
 * @author Aysha Panatch
 */
public class ManageGrades extends JPanel {
    public ManageGrades() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Aysha Panatch
        frame1 = new JFrame();
        panel4 = new JPanel();
        panel5 = new JPanel();
        scrollPane2 = new JScrollPane();
        list1 = new JList();
        panel7 = new JPanel();
        panel32 = new JPanel();
        panel33 = new JPanel();
        panel34 = new JPanel();
        panel35 = new JPanel();
        panel37 = new JPanel();
        panel38 = new JPanel();
        panel39 = new JPanel();
        label8 = new JLabel();
        panel40 = new JPanel();
        button3 = new JButton();
        hSpacer40 = new JPanel(null);
        hSpacer41 = new JPanel(null);
        hSpacer44 = new JPanel(null);
        hSpacer43 = new JPanel(null);
        hSpacer42 = new JPanel(null);
        panel41 = new JPanel();
        panel42 = new JPanel();
        label7 = new JLabel();
        radioButton10 = new JRadioButton();
        radioButton11 = new JRadioButton();
        panel43 = new JPanel();
        button4 = new JButton();
        hSpacer49 = new JPanel(null);
        hSpacer48 = new JPanel(null);
        hSpacer47 = new JPanel(null);
        hSpacer46 = new JPanel(null);
        hSpacer45 = new JPanel(null);
        panel44 = new JPanel();

        //======== frame1 ========
        {
            frame1.setTitle("Manage Grades");
            frame1.setBackground(new Color(0, 153, 255));
            Container frame1ContentPane = frame1.getContentPane();
            frame1ContentPane.setLayout(new BorderLayout());

            //======== panel4 ========
            {

                // JFormDesigner evaluation mark
                panel4.setBorder(new javax.swing.border.CompoundBorder(
                    new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                        "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                        javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                        java.awt.Color.red), panel4.getBorder())); panel4.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

                panel4.setLayout(new FlowLayout(FlowLayout.CENTER, 28, 5));
            }
            frame1ContentPane.add(panel4, BorderLayout.WEST);

            //======== panel5 ========
            {
                panel5.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 30));
            }
            frame1ContentPane.add(panel5, BorderLayout.SOUTH);

            //======== scrollPane2 ========
            {
                scrollPane2.setViewportView(list1);
            }
            frame1ContentPane.add(scrollPane2, BorderLayout.CENTER);

            //======== panel7 ========
            {
                panel7.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 5));
            }
            frame1ContentPane.add(panel7, BorderLayout.EAST);

            //======== panel32 ========
            {
                panel32.setLayout(new BorderLayout());

                //======== panel33 ========
                {
                    panel33.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 5));
                }
                panel32.add(panel33, BorderLayout.WEST);

                //======== panel34 ========
                {
                    panel34.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 60));
                }
                panel32.add(panel34, BorderLayout.EAST);

                //======== panel35 ========
                {
                    panel35.setLayout(new BorderLayout());

                    //======== panel37 ========
                    {
                        panel37.setMinimumSize(new Dimension(60, 30));
                        panel37.setPreferredSize(new Dimension(60, 25));
                        panel37.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 30));
                    }
                    panel35.add(panel37, BorderLayout.EAST);

                    //======== panel38 ========
                    {
                        panel38.setLayout(new FlowLayout());
                    }
                    panel35.add(panel38, BorderLayout.NORTH);

                    //======== panel39 ========
                    {
                        panel39.setLayout(new FlowLayout());

                        //---- label8 ----
                        label8.setText("Student Grades");
                        label8.setFont(label8.getFont().deriveFont(label8.getFont().getStyle() | Font.BOLD, label8.getFont().getSize() + 10f));
                        panel39.add(label8);
                    }
                    panel35.add(panel39, BorderLayout.SOUTH);

                    //======== panel40 ========
                    {
                        panel40.setMaximumSize(new Dimension(32767, 10000));
                        panel40.setMinimumSize(new Dimension(410, 5));
                        panel40.setPreferredSize(new Dimension(410, 5));
                        panel40.setLayout(new GridLayout(1, 5));

                        //---- button3 ----
                        button3.setText("Back");
                        button3.setMinimumSize(new Dimension(50, 30));
                        button3.setMaximumSize(new Dimension(82, 30));
                        button3.setPreferredSize(new Dimension(50, 25));
                        panel40.add(button3);
                        panel40.add(hSpacer40);
                        panel40.add(hSpacer41);
                        panel40.add(hSpacer44);
                        panel40.add(hSpacer43);
                        panel40.add(hSpacer42);
                    }
                    panel35.add(panel40, BorderLayout.CENTER);

                    //======== panel41 ========
                    {
                        panel41.setMinimumSize(new Dimension(60, 30));
                        panel41.setPreferredSize(new Dimension(60, 25));
                        panel41.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 30));
                    }
                    panel35.add(panel41, BorderLayout.WEST);
                }
                panel32.add(panel35, BorderLayout.NORTH);

                //======== panel42 ========
                {
                    panel42.setLayout(new GridLayout(5, 1));

                    //---- label7 ----
                    label7.setText("Search Students by:");
                    panel42.add(label7);

                    //---- radioButton10 ----
                    radioButton10.setText("ID");
                    panel42.add(radioButton10);

                    //---- radioButton11 ----
                    radioButton11.setText("Last Name");
                    panel42.add(radioButton11);

                    //======== panel43 ========
                    {
                        panel43.setLayout(new GridLayout(1, 6));

                        //---- button4 ----
                        button4.setText("Search");
                        panel43.add(button4);
                        panel43.add(hSpacer49);
                        panel43.add(hSpacer48);
                        panel43.add(hSpacer47);
                        panel43.add(hSpacer46);
                        panel43.add(hSpacer45);
                    }
                    panel42.add(panel43);

                    //======== panel44 ========
                    {
                        panel44.setLayout(new FlowLayout());
                    }
                    panel42.add(panel44);
                }
                panel32.add(panel42, BorderLayout.CENTER);
            }
            frame1ContentPane.add(panel32, BorderLayout.NORTH);
            frame1.pack();
            frame1.setLocationRelativeTo(frame1.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Aysha Panatch
    private JFrame frame1;
    private JPanel panel4;
    private JPanel panel5;
    private JScrollPane scrollPane2;
    private JList list1;
    private JPanel panel7;
    private JPanel panel32;
    private JPanel panel33;
    private JPanel panel34;
    private JPanel panel35;
    private JPanel panel37;
    private JPanel panel38;
    private JPanel panel39;
    private JLabel label8;
    private JPanel panel40;
    private JButton button3;
    private JPanel hSpacer40;
    private JPanel hSpacer41;
    private JPanel hSpacer44;
    private JPanel hSpacer43;
    private JPanel hSpacer42;
    private JPanel panel41;
    private JPanel panel42;
    private JLabel label7;
    private JRadioButton radioButton10;
    private JRadioButton radioButton11;
    private JPanel panel43;
    private JButton button4;
    private JPanel hSpacer49;
    private JPanel hSpacer48;
    private JPanel hSpacer47;
    private JPanel hSpacer46;
    private JPanel hSpacer45;
    private JPanel panel44;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public static void main(String[] args) {
        ManageGrades obj = new ManageGrades();
        obj.frame1.setVisible(true);
        obj.frame1.setSize(700, 700);
    }
}
