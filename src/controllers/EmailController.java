package controllers;

import dtos.request.CreateMailBoxRequest;
import dtos.request.CreateMailRequest;
import dtos.request.CreateUserRequest;
import services.EmailServiceImpl;

public class EmailController {

    private static EmailServiceImpl emailService = new EmailServiceImpl();


    public Object createAccount(CreateUserRequest userRequest) {
        try {
            return emailService.registration(userRequest);
        } catch (NullPointerException ex) {
            return ex.getMessage();
        }
    }

    public Object createMailBox(CreateMailBoxRequest mailBoxRequest){
            return emailService.activateMailBox(mailBoxRequest);
    }

    public Object login(String userName, String password){
        try{
            return emailService.loginUser(userName,password);
        }
        catch (IllegalArgumentException ex){
           return ex.getMessage();
        }
    }

    public Object sendMail(CreateMailRequest mailRequest){
        try{
            return emailService.sendMail(mailRequest);
        }
        catch (NullPointerException ex){
            return ex.getMessage();
        }
    }

    public Object inbox(String mailName){
        try{
            return emailService.viewInboxMails(mailName);
        }
        catch (NullPointerException ex){
            return ex.getMessage();
        }
    }

    public Object outbox(String mailName){
        try{
            return  emailService.viewOutboxMails(mailName);
        }
        catch (NullPointerException ex){
            return ex.getMessage();
        }
    }

    }

