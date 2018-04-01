import java.awt.*;
import javax.swing.*;
import net.miginfocom.swing.*;
/*
 * Created by JFormDesigner on Sun Apr 01 10:38:14 MDT 2018
 */



/**
 * @author Aysha Panatch
 */
public class LoginWindow extends JFrame {
    public LoginWindow() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Aysha Panatch
        label4 = new JLabel();
        label1 = new JLabel();
        panel1 = new JPanel();
        label5 = new JLabel();
        textField1 = new JTextField();
        panel2 = new JPanel();
        label6 = new JLabel();
        passwordField1 = new JPasswordField();
        button1 = new JButton();

        //======== this ========
        setBackground(new Color(51, 102, 255));
        setTitle("Login Window");
        Container contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[fill]" +
            "[343,fill]",
            // rows
            "[]" +
            "[32]" +
            "[58]0" +
            "[70]" +
            "[]"));

        //---- label4 ----
        label4.setText("LOGIN TO PLATFORM:");
        label4.setFont(new Font("Geneva", Font.BOLD, 20));
        contentPane.add(label4, "cell 1 1");
        contentPane.add(label1, "cell 1 1");

        //======== panel1 ========
        {


            panel1.setLayout(new MigLayout(
                "hidemode 3,aligny bottom",
                // columns
                "[119,fill]" +
                "[288,fill]",
                // rows
                "[]0" +
                "[39]0"));

            //---- label5 ----
            label5.setText("Username:");
            label5.setFont(new Font("Geneva", Font.PLAIN, 15));
            panel1.add(label5, "cell 0 1");

            //---- textField1 ----
            textField1.setBackground(Color.lightGray);
            panel1.add(textField1, "cell 1 1 12 1");
        }
        contentPane.add(panel1, "cell 1 2");

        //======== panel2 ========
        {
            panel2.setLayout(new MigLayout(
                "hidemode 3,aligny top",
                // columns
                "[68,fill]" +
                "[234,fill]",
                // rows
                "0[]0"));

            //---- label6 ----
            label6.setText("Password:");
            label6.setFont(new Font("Geneva", Font.PLAIN, 15));
            panel2.add(label6, "cell 0 0");

            //---- passwordField1 ----
            passwordField1.setBackground(Color.lightGray);
            panel2.add(passwordField1, "cell 1 0 12 1");
        }
        contentPane.add(panel2, "cell 1 3");

        //---- button1 ----
        button1.setText("OK");
        button1.setBackground(Color.darkGray);
        button1.setFont(new Font("Geneva", Font.PLAIN, 12));
        contentPane.add(button1, "cell 1 4,align center center,grow 0 0");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        this.setVisible(true);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Aysha Panatch
    private JLabel label4;
    private JLabel label1;
    private JPanel panel1;
    private JLabel label5;
    private JTextField textField1;
    private JPanel panel2;
    private JLabel label6;
    private JPasswordField passwordField1;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables


    public static void main(String[] args) {
        LoginWindow obj = new LoginWindow();
    }
}