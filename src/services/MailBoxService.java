package services;

import data.models.Mail;
import data.models.MailBox;
import dtos.request.CreateMailBoxRequest;
import dtos.request.CreateMailRequest;
import dtos.response.MailBoxResponse;
import dtos.response.MailResponse;

import java.util.List;

public interface MailBoxService {

    MailBox createMailBox(CreateMailBoxRequest inboxRequest);

    String sendMails(CreateMailRequest mailRequest);

    MailBoxResponse findMailBoxByMailName(String userName);

    List<MailResponse>  findInbox(String userName,MailResponse response);

    List<MailResponse>  findOutbox(String userName, MailResponse response);

    List<MailResponse> findSender(String userName, String sender, MailResponse mailResponse);

    List <MailResponse> findRecipient(String userName, String recipient, MailResponse mailResponse);
    long inboxCount(String userName);

    long outboxCount(String userName);
    String delete(int id);

    String deleteBySender(String userName,String sender);

    String deleteByRecipient(String userName, String recipient);

}
