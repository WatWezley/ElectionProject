package controllers;

import dtos.request.CreateMailBoxRequest;
import dtos.request.CreateMailRequest;
import dtos.request.CreateUserRequest;
import dtos.response.MailResponse;
import services.EmailServiceImpl;

import javax.swing.*;

public class EmailController {

    private static EmailServiceImpl emailService = new EmailServiceImpl();


    public Object createAccount(CreateUserRequest userRequest) {
        CreateMailBoxRequest createMailBoxRequest = new CreateMailBoxRequest();
        try {
            var user = emailService.registration(userRequest);
            createMailBoxRequest.setUserName(userRequest.getUserName());
            emailService.activateMailBox(createMailBoxRequest);
            return user;
        } catch (IllegalArgumentException ex) {
            return ex.getMessage();
        }
    }
    public Object login(String userName, String password) {
        try {
            return emailService.loginUser(userName, password);
        } catch (IllegalArgumentException ex) {
            return ex.getMessage();
        }
    }

    public Object sendMail(CreateMailRequest mailRequest) {
        try {
            return emailService.sendMail(mailRequest);
        } catch (NullPointerException ex) {
            return ex.getMessage();
        }
    }

    public Object inbox(String userName, MailResponse mailResponse) {
        try {
            return emailService.viewInboxMails(userName, mailResponse);
        } catch (NullPointerException ex) {
            return ex.getMessage();
        }
    }


    public Object outbox(String userName, MailResponse mailResponse) {
        try {
            return emailService.viewOutboxMails(userName, mailResponse);
        } catch (NullPointerException ex) {
            return ex.getMessage();
        }
    }

    public Object viewBySender(String userName, String sender, MailResponse mailResponse) {
        try {
            return emailService.viewBySender(userName, sender, mailResponse);
        } catch (NullPointerException ex) {
            return ex.getMessage();
        }
    }

    public Object viewByRecipient(String userName, String recipient, MailResponse mailResponse) {
        try {
            return emailService.viewByRecipient(userName, recipient, mailResponse);
        } catch (NullPointerException ex) {
            return ex.getMessage();
        }
    }

    public Object deleteBySender(String userName, String sender) {
        try {
            return emailService.deleteBySender(userName, sender);
        } catch (NullPointerException ex) {
            return ex.getMessage();
        }

    }

    public Object deleteByRecipient(String userName, String recipient) {
        try {
            return emailService.deleteByRecipient(userName, recipient);
        } catch (NullPointerException ex) {
            return ex.getMessage();
        }
    }
}




