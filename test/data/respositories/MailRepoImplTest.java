package data.respositories;

import data.models.Mail;
import data.models.MailBox;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class MailRepoImplTest {

    private MailRepoImpl mailRepoImpl;

    private MailBoxRepoImpl mailBoxRepoImpl;

    MailBox mailBox;

    Mail mail;

    @BeforeEach
    void setUp(){
        mailBox=new MailBox();
        mailBox.setMailName("ugokarl@regnos.com");
        mailBox.setMailBox();
        mailBoxRepoImpl= new MailBoxRepoImpl();
        mailBoxRepoImpl.save(mailBox);
        mailBox=new MailBox();
        mailBox.setMailName("favchi@regnos.com");
        mailBox.setMailBox();
        mailBoxRepoImpl.save(mailBox);
        mailBox=new MailBox();
        mailBox.setMailName("barachi@regnos.com");
        mailBox.setMailBox();
        mailBoxRepoImpl.save(mailBox);
        mail = new Mail();
        mail.setSender("ugokarl@regnos.com");
        mail.setRecipient("favchi@regnos.com");
        mail.setTitle("Java");
        mail.setBody("my java story starts here");


    }


    @Test

    public void SavingOfMailCreated(){
        mailRepoImpl = new MailRepoImpl();
        mailRepoImpl.save(mail,"ugokarl@regnos.com","barachi@regnos.com");
        System.out.println(mailBoxRepoImpl.findByMailName("barachi@regnos.com").toString());
        //assertEquals(1, mailRepoImpl.inboxSize("barachi@regnos.com"));
        //assertEquals(1, mailRepoImpl.outboxSize("ugokarl@regnos.com"));

    }

}