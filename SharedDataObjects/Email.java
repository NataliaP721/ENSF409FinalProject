package SharedDataObjects;

import java.util.ArrayList;

public class Email {
    private String from;
    private ArrayList<String> to;
    private String emailSubject;
    private String emailContent;

    public Email(String from, ArrayList<String> to, String emailSubject, String emailContent) {
        this.from = from;
        this.to = to;
        this.emailSubject = emailSubject;
        this.emailContent = emailContent;
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
}
