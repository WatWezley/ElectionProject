package data.respositories;

import data.models.MailBox;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MailBoxRepoImplTest {

    private MailBoxRepoImpl mailBoxRepoImpl;

    MailBox mailBox;

    @BeforeEach
    void setUp(){
        mailBox=new MailBox();
        mailBox.setUserName("ugokarl@regnos.com");
        mailBoxRepoImpl= new MailBoxRepoImpl();

    }

    @Test
    public void saveAfterCreation(){
        MailBox mailBox1= mailBoxRepoImpl.save(mailBox);
        assertEquals(1,mailBoxRepoImpl.count());
    }

    @Test
    public void saveOneMailBox_FindByMailNameTest() {
        MailBox mailBox1 = mailBoxRepoImpl.save(mailBox);
        MailBox foundBox = mailBoxRepoImpl.findByMailName("ugokarl@regnos.com");
        assertEquals(mailBox1,foundBox);
    }


    @Test
    public void saveTwoMailBoxes_findAll(){
        MailBox mailBox1= mailBoxRepoImpl.save(mailBox);
        mailBox=new MailBox();
        mailBox.setUserName("ugokarl@regnos.com");
        MailBox mailBox2= mailBoxRepoImpl.save(mailBox);
        List<MailBox> mailBoxList = List.of(new MailBox[]{mailBox1, mailBox2});
        assertEquals(2,mailBoxRepoImpl.count());
        assertEquals(mailBoxList,mailBoxRepoImpl.findAll());

        }
    @Test
    public void saveTwoMailBoxes_DeleteByMailName(){
        MailBox mailBox1= mailBoxRepoImpl.save(mailBox);
        mailBox=new MailBox();
        mailBox.setUserName("ugokarl@regnos.com");
        MailBox mailBox2= mailBoxRepoImpl.save(mailBox);
        mailBox=new MailBox();
        mailBox.setUserName("favchi@regnos.com");
        MailBox mailBox3= mailBoxRepoImpl.save(mailBox);
        List<MailBox> mailBoxList = List.of(new MailBox[]{mailBox1, mailBox2, mailBox3});
        assertEquals(mailBoxList,mailBoxRepoImpl.findAll());
        assertEquals(3,mailBoxRepoImpl.count());
        mailBoxRepoImpl.delete(1);
        List<MailBox> mailBoxList1 = List.of(new MailBox[]{mailBox2, mailBox3});
        assertEquals(2,mailBoxRepoImpl.count());
        assertEquals(mailBoxList1,mailBoxRepoImpl.findAll());
    }
    @Test
    public void saveThreeMailBox_DeleteAll(){
        MailBox mailBox1= mailBoxRepoImpl.save(mailBox);
        mailBox = new MailBox();
        mailBox.setUserName("ugokarl@regnos.com");
        MailBox mailBox2= mailBoxRepoImpl.save(mailBox);
        mailBox = new MailBox();
        mailBox.setUserName("favchi@regnos.com");
        MailBox mailBox3= mailBoxRepoImpl.save(mailBox);
        List<MailBox> mailBoxList = List.of(new MailBox[]{mailBox1, mailBox2, mailBox3});
        assertEquals(mailBoxList,mailBoxRepoImpl.findAll());
        assertEquals(3,mailBoxRepoImpl.count());
        mailBoxRepoImpl.deleteAll();
        List<MailBox> mailBoxList1 = List.of(new MailBox[]{});
        assertEquals(0,mailBoxRepoImpl.count());
        assertEquals(mailBoxList1,mailBoxRepoImpl.findAll());
    }
    }


