package data.models;

import java.util.List;

public class MailBox {

    private int id;

    private String userName;

    private List<Mail> inbox;

    private List<Mail> outbox;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Mail> getInbox() {
        return inbox;
    }

    public void setInbox(List<Mail> inbox) {
        this.inbox = inbox;
    }

    public List<Mail> getOutbox() {
        return outbox;
    }

    public void setOutbox(List<Mail> outbox) {
        this.outbox = outbox;
    }

    @Override
    public String toString() {
        return "MailBox{" +
                "id=" + id +
                ", username='" + userName + '\'' +
                ", inbox=" + inbox +
                ", outbox=" + outbox +
                '}';
    }
}


