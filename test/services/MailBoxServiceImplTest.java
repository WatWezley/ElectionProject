package services;

import data.models.MailBox;
import data.respositories.MailBoxRepoImpl;
import dtos.request.CreateMailBoxRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MailBoxServiceImplTest {

    private MailBoxService mailBoxService;

    private CreateMailBoxRequest mailBoxRequest;

    @BeforeEach
    public void setUp() {
        mailBoxService = new MailBoxServiceImpl();
        mailBoxRequest = new CreateMailBoxRequest();
        mailBoxRequest.setMailBoxName("ugokarl@regnos.com");
    }

    @Test
    public void thatMailBoxWasCreated(){
        MailBox mailBox1 = mailBoxService.createMailBox(mailBoxRequest);
        assertEquals(1,mailBox1.getId());
    }

    @Test
    public void findMailBoxWhenCreated(){
        MailBox mailBox1 = mailBoxService.createMailBox(mailBoxRequest);
        String result = """
                Id : 1
                MailBoxName : ugokarl@regnos.com
                InboxMails : []
                OutboxMails : []
                """;
        assertEquals(result, mailBoxService.findMailBoxByMailName("ugokarl@regnos.com").toString());
    }

    @Test
    public void createTwoMailBoxes_DeleteOne(){
        MailBox mailBox1 = mailBoxService.createMailBox(mailBoxRequest);
        mailBoxRequest = new CreateMailBoxRequest();
        mailBoxRequest.setMailBoxName("favchi@regnos.com");
        MailBox mailBox2 = mailBoxService.createMailBox(mailBoxRequest);
        assertEquals(2,mailBoxService.count());
        mailBoxService.delete(2);
        assertEquals(1,mailBoxService.count());

    }

    }

