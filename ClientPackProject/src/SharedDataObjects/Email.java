package SharedDataObjects;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Represents an email with all it's corresponding fields of information that is sent between client and server as a Serialized object.
 * @author  Natalia Pavlovic, Aysha Panatch, Eddy Gu
 * @version 2.0
 * @since April 11, 2018
 */

public class Email implements Serializable{
    /**
     * from email, to emails, email subject, and email content are all fields of data about the email.
     * command is the command sent to the server so the server knows what to execute according to what the user does in the GUI.
     */
    private String from;
    private ArrayList<String> to;
    private String emailSubject;
    private String emailContent;
    private String command;

    public Email(String from, ArrayList<String> to, String emailSubject, String emailContent) {
        this.from = from;
        this.to = to;
        this.emailSubject = emailSubject;
        this.emailContent = emailContent;
        this.command = null;
    }
    /**
     * Listed below are helper methods that help us retrieve certain fields and data from the Assignment object.
     */
    public String getfrom(){
        return this.from;
    }
    public ArrayList<String> getTo(){
        return this.to;
    }
    public String getEmailSubject(){
        return this.emailSubject;
    }
    public String getEmailContent() {
        return this.emailContent;
    }
    public String getCommand() {
        return this.command;
    }
}
