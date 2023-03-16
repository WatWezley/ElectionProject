package utils;

import data.models.Mail;
import data.models.MailBox;
import data.models.User;
import dtos.request.CreateMailBoxRequest;
import dtos.request.CreateMailRequest;
import dtos.request.CreateUserRequest;
import dtos.response.MailBoxResponse;
import dtos.response.MailResponse;
import dtos.response.UserResponse;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Mappers {
    public static User map(CreateUserRequest userRequest) {
        User user = new User();
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setUserName(userRequest.getUserName());
        user.setPassword(userRequest.getPassword());
        return user;
    }

    public static UserResponse map(User foundUser, UserResponse response) {
        response.setFirstName(foundUser.getFirstName());
        response.setLastName(foundUser.getLastName());
        response.setUserName(foundUser.getUserName());
        response.setId(foundUser.getId());
        return response;
    }

    public static MailBox map(CreateMailBoxRequest mailBoxRequest) {
        MailBox mailBox = new MailBox();
        mailBox.setMailBoxName(mailBoxRequest.getMailBoxName());
        mailBox.setInbox(mailBoxRequest.getInbox());
        mailBox.setOutbox(mailBoxRequest.getOutbox());
        return mailBox;
    }


    public static MailBoxResponse map(MailBox foundMail, MailBoxResponse response) {
        response.setId(foundMail.getId());
        response.setMailBoxName(foundMail.getMailBoxName());
        response.setInBoxMails((ArrayList<Mail>) foundMail.getInbox());
        response.setOutBoxMails((ArrayList<Mail>) foundMail.getOutbox());
        return response;
    }


    public static Mail map(CreateMailRequest mailRequest) {
        Mail mail = new Mail();
        mail.setId(mailRequest.getId());
        mail.setDate(mailRequest.getDate());
        mail.setSender(mailRequest.getSender());
        mail.setRecipient(mailRequest.getRecipient());
        mail.setTitle(mailRequest.getTitle());
        mail.setBody(mailRequest.getBody());
        return mail;
    }

    public static MailResponse map(Mail mail,MailResponse mailResponse){
        mailResponse.setId(mail.getId());
        mailResponse.setDate(mail.getDate());
        mailResponse.setSender(mail.getSender());
        mailResponse.setRecipient(mail.getRecipient());
        mailResponse.setTitle(mail.getTitle());
        mailResponse.setBody(mail.getBody());
        return mailResponse;

    }


    }

