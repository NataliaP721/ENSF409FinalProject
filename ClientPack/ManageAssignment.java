import java.awt.*;
import javax.swing.*;
import net.miginfocom.swing.*;
/*
 * Created by JFormDesigner on Sun Apr 01 10:57:59 MDT 2018
 */



/**
 * @author Aysha Panatch
 */
public class ManageAssignment extends JFrame {
    public ManageAssignment() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Aysha Panatch
        label1 = new JLabel();
        panel1 = new JPanel();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        label2 = new JLabel();
        label3 = new JLabel();
        scrollPane1 = new JScrollPane();
        list1 = new JList();

        //======== this ========
        setTitle("Assignments Page");
        Container contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[668,fill]",
            // rows
            "[15]" +
            "[11]" +
            "[]" +
            "[]" +
            "[523]"));

        //---- label1 ----
        label1.setText("Course Name");
        label1.setFont(new Font("Geneva", Font.PLAIN, 16));
        contentPane.add(label1, "cell 0 0,align center top,grow 0 0");

        //======== panel1 ========
        {

            // JFormDesigner evaluation mark

            panel1.setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "[180,fill]" +
                "[180,fill]" +
                "[180,fill]" +
                "[175,fill]",
                // rows
                "[]" +
                "[]"));

            //---- button1 ----
            button1.setText("Return to Course Page");
            button1.setFont(new Font("Geneva", Font.PLAIN, 11));
            panel1.add(button1, "cell 0 1");

            //---- button2 ----
            button2.setText("Add New Assigment");
            button2.setFont(new Font("Geneva", Font.BOLD, 11));
            panel1.add(button2, "cell 1 1");

            //---- button3 ----
            button3.setText("Delete Assignment");
            button3.setFont(new Font("Geneva", Font.PLAIN, 11));
            panel1.add(button3, "cell 2 1");

            //---- button4 ----
            button4.setText("Modify Assignment");
            button4.setFont(new Font("Geneva", Font.BOLD, 11));
            panel1.add(button4, "cell 3 1");
        }
        contentPane.add(panel1, "cell 0 1 1 2");

        //---- label2 ----
        label2.setText("Assignments");
        label2.setFont(new Font("Geneva", Font.BOLD, 14));
        contentPane.add(label2, "cell 0 2,alignx center,growx 0");

        //---- label3 ----
        label3.setText("Assignments");
        label3.setFont(new Font("Geneva", Font.PLAIN, 13));
        contentPane.add(label3, "cell 0 3,alignx center,growx 0");

        //======== scrollPane1 ========
        {

            //---- list1 ----
            list1.setBackground(Color.lightGray);
            scrollPane1.setViewportView(list1);
        }
        contentPane.add(scrollPane1, "cell 0 4,grow");
        pack();
        setLocationRelativeTo(getOwner());
        this.setSize(700,700);
        this.setVisible(true);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Aysha Panatch
    private JLabel label1;
    private JPanel panel1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JLabel label2;
    private JLabel label3;
    private JScrollPane scrollPane1;
    private JList list1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public static void main(String[] args) {
        ManageAssignment obj = new ManageAssignment();
    }

}

