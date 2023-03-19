package dtos.response;

import data.models.Mail;
import data.models.MailBox;

import java.util.ArrayList;

public class MailBoxResponse  {

    private int id ;

    private String userName;

    private  ArrayList<Mail> inbox;

    private  ArrayList<Mail> outbox;

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

    public ArrayList<Mail> getInbox() {
        return inbox;
    }

    public void setInbox(ArrayList<Mail> inbox) {
        this.inbox = inbox;
    }

    public ArrayList<Mail> getOutbox() {
        return outbox;
    }

    public void setOutbox(ArrayList<Mail> outbox) {
        this.outbox = outbox;
    }

    @Override
    public String toString() {
        return String.format("""
                Id : %s
                UserName : %s
                InboxMails : %s
                OutboxMails : %s
                """,getId(),getUserName(),getInbox(),getOutbox());

    }
}
