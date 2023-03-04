package data.models;

import java.time.LocalDateTime;

public class Mail {
    private String sender;

    private String recipient;

    private String title;

    private String body;

    private LocalDateTime date;

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

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Mail{" +
                "sender='" + sender + '\'' +
                ", recipient='" + recipient + '\'' +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", date=" + date +
                '}';
    }
}
