package services;

import data.models.MailBox;
import data.respositories.MailBoxRepoImpl;
import dtos.request.CreateMailBoxRequest;
import dtos.request.CreateMailRequest;
import dtos.response.MailResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MailBoxServiceImplTest {

    private MailBoxService mailBoxService;

    private CreateMailBoxRequest mailBoxRequest;

    private CreateMailRequest mailRequest;
    
    private MailResponse mailResponse;

    @BeforeEach
    public void setUp() {
        mailBoxService = new MailBoxServiceImpl();
        mailBoxRequest = new CreateMailBoxRequest();
        mailBoxRequest.setUserName("ugokarl@regnos.com");
    }

    @Test
    public void thatMailBoxWasCreated(){
        MailBox mailBox1 = mailBoxService.createMailBox(mailBoxRequest);
        System.out.println(mailBox1.getInbox());
        assertEquals(1,mailBox1.getId());
    }

    @Test
    public void findMailBoxWhenCreated(){
        MailBox mailBox1 = mailBoxService.createMailBox(mailBoxRequest);
        String result = """
                Id : 1
                UserName : ugokarl@regnos.com
                InboxMails : []
                OutboxMails : []
                """;
        assertEquals(result, mailBoxService.findMailBoxByMailName("ugokarl@regnos.com").toString());
    }

    @Test
    public void testThatMailCanBeSentAndReceiveInTheMailbox(){
        MailBox mailBox1 = mailBoxService.createMailBox(mailBoxRequest);
        mailBoxRequest = new CreateMailBoxRequest();
        mailBoxRequest.setUserName("favchi@regnos.com");
        MailBox mailBox2 = mailBoxService.createMailBox(mailBoxRequest);
        mailRequest = new CreateMailRequest();
        mailRequest.setRecipient("favchi@regnos.com");
        mailRequest.setSender("ugokarl@regnos.com");
        mailRequest.setTitle("It gets better");
        mailRequest.setTitle("my journey is java seemed frustrating");
        mailBoxService.sendMails(mailRequest);
        assertEquals(1,mailBoxService.inboxCount("favchi@regnos.com"));
        assertEquals(1,mailBoxService.outboxCount("ugokarl@regnos.com"));

    }
    
    @Test
    public void testThatMailsFromAParticularSenderCanBeFound(){
        mailBoxService.createMailBox(mailBoxRequest);
        mailBoxRequest = new CreateMailBoxRequest();
        mailBoxRequest.setUserName("favchi@regnos.com");
        mailBoxService.createMailBox(mailBoxRequest);
        mailRequest = new CreateMailRequest();
        mailRequest.setRecipient("favchi@regnos.com");
        mailRequest.setSender("ugokarl@regnos.com");
        mailRequest.setTitle("It gets better");
        mailRequest.setBody("my journey is java seemed frustrating");
        mailBoxService.sendMails(mailRequest);
        assertEquals(1,mailBoxService.inboxCount("favchi@regnos.com"));
        assertEquals(1,mailBoxService.outboxCount("ugokarl@regnos.com"));;
        assertEquals(1,mailBoxService.findSender("favchi@regnos.com","ugokarl@regnos.com",mailResponse).size());
        
        
    }

    @Test
    public void createTwoMailBoxes_DeleteOne(){
        mailBoxService.createMailBox(mailBoxRequest);
        mailBoxRequest = new CreateMailBoxRequest();
        mailBoxRequest.setUserName("favchi@regnos.com");
        mailBoxService.createMailBox(mailBoxRequest);
        assertEquals(2,mailBoxService.count());
        mailBoxService.delete(2);
        assertEquals(1,mailBoxService.count());

    }

}