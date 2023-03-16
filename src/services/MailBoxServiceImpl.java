package services;

import data.models.Mail;
import data.models.MailBox;
import data.models.User;
import data.respositories.MailBoxRepo;
import data.respositories.MailBoxRepoImpl;
import dtos.request.CreateMailBoxRequest;
import dtos.request.CreateMailRequest;
import dtos.response.MailBoxResponse;
import utils.Mappers;

import javax.naming.NameNotFoundException;
import java.util.List;


public class  MailBoxServiceImpl implements MailBoxService {

    private static MailBoxRepo mailBoxRepo = new MailBoxRepoImpl();

    private Mail mail = new Mail();



    @Override
    public MailBox createMailBox(CreateMailBoxRequest mailBoxRequest) {
        return mailBoxRepo.save(Mappers.map(mailBoxRequest));

    }

    public User save(User user) {
        boolean userHasNotBeenSaved = user.getId() == 0;
        if (userHasNotBeenSaved) {
            user.setId(generateUserId());
            users.add(user);
            count++;

        }return user;
    }

    public int generateUserId(){
        return count + 1;

    }

    @Override
    public MailBoxResponse findMailBoxByMailName(String mailName) {
        MailBox foundMail = mailBoxRepo.findByMailName(mailName);
        if (foundMail == null ) throw new NullPointerException("MailBox does not exist");
        MailBoxResponse response = new MailBoxResponse();
        Mappers.map(foundMail, response);
        return response;
    }

    @Override
    public MailBox saveMailsInInbox(CreateMailRequest mailRequest) {
        MailBox mailBox = mailBoxRepo.findByMailName(mailRequest.getRecipient());
        mailBox.getInbox().add(createdMails);
        return mailBox;
    }

    @Override
    public MailBox saveMailsInOutbox(CreateMailRequest mailRequest) {

        MailBox mailBox = mailBoxRepo.findByMailName(mailRequest.getSender());
        //mailBox.getOutbox().add();
        return null;
    }

    @Override
    public List<Mail> findInbox(String mailBoxName) {
    MailBox mailBox = mailBoxRepo.findByMailName(mailBoxName);
    if(mailBox == null) throw new IllegalArgumentException("User not found");

    return mailBox.getInbox();
    }

    @Override
    public List<Mail> findOutbox(String mailBoxName) {
        MailBox mailBox = mailBoxRepo.findByMailName(mailBoxName);
        if(mailBox == null)throw new NullPointerException("User does not exist");
        return mailBox.getOutbox();
    }


    @Override
    public String delete(int id) {
        mailBoxRepo.delete(id);
        return null;
    }

    @Override
    public long count() {
        return mailBoxRepo.count();
    }


}


