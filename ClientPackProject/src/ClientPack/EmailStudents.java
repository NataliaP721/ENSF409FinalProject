package ClientPack;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.*;

import SharedDataObjects.*;
import net.miginfocom.swing.*;
import org.apache.commons.mail.*;

/*
 * Created by JFormDesigner on Sun Apr 01 12:19:26 MDT 2018
 */



/**
 * @author Aysha Panatch
 */
public class EmailStudents extends JFrame implements ActionListener {
    EmailStudents(ObjectInputStream in, ObjectOutputStream out, Course course, User prof) {
        this.in = in;
        this.out = out;
        this.course = course;
        this.prof = prof;
        initComponents();
        search.addActionListener(this);
        addAll.addActionListener(this);
        addRecipient.addActionListener(this);
        back.addActionListener(this);
        ButtonGroup group= new ButtonGroup();
        group.add(lastNameradioButton);
        group.add(IDradioButton);
        this.setupMail();
        this.setSize(700, 700);
        this.setVisible(true);

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Aysha Panatch
        panel2 = new JPanel();
        panel3 = new JPanel();
        back = new JButton();
        panel5 = new JPanel();
        label5 = new JLabel();
        panel4 = new JPanel();
        label10 = new JLabel();
        IDradioButton = new JRadioButton();
        lastNameradioButton = new JRadioButton();
        label11 = new JLabel();
        searchparameter = new JTextField();
        search = new JButton();
        scrollPane5 = new JScrollPane();
        studentList = new JList();
        addAll = new JButton();
        addRecipient = new JButton();
        panel1 = new JPanel();
        label1 = new JLabel();
        to = new JTextField();
        label4 = new JLabel();
        from = new JTextField();
        label2 = new JLabel();
        subject = new JTextField();
        jlabel4 = new JLabel();
        attach = new JButton();
        send = new JButton();
        scrollPane2 = new JScrollPane();
        content = new JTextArea();

        //======== this ========
        setTitle("Email Students");
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
                "[fill]" +
                "[grow,fill]" +
                "[381,grow,fill]",
                // rows
                "[]" +
                "[]" +
                "[]"));

            //======== panel3 ========
            {
                panel3.setBackground(new Color(115, 194, 251));
                panel3.setLayout(new MigLayout(
                    "hidemode 3",
                    // columns
                    "0[]0",
                    // rows
                    "0[]0"));

                //---- back ----
                back.setText("Back");
                back.setBackground(Color.white);
                back.setForeground(Color.black);
                panel3.add(back, "cell 0 0,align left top,grow 0 0");
            }
            panel2.add(panel3, "cell 1 0,align left top,grow 0 0");

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
                    "[fill]0" +
                    "[fill]0",
                    // rows
                    "0[fill]0"));

                //---- label5 ----
                label5.setText("Email Students");
                label5.setBackground(new Color(115, 194, 251));
                label5.setForeground(Color.black);
                label5.setHorizontalAlignment(SwingConstants.RIGHT);
                label5.setFont(new Font(".SF NS Text", Font.BOLD, 26));
                panel5.add(label5, "cell 13 0");
            }
            panel2.add(panel5, "cell 2 0");

            //======== panel4 ========
            {
                panel4.setBackground(new Color(115, 194, 251));
                panel4.setLayout(new MigLayout(
                    "hidemode 3",
                    // columns
                    "0[307,fill]0",
                    // rows
                    "0[35]" +
                    "[27]" +
                    "[]" +
                    "[]" +
                    "[445]" +
                    "[]0"));

                //---- label10 ----
                label10.setText("Search By:");
                label10.setFont(new Font("Geneva", Font.PLAIN, 15));
                label10.setForeground(Color.black);
                label10.setBackground(new Color(115, 194, 251));
                panel4.add(label10, "cell 0 0");

                //---- IDradioButton ----
                IDradioButton.setText("ID");
                IDradioButton.setBackground(new Color(115, 194, 251));
                IDradioButton.setForeground(Color.black);
                IDradioButton.setFont(IDradioButton.getFont().deriveFont(IDradioButton.getFont().getSize() + 1f));
                panel4.add(IDradioButton, "cell 0 1");

                //---- lastNameradioButton ----
                lastNameradioButton.setText("Last Name");
                lastNameradioButton.setBackground(new Color(115, 194, 251));
                lastNameradioButton.setForeground(Color.black);
                lastNameradioButton.setFont(lastNameradioButton.getFont().deriveFont(lastNameradioButton.getFont().getSize() + 1f));
                panel4.add(lastNameradioButton, "cell 0 1");

                //---- label11 ----
                label11.setText("Enter Search Parameter:");
                label11.setFont(label11.getFont().deriveFont(label11.getFont().getStyle() & ~Font.ITALIC, label11.getFont().getSize() + 2f));
                label11.setForeground(Color.black);
                panel4.add(label11, "cell 0 2");

                //---- searchparameter ----
                searchparameter.setBackground(Color.white);
                panel4.add(searchparameter, "cell 0 3 12 1");

                //---- search ----
                search.setText("Search");
                search.setFont(new Font(".SF NS Text", Font.PLAIN, 14));
                search.setBackground(Color.white);
                search.setForeground(Color.black);
                panel4.add(search, "cell 0 3 12 1,alignx right,growx 0");

                //======== scrollPane5 ========
                {

                    //---- studentList ----
                    studentList.setBackground(Color.lightGray);
                    studentList.setForeground(Color.black);
                    scrollPane5.setViewportView(studentList);
                }
                panel4.add(scrollPane5, "cell 0 4,grow");

                //---- addAll ----
                addAll.setText("Add All");
                addAll.setFont(new Font(".SF NS Text", Font.PLAIN, 14));
                addAll.setBackground(Color.white);
                addAll.setForeground(Color.black);
                panel4.add(addAll, "cell 0 5");

                //---- addRecipient ----
                addRecipient.setText("Add Recipient");
                addRecipient.setFont(new Font(".SF NS Text", Font.PLAIN, 14));
                addRecipient.setBackground(Color.white);
                addRecipient.setForeground(Color.black);
                panel4.add(addRecipient, "cell 0 5");
            }
            panel2.add(panel4, "cell 1 1,grow");

            //======== panel1 ========
            {
                panel1.setBackground(new Color(115, 194, 251));
                panel1.setLayout(new MigLayout(
                    "hidemode 3",
                    // columns
                    "5[370,fill]0",
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

                //---- attach ----
                attach.setText("Attach");
                attach.setForeground(Color.black);
                attach.setBackground(Color.white);
                panel1.add(attach, "cell 0 5");

                //---- send ----
                send.setText("Send");
                send.setBackground(Color.white);
                send.setForeground(Color.black);
                panel1.add(send, "cell 0 5");

                //======== scrollPane2 ========
                {

                    //---- content ----
                    content.setBackground(Color.white);
                    content.setForeground(Color.white);
                    scrollPane2.setViewportView(content);
                }
                panel1.add(scrollPane2, "cell 0 6,grow");
            }
            panel2.add(panel1, "cell 2 1,aligny top,growy 0");
        }
        contentPane.add(panel2, "cell 0 0");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Aysha Panatch
    private JPanel panel2;
    private JPanel panel3;
    private JButton back;
    private JPanel panel5;
    private JLabel label5;
    private JPanel panel4;
    private JLabel label10;
    private JRadioButton IDradioButton;
    private JRadioButton lastNameradioButton;
    private JLabel label11;
    private JTextField searchparameter;
    private JButton search;
    private JScrollPane scrollPane5;
    private JList studentList;
    private JButton addAll;
    private JButton addRecipient;
    private JPanel panel1;
    private JLabel label1;
    private JTextField to;
    private JLabel label4;
    private JTextField from;
    private JLabel label2;
    private JTextField subject;
    private JLabel jlabel4;
    private JButton attach;
    private JButton send;
    private JScrollPane scrollPane2;
    private JTextArea content;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    private ObjectOutputStream out;
    private ObjectInputStream in;
    private Course course;
    private User prof;
    private MultiPartEmail email;
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
        } else if(e.getSource() == search) {

        } else if(e.getSource() == addAll) {
            addRecipient.setEnabled(false);
        } else if(e.getSource() == addRecipient) {

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

}
