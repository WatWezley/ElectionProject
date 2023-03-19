package data.models;

import java.util.ArrayList;
import java.util.List;

public class MailBox {

    private int id;

    private String userName;

    private static List<Mail> inbox = new ArrayList<>();

    private static List<Mail> outbox= new ArrayList<>();

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

    public void setInbox(Mail mail) {
        MailBox.inbox.add(mail);
    }

    public List<Mail> getInbox() {
        return inbox;
    }


    public List<Mail> getOutbox() {
        return outbox;
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


