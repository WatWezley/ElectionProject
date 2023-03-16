package services;

import data.models.Mail;
import data.models.MailBox;
import dtos.request.CreateMailBoxRequest;
import dtos.request.CreateMailRequest;
import dtos.response.MailBoxResponse;

import java.util.List;

public interface MailBoxService {

    MailBox createMailBox(CreateMailBoxRequest inboxRequest);

    Mail sendMails(CreateMailRequest mailRequest);

    MailBoxResponse findMailBoxByMailName(String mailName);

    MailBox saveMailsInInbox(CreateMailRequest mailRequest);

    MailBox saveMailsInOutbox(CreateMailRequest mailRequest);

    List<Mail>  findInbox(String mailBoxName);

    List<Mail>  findOutbox(String mailBoxName);
    String delete(int id);

    long count();
}
