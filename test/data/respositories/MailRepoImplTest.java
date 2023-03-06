package data.respositories;

import data.models.Mail;
import data.models.MailBox;
import data.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class MailRepoImplTest {

    private static MailRepoImpl mailRepoImpl;


    private MailBoxRepoImpl mailBoxRepoImpl;

    private  Mail mail;

    @BeforeEach
    void setUp() {
        MailBox mailBox = new MailBox();
        mailBox.setMailName("ugokarl@regnos.com");
        mailBox.setMailBox();
        mailBoxRepoImpl = new MailBoxRepoImpl();
        mailBoxRepoImpl.save(mailBox);
        mailBox = new MailBox();
        mailBox.setMailName("favchi@regnos.com");
        mailBox.setMailBox();
        mailBoxRepoImpl.save(mailBox);
        mailBox = new MailBox();
        mailBox.setMailName("barachi@regnos.com");
        mailBox.setMailBox();
        mailBoxRepoImpl.save(mailBox);
        mail = new Mail();
        mail.setSender("ugokarl@regnos.com");
        mail.setRecipient("barachi@regnos.com");
        mail.setTitle("Java");
        mail.setBody("my java story starts here");
        mailRepoImpl = new MailRepoImpl();


    }


    @Test

    public void SavingOfMailCreated() {
        Mail firstMail = mailRepoImpl.save(mail);
        System.out.println(mailBoxRepoImpl.findByMailName("barachi@regnos.com").toString());
        assertEquals(1, mailRepoImpl.inboxSize("barachi@regnos.com"));
        assertEquals(1, mailRepoImpl.outboxSize("ugokarl@regnos.com"));

    }

    @Test
    public void saveAToDraftWhenRecipientIsNullTest() {
        Mail firstMail = mailRepoImpl.save(mail);
        mail = new Mail();
        mail.setSender("favchi@regnos.com");
        mail.setRecipient(null);
        mail.setTitle("Python");
        mail.setBody("this another journey of the seductress");
        mailRepoImpl.save(mail);
        assertEquals(1, mailRepoImpl.inboxSize("barachi@regnos.com"));
        assertEquals(1, mailRepoImpl.outboxSize("ugokarl@regnos.com"));
        assertEquals(1, mailRepoImpl.draftSize("favchi@regnos.com"));
    }

    @Test
    public void findMailByRecipientTest() {
        Mail firstMail = mailRepoImpl.save(mail);
        String result = """
                Date: 2023-03-05
                Sender: ugokarl@regnos.com
                Recipient: barachi@regnos.com
                Title : Java
                Body: my java story starts here""";
        assertEquals(result, mailRepoImpl.findByRecipient("ugokarl@regnos.com", "barachi@regnos.com", mail).toString());


    }

    @Test
    public void findMailBySenderTest() {
        Mail firstMail = mailRepoImpl.save(mail);
        mail = new Mail();
        mail.setSender("ugokarl@regnos.com");
        mail.setRecipient("barachi@regnos.com");
        mail.setTitle("DB");
        mail.setBody("managing my information");
        mailRepoImpl = new MailRepoImpl();
        Mail secondMail = mailRepoImpl.save(mail);
       // System.out.println(mailBoxRepoImpl.findByMailName("barachi@regnos.com").getMailBox());
        ArrayList<Mail> result = new ArrayList<>();
        result.add(firstMail);
        result.add(secondMail);
        assertEquals(result, mailRepoImpl.findBySender("barachi@regnos.com", "ugokarl@regnos.com",mail));

    }

    @Test
    public  void  findAllMails(){
        Mail firstMail = mailRepoImpl.save(mail);
        mail = new Mail();
        mail.setSender("barachi@regnos.com");
        mail.setRecipient(null);
        mail.setTitle("DB");
        mail.setBody("managing my information");
        mailRepoImpl = new MailRepoImpl();
        Mail secondMail = mailRepoImpl.save(mail);
        ArrayList<ArrayList<Mail>> allMails = new ArrayList<>();
        allMails.add(new ArrayList<>());
        allMails.add(new ArrayList<>());
        allMails.add(new ArrayList<>());
        allMails.get(1).add(firstMail);
        assertEquals(allMails,mailRepoImpl.findAll("ugokarl@regnos.com"));
    }

    @Test
    public void deleteBySender(){
        Mail firstMail = mailRepoImpl.save(mail);
        mail = new Mail();
        mail.setSender("favchi@regnos.com");
        mail.setRecipient("barachi@regnos.com");
        mail.setTitle("DB");
        mail.setBody("managing my information");
        mailRepoImpl = new MailRepoImpl();
        Mail secondMail = mailRepoImpl.save(mail);
        List<Mail>inbox =new ArrayList<>();
        inbox.add(firstMail);
        inbox.add(secondMail);
        assertEquals(inbox,mailBoxRepoImpl.findByMailName("barachi@regnos.com").getMailBox().get(0));
        inbox.remove(secondMail);
        mailRepoImpl.deleteBySender("barachi@regnos.com","favchi@regnos.com");
        assertEquals(inbox,mailBoxRepoImpl.findByMailName("barachi@regnos.com").getMailBox().get(0));

    }
}
