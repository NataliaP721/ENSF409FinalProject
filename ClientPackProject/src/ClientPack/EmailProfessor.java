/*
 * Created by JFormDesigner on Sat Apr 07 23:51:00 MDT 2018
 */

package ClientPack;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.*;
import net.miginfocom.swing.*;
import SharedDataObjects.*;
import org.apache.commons.mail.*;


/**
 * Creates a page where the student can email their course's professor.
 * @author Aysha Panatch
 * ObjectInputStream in, ObjectOutputStream out, Course course, User student
 */
public class EmailProfessor extends JFrame implements ActionListener {
    EmailProfessor(ObjectInputStream in, ObjectOutputStream out, Course course, User student) {
        this.in = in;
        this.out = out;
        this.course = course;
        this.student = student;
        initComponents();
        back.addActionListener(this);
        send.addActionListener(this);
        attach.addActionListener(this);
        //USE THE DATABASE TO FIND THE PROF EMAIL USING THE PROF ID IN COURSE THEN SET THE TEXT BELOW
        to.setText("");
        this.setSize(700, 700);
        this.setVisible(true);
        this.setupMail();
        //this.from.setText(student.getUserEmail());
    }

    /**
     * Intialises and creates the GUI.
     */
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Aysha Panatch
        panel2 = new JPanel();
        panel5 = new JPanel();
        back = new JButton();
        send = new JButton();
        label5 = new JLabel();
        panel1 = new JPanel();
        label1 = new JLabel();
        to = new JTextField();
        label4 = new JLabel();
        from = new JTextField();
        label2 = new JLabel();
        subject = new JTextField();
        jlabel4 = new JLabel();
        attach = new JButton();
        scrollPane2 = new JScrollPane();
        content = new JTextArea();

        //======== this ========
        setTitle("Email Professor");
        setBackground(new Color(115, 194, 251));
        Container contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "0[700,grow,fill]0",
            // rows
            "0[700,grow,fill]0"));

        //======== panel2 ========
        {
            panel2.setBackground(new Color(115, 194, 251));

            // JFormDesigner evaluation mark
            panel2.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                    "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                    javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                    java.awt.Color.red), panel2.getBorder())); panel2.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

            panel2.setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "[381,grow,fill]",
                // rows
                "[]" +
                "[]" +
                "[]"));

            //======== panel5 ========
            {
                panel5.setBackground(new Color(115, 194, 251));
                panel5.setLayout(new MigLayout(
                    "hidemode 3",
                    // columns
                    "[]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]0" +
                    "[fill]15",
                    // rows
                    "0[fill]0"));

                //---- back ----
                back.setText("Back");
                back.setBackground(Color.white);
                back.setForeground(Color.black);
                panel5.add(back, "cell 0 0,align left top,grow 0 0");

                //---- send ----
                send.setText("Send");
                send.setBackground(Color.white);
                send.setForeground(Color.black);
                panel5.add(send, "cell 3 0,align left top,grow 0 0");

                //---- label5 ----
                label5.setText("Email Professor");
                label5.setBackground(new Color(115, 194, 251));
                label5.setForeground(Color.black);
                label5.setHorizontalAlignment(SwingConstants.RIGHT);
                label5.setFont(new Font(".SF NS Text", Font.BOLD, 26));
                panel5.add(label5, "cell 15 0");
            }
            panel2.add(panel5, "cell 0 0");

            //======== panel1 ========
            {
                panel1.setBackground(new Color(115, 194, 251));
                panel1.setLayout(new MigLayout(
                    "hidemode 3",
                    // columns
                    "5[843,fill]0",
                    // rows
                    "0[22]" +
                    "[0]" +
                    "[]" +
                    "[]" +
                    "[0]" +
                    "[]" +
                    "[624]0"));

                //---- label1 ----
                label1.setText("To:");
                label1.setFont(new Font("Geneva", Font.PLAIN, 13));
                label1.setBackground(new Color(115, 194, 251));
                label1.setForeground(Color.black);
                panel1.add(label1, "cell 0 0,alignx left,growx 0");

                //---- to ----
                to.setBackground(Color.white);
                panel1.add(to, "cell 0 0");

                //---- label4 ----
                label4.setText("From:");
                label4.setFont(new Font("Geneva", Font.PLAIN, 13));
                label4.setForeground(Color.black);
                label4.setBackground(new Color(115, 194, 251));
                panel1.add(label4, "cell 0 2,alignx left,growx 0");

                //---- from ----
                from.setBackground(Color.white);
                panel1.add(from, "cell 0 2");

                //---- label2 ----
                label2.setText("Subject:");
                label2.setFont(new Font("Geneva", Font.PLAIN, 13));
                label2.setBackground(new Color(115, 194, 251));
                label2.setForeground(Color.black);
                panel1.add(label2, "cell 0 3,alignx left,growx 0");

                //---- subject ----
                subject.setBackground(Color.white);
                panel1.add(subject, "cell 0 3");

                //---- jlabel4 ----
                jlabel4.setText("Content:");
                jlabel4.setFont(new Font("Geneva", Font.PLAIN, 13));
                jlabel4.setBackground(new Color(115, 194, 251));
                jlabel4.setForeground(Color.black);
                panel1.add(jlabel4, "cell 0 5,aligny top,growy 0");

                //---- attach ----
                attach.setText("Attach");
                attach.setBackground(Color.white);
                attach.setForeground(Color.black);
                panel1.add(attach, "cell 0 5,alignx right,growx 0");

                //======== scrollPane2 ========
                {

                    //---- content ----
                    content.setBackground(Color.white);
                    scrollPane2.setViewportView(content);
                }
                panel1.add(scrollPane2, "cell 0 6,grow");
            }
            panel2.add(panel1, "cell 0 1,aligny top,growy 0");
        }
        contentPane.add(panel2, "cell 0 0");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Aysha Panatch
    private JPanel panel2;
    private JPanel panel5;
    private JButton back;
    private JButton send;
    private JLabel label5;
    private JPanel panel1;
    private JLabel label1;
    private JTextField to;
    private JLabel label4;
    private JTextField from;
    private JLabel label2;
    private JTextField subject;
    private JLabel jlabel4;
    private JButton attach;
    private JScrollPane scrollPane2;
    private JTextArea content;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    /**
     * The frame is the main frame of the GUI.
     * The panel, scrollpanes and labels fields help with the formatting of the GUI.
     * content is the JTextArea where the student can enter their message.
     * Each JButton is named the action that executed when they are pressed.
     * course stores the course using the GUI.
     * in and out are ObjectStreams used to help send data to the server from the client.
     * visible is the boolean indicating whether the frame is visible.
     */

    private ObjectInputStream in;
    private ObjectOutputStream out;
    private Course course;
    private User student;
    private User prof;
    private MultiPartEmail email;
    /**
     * Generates the correct response/actions depending on what buttons the professor clicks.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            this.dispose();
        } else if (e.getSource() == send) {
            try {
                email.setSubject(subject.getText());
                email.setMsg(content.getText());

                email.send();

                JOptionPane.showMessageDialog(this, "Email sent!");
            }
            catch(EmailException f) {
                f.printStackTrace();
            }
        } else if(e.getSource() == attach) {
            JFileChooser fileBrowser = new JFileChooser();
            File selectedFile;
            if(fileBrowser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                selectedFile = fileBrowser.getSelectedFile();
                EmailAttachment attachment = new EmailAttachment();
                attachment.setPath(selectedFile.getAbsolutePath());
                attachment.setDisposition(EmailAttachment.ATTACHMENT);
                attachment.setDescription("Attachment");
                attachment.setName(selectedFile.getName());
                try {
                    email.attach(attachment);
                }
                catch(EmailException f) {
                    f.printStackTrace();
                }
            }
        }
    }
    private void setupMail() {

        String myEmailId = "ensf409proffessoremail@gmail.com";
        String myPassword = "ensf409finalproject";
        String senderId = "eddyg0303@gmail.com";
        try {
            email = new MultiPartEmail();
            email.setSmtpPort(587);
            email.setAuthenticator(new DefaultAuthenticator(myEmailId, myPassword));
            email.setDebug(true);
            email.setHostName("smtp.gmail.com");
            email.setFrom(myEmailId);
            email.addTo(senderId);
            to.setText(senderId);
            to.setEditable(false);
            from.setText(myEmailId);
            from.setEditable(false);
            email.setTLS(true);
        }
        catch(EmailException e) {
            e.printStackTrace();
        }
    }
//    public static void main(String[] args) {
//
//        EmailProfessor mail  = new EmailProfessor(null,  null, null, null);
//    }
}