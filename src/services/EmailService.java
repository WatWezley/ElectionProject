package services;

import data.models.Mail;
import data.models.MailBox;
import data.models.User;
import dtos.request.CreateMailBoxRequest;
import dtos.request.CreateMailRequest;
import dtos.request.CreateUserRequest;
import dtos.response.MailResponse;
import dtos.response.UserResponse;

import java.util.List;

public interface EmailService {

 User registration(CreateUserRequest userRequest);

 MailBox activateMailBox(CreateMailBoxRequest mailBoxRequest);

 String loginUser(String userName,String Password);

String sendMail(CreateMailRequest mailRequest);

 List<MailResponse> viewInboxMails(String mailName);

 List<MailResponse> viewOutboxMails(String mailName);

 MailResponse viewBySender(String mailName,String userName);

 MailResponse viewByRecipient(String mailName,String userName);

 String deleteBySenderOrRecipient(String MailName, String sender);




}
