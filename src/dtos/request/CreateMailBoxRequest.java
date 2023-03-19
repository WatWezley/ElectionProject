package dtos.request;

import data.models.Mail;

import java.util.ArrayList;

public class CreateMailBoxRequest {

    private String userName;

    private static ArrayList<Mail> inbox = new ArrayList<>();

    private static ArrayList<Mail> outbox = new ArrayList<>();



    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public ArrayList<Mail> getInbox() {
        return inbox;
    }

    public ArrayList<Mail> getOutbox() {
        return outbox;
    }


    }
