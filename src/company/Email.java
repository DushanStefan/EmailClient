package company;

import java.io.Serializable;

public class Email implements Serializable {
    private String emailAddress;
    private String subject;
    private String content;
    private String date;

    public Email(String emailAddress, String subject, String content, String date) {
        this.emailAddress = emailAddress;
        this.subject = subject;
        this.content = content;
        this.date = date;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getSubject() {
        return subject;
    }

    public String getContent() {
        return content;
    }

    public String getDate() {
        return date;
    }
}
