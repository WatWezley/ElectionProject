package services;

import data.models.Mail;
import data.models.MailBox;
import data.respositories.MailBoxRepo;
import data.respositories.MailBoxRepoImpl;
import dtos.request.CreateMailBoxRequest;
import dtos.request.CreateMailRequest;
import dtos.response.MailBoxResponse;
import dtos.response.MailResponse;

import javax.naming.NameNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static utils.Mappers.map;


public class  MailBoxServiceImpl implements MailBoxService {

    private static MailBoxRepo mailBoxRepo = new MailBoxRepoImpl();

    @Override
    public MailBox createMailBox(CreateMailBoxRequest mailBoxRequest) {
        return mailBoxRepo.save(map(mailBoxRequest));

    }

    @Override
    public String sendMails(CreateMailRequest mailRequest) {
        MailBox mailBox = mailBoxRepo.findByMailName(mailRequest.getRecipient());
        if(mailBox == null)throw new NullPointerException("This User does not exist");
        mailBox.setInbox(map(mailRequest));
//        List<Mail>inbox= mailBox.getInbox();
//        inbox.add(map(mailRequest));
        MailBox mailBox1= mailBoxRepo.findByMailName(mailRequest.getSender());
        if(mailBox1 == null)throw new NullPointerException("This User does not exist");
        List<Mail>outbox =mailBox1.getOutbox();
        outbox.add(map(mailRequest));
        return "Mail sent successfully";
    }


    @Override
    public MailBoxResponse findMailBoxByMailName(String userName) {
        MailBox foundMail = mailBoxRepo.findByMailName(userName);
        if (foundMail == null ) throw new NullPointerException("MailBox does not exist");
        MailBoxResponse response = new MailBoxResponse();
        map(foundMail, response);
        return response;
    }


    @Override
    public List<MailResponse> findInbox(String userName, MailResponse response) {
        List<MailResponse>inboxResponse = new ArrayList<>();
         MailBox foundMailBox = mailBoxRepo.findByMailName(userName);
         if (foundMailBox == null ) throw new NullPointerException("MailBox does not exist");
         List<Mail>inbox = foundMailBox.getInbox();
         response = new MailResponse();
        for(Mail mails: inbox){
        inboxResponse.add(map(mails,response));
    }
    return inboxResponse;
    }

    @Override
    public List<MailResponse> findOutbox(String userName, MailResponse response) {
        List<MailResponse>outboxResponse = new ArrayList<>();
        MailBox foundMailBox = mailBoxRepo.findByMailName(userName);
        if (foundMailBox == null ) throw new NullPointerException("MailBox does not exist");
        List<Mail>outbox = foundMailBox.getOutbox();
        response = new MailResponse();
        for(Mail mails: outbox){
            outboxResponse.add(map(mails,response));
        }
        return outboxResponse;
    }

    @Override
    public List<MailResponse> findSender(String userName, String sender, MailResponse mailResponse) {
        List<MailResponse> senderMails = new ArrayList<>();
        MailBox foundMailBox = mailBoxRepo.findByMailName(userName);
        if (foundMailBox == null) throw new NullPointerException("MailBox does not exist");
        List<Mail> inbox = foundMailBox.getInbox();
        mailResponse = new MailResponse();
        for (Mail mails : inbox) {
            if (mails.getSender().equalsIgnoreCase(sender)) {
                senderMails.add(map(mails, mailResponse));
            }
            else throw new NullPointerException("Sender does not exist");

        }return senderMails;
    }

    @Override
    public List<MailResponse> findRecipient(String userName, String recipient,MailResponse mailResponse ) {
        List<MailResponse> recipientMails = new ArrayList<>();
        MailBox foundMailBox = mailBoxRepo.findByMailName(userName);
        if (foundMailBox == null) throw new NullPointerException("MailBox does not exist");
        List<Mail> outbox = foundMailBox.getOutbox();
        mailResponse = new MailResponse();
        for (Mail mails : outbox) {
            if (mails.getRecipient().equalsIgnoreCase(recipient)) {
                recipientMails.add(map(mails, mailResponse));
            }
            else throw new NullPointerException("Recipient does not exist");

        }return recipientMails;
    }


    @Override
    public long inboxCount(String userName) {
        return mailBoxRepo.findByMailName(userName).getInbox().size();
    }

    @Override
    public long outboxCount(String userName) {
        return mailBoxRepo.findByMailName(userName).getOutbox().size();
    }


    @Override
    public String delete(int id) {
        mailBoxRepo.delete(id);
        return "Successfully deleted";
    }

    @Override
    public String deleteBySender(String userName, String sender) {
        MailBox foundMailBox = mailBoxRepo.findByMailName(userName);
        if (foundMailBox == null) throw new NullPointerException("MailBox does not exist");
        List<Mail> inbox = foundMailBox.getInbox();
        for(Mail mail : inbox){
        if( mail.getSender().equalsIgnoreCase(sender)){
            inbox.remove(mail);
            return "Deleted Successfully";
            }
        }
        throw new NullPointerException("Sender does not exist");

    }

    @Override
    public String deleteByRecipient(String userName, String recipient) {
        MailBox foundMailBox = mailBoxRepo.findByMailName(userName);
        if (foundMailBox == null) throw new NullPointerException("MailBox does not exist");
        List<Mail> outbox = foundMailBox.getOutbox();
        for(Mail mail : outbox){
        if( mail.getRecipient().equalsIgnoreCase(recipient)){
            outbox.remove(mail);
            return "Deleted Successfully";
        }
    }
        throw new NullPointerException("Sender does not exist");
    }



}


