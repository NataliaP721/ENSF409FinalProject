import java.awt.*;
import javax.swing.*;
import net.miginfocom.swing.*;
/*
 * Created by JFormDesigner on Sun Apr 01 12:19:26 MDT 2018
 */



/**
 * @author Aysha Panatch
 */
public class EmailStudents extends JFrame {
    public EmailStudents() {
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
        panel1 = new JPanel();
        label1 = new JLabel();
        textField1 = new JTextField();
        label4 = new JLabel();
        textField3 = new JTextField();
        label2 = new JLabel();
        textField2 = new JTextField();
        label3 = new JLabel();
        scrollPane2 = new JScrollPane();
        textArea1 = new JTextArea();

        //======== this ========
        setTitle("Email Students");
        Container contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[250,fill]" +
            "[411,fill]",
            // rows
            "[649]"));

        //======== panel4 ========
        {

            // JFormDesigner evaluation mark

            panel4.setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "0[251,fill]0",
                // rows
                "[35]" +
                "[27]" +
                "[]" +
                "[]" +
                "[448]" +
                "[]"));

            //---- label10 ----
            label10.setText("Search By:");
            label10.setFont(new Font("Geneva", Font.PLAIN, 13));
            panel4.add(label10, "cell 0 0");

            //---- radioButton3 ----
            radioButton3.setText("ID");
            panel4.add(radioButton3, "cell 0 1");

            //---- radioButton4 ----
            radioButton4.setText("Last Name");
            panel4.add(radioButton4, "cell 0 1");

            //---- label11 ----
            label11.setText("Enter Search Parameter:");
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
            button5.setText("Add All");
            button5.setFont(new Font("Geneva", Font.PLAIN, 11));
            panel4.add(button5, "cell 0 5");

            //---- button6 ----
            button6.setText("Add Recipient");
            button6.setFont(button6.getFont().deriveFont(button6.getFont().getSize() - 2f));
            panel4.add(button6, "cell 0 5");
        }
        contentPane.add(panel4, "cell 0 0,grow");

        //======== panel1 ========
        {
            panel1.setBackground(Color.darkGray);
            panel1.setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "1[408,fill]0",
                // rows
                "[22]" +
                "[0]" +
                "[]" +
                "[]" +
                "[0]" +
                "[]" +
                "[481]"));

            //---- label1 ----
            label1.setText("To:");
            label1.setFont(new Font("Geneva", Font.PLAIN, 13));
            panel1.add(label1, "cell 0 0,alignx left,growx 0");

            //---- textField1 ----
            textField1.setBackground(Color.lightGray);
            panel1.add(textField1, "cell 0 0");

            //---- label4 ----
            label4.setText("From:");
            label4.setFont(new Font("Geneva", Font.PLAIN, 13));
            panel1.add(label4, "cell 0 2,alignx left,growx 0");

            //---- textField3 ----
            textField3.setBackground(Color.lightGray);
            panel1.add(textField3, "cell 0 2");

            //---- label2 ----
            label2.setText("Subject:");
            label2.setFont(new Font("Geneva", Font.BOLD, 13));
            panel1.add(label2, "cell 0 3,alignx left,growx 0");

            //---- textField2 ----
            textField2.setBackground(Color.lightGray);
            panel1.add(textField2, "cell 0 3");

            //---- label3 ----
            label3.setText("Content:");
            label3.setFont(new Font("Geneva", Font.PLAIN, 13));
            panel1.add(label3, "cell 0 5,aligny top,growy 0");

            //======== scrollPane2 ========
            {

                //---- textArea1 ----
                textArea1.setBackground(Color.lightGray);
                scrollPane2.setViewportView(textArea1);
            }
            panel1.add(scrollPane2, "cell 0 6,grow");
        }
        contentPane.add(panel1, "cell 1 0,aligny top,growy 0");
        pack();
        setLocationRelativeTo(getOwner());
        this.setSize(700,700);
        this.setVisible(true);
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
    private JPanel panel1;
    private JLabel label1;
    private JTextField textField1;
    private JLabel label4;
    private JTextField textField3;
    private JLabel label2;
    private JTextField textField2;
    private JLabel label3;
    private JScrollPane scrollPane2;
    private JTextArea textArea1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public static void main(String[] args) {
        EmailStudents obj = new EmailStudents();
    }
}
