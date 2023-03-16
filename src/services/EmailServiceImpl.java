package services;

import data.models.Mail;
import data.models.MailBox;
import data.models.User;
import dtos.request.CreateMailBoxRequest;
import dtos.request.CreateMailRequest;
import dtos.request.CreateUserRequest;
import dtos.response.MailResponse;


import java.util.List;

public class EmailServiceImpl implements  EmailService{

    private static UserServiceImpl userService = new UserServiceImpl();


    private static MailBoxServiceImpl mailBoxService= new MailBoxServiceImpl();



    @Override
    public User registration(CreateUserRequest userRequest) {
        User newUser = userService.register(userRequest);
        return newUser;
    }

    @Override
    public MailBox activateMailBox(CreateMailBoxRequest mailBoxRequest) {
        MailBox newMailBox = mailBoxService.createMailBox(mailBoxRequest);
        return newMailBox;
    }

    @Override
    public String loginUser(String userName, String password) {
        return userService.isLoginCorrect(userName,password);

    }

    @Override
    public String sendMail(CreateMailRequest mailRequest) {

        return null;
    }





    @Override
    public List<MailResponse> viewInboxMails( String mailName) {
        return null;
    }


    @Override
    public List<MailResponse> viewOutboxMails( String mailName) {
        return null;
    }

    @Override
    public MailResponse viewBySender(String mailName, String userName) {

        return null;
    }

    @Override
    public MailResponse viewByRecipient(String mailName, String userName) {
        return null;
    }


    @Override
    public String deleteBySenderOrRecipient(String mailName, String userName) {
        return null;
    }

}
