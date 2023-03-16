package data.respositories;


import data.models.MailBox;

import java.util.ArrayList;
import java.util.List;

public class MailBoxRepoImpl implements MailBoxRepo{

     private static List<MailBox> mailBoxes = new ArrayList<>();

    int count = 0;

    @Override
    public MailBox save(MailBox mailBox) {
        boolean userHasNotBeenSaved = mailBox.getId() == 0;
        if (userHasNotBeenSaved) {
            mailBox.setId(generateId());
            mailBoxes.add(mailBox);
            count++;
            return mailBox;

        }
        return null;
    }

    private int generateId() {
        return count+1;
    }



    @Override
    public MailBox findById(int id) {
        for(MailBox mailBox2: mailBoxes){
            if(mailBox2.getId()==id){
                return mailBox2;
            }
        }
        return null;
    }

    @Override
    public MailBox findByMailName(String userName) {
        for(MailBox mailBox2: mailBoxes){
            if(mailBox2.getMailBoxName().equalsIgnoreCase(userName)){
              return mailBox2;
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
    public void delete(int id) {
        List<MailBox> toRemove = new ArrayList<>();
        for (MailBox mailBox2 : mailBoxes) {
            if (mailBox2.getId() == id) {
                toRemove.add(mailBox2);
                count--;
            }

        }mailBoxes.removeAll(toRemove);


    }

    @Override
    public void deleteAll() {
        mailBoxes.clear();
        count=0;


    }
}
