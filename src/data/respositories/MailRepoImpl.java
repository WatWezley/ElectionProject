package data.respositories;

import data.models.Mail;
import data.models.MailBox;

import java.util.List;

public class MailRepoImpl implements MailRepo {

    MailBoxRepoImpl mailBoxRepoImpl = new MailBoxRepoImpl();

    MailBox mailBox = new MailBox();

    int inboxCount;

    int outboxCount ;

    int draftCount ;


    @Override
    public Mail save(Mail mail, String sender, String recipient) {
        saveInbox(recipient,mail,mailBoxRepoImpl);
        saveOutBox(sender,recipient,mail);
        saveDraft(sender,recipient,mail);
        return mail;
    }

    public void saveInbox(String recipient, Mail mail, MailBoxRepoImpl mailBoxRepoImpl) {
        for (MailBox mailbox : mailBoxRepoImpl.mailBoxes) {
            if(mailbox.getMailName().equalsIgnoreCase(recipient)){
                mailbox.getMailBox().get(0).add(mail);
                System.out.println(mailbox.getMailBox().get(0));
                break;
            }
        }
    }

    public void saveOutBox(String sender,String recipient, Mail mail) {
        for (MailBox mailbox2 : mailBoxRepoImpl.mailBoxes) {
            if(mailbox2.getMailName().equalsIgnoreCase(sender)& recipient!= null){
                System.out.println(mailbox2.getMailBox().get(0));
                mailbox2.getMailBox().get(1).add(mail);
                System.out.println(mailbox2.getMailBox().get(1).toString());
                break;
            }}
    }

    public void saveDraft(String recipient, String sender, Mail mail) {
        for (MailBox mailbox : mailBoxRepoImpl.mailBoxes) {
            if (mailbox.getMailName().equalsIgnoreCase(sender)&& recipient==null) {
               mailbox.getMailBox().get(2).add(mail);
                break;
            }}}

    @Override
    public Mail findByRecipient(String recipient, String mailName, Mail mail) {
        MailBox mailBox=mailBoxRepoImpl.findByMailName(mailName);
        for(Object mail2: mailBox.getMailBox().get(0)){
            if(mail2.equals(mail)&& mail.getRecipient().equalsIgnoreCase(recipient)){
                return mail;
            }
        }

        return null;
    }

    @Override
    public Mail findBySender(String sender, String mailName, Mail mail) {
        MailBox mailBox= mailBoxRepoImpl.findByMailName(mailName);
        for(Object mail2: mailBox.getMailBox().get(1)){
            if(mail2.equals(mail)&& mail.getRecipient().equalsIgnoreCase(sender)){
                return mail;
            }
        }
        return null;
    }


    public long inboxSize(String mailName) {
        mailBox = mailBoxRepoImpl.findByMailName(mailName);
        inboxCount= mailBox.getMailBox().get(0).size();
        return inboxCount;
    }


    public long outboxSize(String mailName) {
        mailBox= mailBoxRepoImpl.findByMailName(mailName);
        outboxCount= mailBox.getMailBox().get(1).size();
        return outboxCount;
    }


    public long draftSize(String mailName) {
        MailBox mailBox= mailBoxRepoImpl.findByMailName(mailName);
        draftCount= mailBox.getMailBox().get(2).size();
        return draftCount;
    }



    @Override
    public List<Mail> findAll() {
        return null;
    }

    @Override
    public void deleteBySender(String sender) {

    }

    @Override
    public void deleteBtRecipient(String recipient) {

    }

    @Override
    public void deleteAll() {

    }
}
