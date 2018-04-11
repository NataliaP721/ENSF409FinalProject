/*
 * Created by JFormDesigner on Sat Apr 07 23:51:00 MDT 2018
 */

package ClientPack;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;
import net.miginfocom.swing.*;
import SharedDataObjects.*;

/**
 * Creates a page where the student can email their course's professor.
 * @author Aysha Panatch
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
        //USE THE DATABASE TO FIND THE PROF EMAIL USING THE PROF ID IN COURSE THEN SET THE TEXT BELOW
        to.setText("");
        this.setSize(700, 700);
        this.setVisible(true);
        this.setupMail();
        this.from.setText(student.getUserEmail());
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
                            java.awt.Color.red), panel2.getBorder()));
            panel2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
                public void propertyChange(java.beans.PropertyChangeEvent e) {
                    if ("border".equals(e.getPropertyName())) throw new RuntimeException();
                }
            });

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
                                "[fill]0",
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
                panel5.add(send, "cell 2 0");

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
                        "5[644,fill]0",
                        // rows
                        "0[22]" +
                                "[0]" +
                                "[]" +
                                "[]" +
                                "[0]" +
                                "[]" +
                                "[479]0"));

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

                //======== scrollPane2 ========
                {

                    //---- content ----
                    content.setBackground(Color.white);
                    content.setForeground(Color.white);
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
    private Properties properties;
    private Session session;
    private User student;
    private User prof;
    private Message message;

    /**
     * Generates the correct response/actions depending on what buttons the professor clicks.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            this.dispose();
        } else if (e.getSource() == send) {
            try {
                message.setSubject(subject.getText());
                message.setText(content.getText());

                Transport.send(message);
            }
            catch(MessagingException f) {
                f.printStackTrace();
            }

        }
    }
    private void setupMail() {
        properties = new Properties();
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(student.getUserEmail(), "1111");
            }
        });
        try {
            message = new MimeMessage(session);
            message.setFrom(new InternetAddress(student.getUserEmail()));
        }
        catch(MessagingException e) {
            e.printStackTrace();
        }

        course.setCommand("GETPROF");
        try {
            out.writeObject(course);
            out.reset();
            prof = (User)in.readObject();
        }
        catch(ClassNotFoundException f) {
            f.printStackTrace();
        }
        catch(IOException g) {
            g.printStackTrace();
        }
        to.setText(prof.getUserEmail());
    }
}
