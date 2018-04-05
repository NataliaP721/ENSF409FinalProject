package ClientPack;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.*;
import net.miginfocom.swing.*;
import SharedDataObjects.*;
import java.io.IOException;

/*
 * Created by JFormDesigner on Sun Apr 01 10:38:14 MDT 2018
 */



/**
 * @author Aysha Panatch
 */
public class LoginWindow extends JFrame implements ActionListener{
    public LoginWindow(ObjectInputStream in, ObjectOutputStream out) {
        this.out = out;
        this.in = in;
        initComponents();
        ok.addActionListener(this);
        this.setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Edward Gu
        panel3 = new JPanel();
        loginPrompt = new JLabel();
        label1 = new JLabel();
        panel1 = new JPanel();
        warning = new JLabel();
        usernamePrompt = new JLabel();
        username = new JTextField();
        panel2 = new JPanel();
        passwordPrompt = new JLabel();
        password = new JPasswordField();
        ok = new JButton();

        //======== this ========
        setBackground(new Color(51, 102, 255));
        setTitle("Login Window");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Container contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "0[fill]0" +
            "[343,fill]0",
            // rows
            "0[1]0" +
            "[32]50" +
            "[58]0" +
            "[70]0" +
            "[]0" +
            "[45]0"));

        //======== panel3 ========
        {
            panel3.setBackground(Color.black);

            // JFormDesigner evaluation mark
            panel3.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                    "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                    javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                    java.awt.Color.red), panel3.getBorder())); panel3.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

            panel3.setLayout(new MigLayout(
                "fill,hidemode 3,alignx right",
                // columns
                "0[330,grow,fill]0",
                // rows
                "[]" +
                "[]" +
                "[]" +
                "[77]0"));

            //---- loginPrompt ----
            loginPrompt.setText("   LOGIN TO !D2L:");
            loginPrompt.setFont(new Font(".SF NS Text", Font.BOLD, 20));
            loginPrompt.setForeground(Color.white);
            panel3.add(loginPrompt, "cell 0 0,alignx center,growx 0");
            panel3.add(label1, "cell 0 0");

            //======== panel1 ========
            {
                panel1.setBackground(Color.black);
                panel1.setLayout(new MigLayout(
                    "hidemode 3,aligny bottom",
                    // columns
                    "[84,fill]5" +
                    "[232,fill]14",
                    // rows
                    "[]" +
                    "[]0" +
                    "[39]0"));

                //---- warning ----
                warning.setBackground(Color.black);
                warning.setForeground(Color.white);
                panel1.add(warning, "cell 1 0");

                //---- usernamePrompt ----
                usernamePrompt.setText("Username:");
                usernamePrompt.setFont(new Font(".SF NS Text", Font.PLAIN, 15));
                usernamePrompt.setForeground(Color.white);
                panel1.add(usernamePrompt, "cell 0 2");

                //---- username ----
                username.setBackground(Color.lightGray);
                panel1.add(username, "cell 1 2");
            }
            panel3.add(panel1, "cell 0 1");

            //======== panel2 ========
            {
                panel2.setBackground(Color.black);
                panel2.setLayout(new MigLayout(
                    "hidemode 3,aligny top",
                    // columns
                    "[68,fill]13" +
                    "[234,fill]",
                    // rows
                    "0[]0"));

                //---- passwordPrompt ----
                passwordPrompt.setText("Password:");
                passwordPrompt.setFont(new Font(".SF NS Text", Font.PLAIN, 15));
                passwordPrompt.setForeground(Color.white);
                panel2.add(passwordPrompt, "cell 0 0");

                //---- password ----
                password.setBackground(Color.lightGray);
                panel2.add(password, "cell 1 0 12 1");
            }
            panel3.add(panel2, "cell 0 2");

            //---- ok ----
            ok.setText("OK");
            ok.setBackground(Color.black);
            ok.setFont(new Font(".SF NS Text", Font.PLAIN, 14));
            ok.setForeground(Color.black);
            panel3.add(ok, "cell 0 3,align center center,grow 0 0");
        }
        contentPane.add(panel3, "cell 0 0 2 6,grow");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        this.setVisible(true);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Edward Gu
    private JPanel panel3;
    private JLabel loginPrompt;
    private JLabel label1;
    private JPanel panel1;
    private JLabel warning;
    private JLabel usernamePrompt;
    private JTextField username;
    private JPanel panel2;
    private JLabel passwordPrompt;
    private JPasswordField password;
    private JButton ok;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    private ObjectInputStream in;
    private ObjectOutputStream out;

//    public static void main(String[] args) { //DONT DELETE YET
//        LoginWindow obj = new LoginWindow();
//    }


    public JLabel getWarning() {
        return warning;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == ok) {
            int user = Integer.parseInt(username.getText());
            username.setText("");
            String pass = password.getText();
            password.setText("");
            LoginInfo info = new LoginInfo(user, pass);
            try {
                out.writeObject(info);
            } catch (IOException f) {
                System.err.println("oops");
                System.exit(1);
            }
        }
    }
}