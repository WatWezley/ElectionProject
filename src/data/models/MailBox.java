package data.models;

import java.util.ArrayList;

public class MailBox {

    private String mailName;

    public ArrayList<ArrayList<Object>> mailBox;



    public String getMailName() {
        return mailName;
    }

    public void setMailName(String mailName) {
        this.mailName = mailName;
    }

    public ArrayList<ArrayList<Object>> getMailBox() {
        return mailBox;
    }

    public void setMailBox() {
        mailBox = new ArrayList<>();
        mailBox.add(new ArrayList<>());
        mailBox.add(new ArrayList<>());
        mailBox.add(new ArrayList<>());
    }



    @Override
    public String toString() {
        return "MailBox{" +
                "mailName='" + mailName + '\'' +
                ", mailBox=" + mailBox +
                '}';
    }
}
