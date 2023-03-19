package services;

import data.models.Mail;
import data.models.MailBox;
import data.models.User;
import dtos.request.CreateMailBoxRequest;
import dtos.request.CreateMailRequest;
import dtos.request.CreateUserRequest;
import dtos.response.MailResponse;


import java.util.List;

public class EmailServiceImpl implements  EmailService {

    private static UserServiceImpl userService = new UserServiceImpl();


    private static MailBoxServiceImpl mailBoxService = new MailBoxServiceImpl();


    @Override
    public User registration(CreateUserRequest userRequest) {
        return userService.register(userRequest);
    }

    @Override
    public MailBox activateMailBox(CreateMailBoxRequest mailBoxRequest) {
        return mailBoxService.createMailBox(mailBoxRequest);
    }

    @Override
    public User loginUser(String userName, String password) {
        return userService.isLoginCorrect(userName, password);

    }

    @Override
    public String sendMail(CreateMailRequest mailRequest) {
        return mailBoxService.sendMails(mailRequest);
    }

    @Override
    public List<MailResponse> viewInboxMails(String userName, MailResponse response) {
        return mailBoxService.findInbox(userName, response);
    }


    @Override
    public List<MailResponse> viewOutboxMails(String userName, MailResponse response) {
        return mailBoxService.findOutbox(userName, response);
    }

    @Override
    public List<MailResponse> viewBySender(String userName, String sender, MailResponse mailResponse) {
        return mailBoxService.findSender(userName, sender, mailResponse);
    }

    @Override
    public List<MailResponse> viewByRecipient(String userName, String recipient, MailResponse mailResponse) {
        return mailBoxService.findRecipient(userName, recipient, mailResponse);
    }

    @Override
    public String delete(int id) {
        return mailBoxService.delete(id);
    }

    @Override
    public String deleteBySender(String userName, String sender) {
        return mailBoxService.deleteBySender(userName,sender);
    }

    @Override
    public String deleteByRecipient(String userName, String recipient) {
        return mailBoxService.deleteByRecipient(userName,recipient);
    }


}

