package data.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Mail {
    private String sender;

    private String recipient;

    private String title;

    private String body;

    LocalDate date = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd");

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public LocalDate getDate() {
        return date;
    }




        @Override
        public String toString() {
            return String.format("""
                        Date: %s
                        Sender: %s
                        Recipient: %s
                        Title : %s
                        Body: %s""",
                    getDate(), getSender(), getRecipient(), getTitle(), getBody());
    }
}
