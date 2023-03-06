package data.respositories;

import data.models.Mail;
import data.models.MailBox;

import java.util.ArrayList;
import java.util.List;

public class MailRepoImpl implements MailRepo {

    private final MailBoxRepoImpl mailBoxRepoImpl = new MailBoxRepoImpl();

    static MailBox mailBox = new MailBox();

    static Mail mail = new Mail();

    int inboxCount;

    int outboxCount ;

    int draftCount ;


    @Override
    public Mail save(Mail mail) {
        saveInbox(mail);
        saveOutBox(mail);
        saveDraft(mail);
        return mail;
    }

    public void saveInbox( Mail mail) {
        for (MailBox mailbox : MailBoxRepoImpl.mailBoxes) {
            if(mailbox.getMailName().equalsIgnoreCase(mail.getRecipient())){
                mailbox.getMailBox().get(0).add(mail);
                //System.out.println(mailbox.getMailBox().get(0));
                break;
            }
        }
    }

    public void saveOutBox(Mail mail) {
        for (MailBox mailbox2 : MailBoxRepoImpl.mailBoxes) {
            if(mailbox2.getMailName().equalsIgnoreCase(mail.getSender())){
                System.out.println(mailbox2.getMailBox().get(0));
                mailbox2.getMailBox().get(1).add(mail);
                //System.out.println(mailbox2.getMailBox().toString());
                break;
            }}
    }

    public void saveDraft( Mail mail) {
        MailBox mailBox = mailBoxRepoImpl.findByMailName(mail.getSender());
            if (mail.getRecipient() == null){
                mailBox.getMailBox().get(2).add(mail);}
    }

    @Override
    public Mail findByRecipient(String mailName, String recipient, Mail mail) {
        MailBox mailBox = mailBoxRepoImpl.findByMailName(mailName);
        for (var mailbox3 : mailBox.getMailBox().get(1)) {
                if (mailbox3.equals(mail)&&mail.getRecipient().equalsIgnoreCase(recipient)){
                    return (Mail) mailbox3;
                }

            }

        return null;
    }

    @Override
    public List<Mail> findBySender(String mailName, String sender, Mail mail) {
        List<Mail> queriedMails = new ArrayList<>();
        MailBox mailBox = mailBoxRepoImpl.findByMailName(mailName);
        ArrayList<Object>inbox= mailBox.getMailBox().get(0);
        System.out.println(inbox.size());
        for (Object o : inbox) {
            if (o.equals(mail) && mail.getSender().equalsIgnoreCase(sender)) {
                //for (var mail2 : inbox) {
                //if (mail2.equals(mail) && mail.getSender().equalsIgnoreCase(sender)) {
                queriedMails.add(mail);
                System.out.println(queriedMails);
                break;

                //System.out.println(mail2);
            }


        }

        return queriedMails;
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
    public ArrayList<ArrayList<Object>> findAll(String mailName) {
        MailBox mailBox= mailBoxRepoImpl.findByMailName(mailName);
        return mailBox.getMailBox();
    }

    @Override
    public void deleteBySender(String mailName,String sender) {
        MailBox mailBox = mailBoxRepoImpl.findByMailName(mailName);
        for (var mail2 : mailBox.getMailBox().get(0)) {
            if (mail2.equals(mail) && mail.getSender().equalsIgnoreCase(sender)) {
                System.out.println(mail2);
                mailBox.getMailBox().get(0).remove(mail2);
                inboxCount--;
            }

        }
    }

    @Override
    public void deleteBtRecipient(String mailName, String recipient) {
        MailBox mailBox = mailBoxRepoImpl.findByMailName(mailName);
        mailBox.getMailBox().get(1).removeIf(mailbox3 -> mailbox3.equals(mail) && mail.getRecipient().equalsIgnoreCase(recipient));
        outboxCount--;
    }

    @Override
    public void deleteAll(String mailName) {
        MailBox mailBox = mailBoxRepoImpl.findByMailName(mailName);
        mailBox.getMailBox().clear();
        inboxCount=0;
        outboxCount=0;
        draftCount=0;



    }
}
