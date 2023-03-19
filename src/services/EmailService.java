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

 User loginUser(String userName,String Password);

String sendMail(CreateMailRequest mailRequest);

 List<MailResponse> viewInboxMails(String userName, MailResponse response);

 List<MailResponse> viewOutboxMails(String userName, MailResponse response);

 List <MailResponse> viewBySender(String userName,String sender, MailResponse mailResponse);

 List <MailResponse> viewByRecipient(String userName,String recipient, MailResponse mailResponse);

 String delete(int id);

 String deleteBySender(String userName,String sender);

 String deleteByRecipient(String userName, String recipient);




}
