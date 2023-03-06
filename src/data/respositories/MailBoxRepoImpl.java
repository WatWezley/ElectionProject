package data.respositories;

import data.models.Mail;
import data.models.MailBox;
import data.models.User;

import java.util.ArrayList;
import java.util.List;

public class MailBoxRepoImpl implements MailBoxRepo{

    static List<MailBox>mailBoxes = new ArrayList<>();
    static User user = new User();



    int count = 0;
    @Override
    public MailBox save(MailBox mailBox) {
        mailBox.setMailBox();
        mailBoxes.add(mailBox);
        count++;
        return mailBox;
    }

    @Override
    public MailBox findByMailName(String mailName) {
        for(var mails: mailBoxes){
            if(mails.getMailName().equalsIgnoreCase(mailName)){
                return mails;

            }
        }
        return null;
    }

    @Override
    public long count() {
        return count;
    }

    @Override
    public List<MailBox> findAll() {
        return mailBoxes;
    }

    @Override
    public void delete(String mailName) {
        mailBoxes.removeIf(mails -> mails.getMailName().equalsIgnoreCase(mailName));
        count--;
    }

    @Override
    public void deleteAll() {
        mailBoxes.clear();
        count=0;

    }
}
