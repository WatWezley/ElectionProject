package dtos.response;

import data.models.Mail;
import data.models.MailBox;

import java.util.ArrayList;

public class MailBoxResponse extends MailBox {

    private int id ;

    private String userName;

    private  ArrayList<Mail> inBoxMails;

    private  ArrayList<Mail> outBoxMails;

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

    public ArrayList<Mail> getInBoxMails() {
        return inBoxMails;
    }

    public void setInBoxMails(ArrayList<Mail> inBoxMails) {
        this.inBoxMails = inBoxMails;
    }

    public ArrayList<Mail> getOutBoxMails() {
        return outBoxMails;
    }

    public void setOutBoxMails(ArrayList<Mail> outBoxMails) {
        this.outBoxMails = outBoxMails;
    }

    @Override
    public String toString() {
        return String.format("""
                Id : %s
                UserName : %s
                InboxMails : %s
                OutboxMails : %s
                """,getId(),getUserName(),getInBoxMails(),getOutBoxMails());

    }
}
