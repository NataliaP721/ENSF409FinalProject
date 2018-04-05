package SharedDataObjects;

import java.io.Serializable;
import java.util.ArrayList;

public class Email implements Serializable{
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
    // Helper methods
    // get
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
