package data.respositories;

import data.models.Mail;

import java.util.List;

public interface MailRepo {

    Mail save(Mail mail, String sender, String recipient);

    Mail findByRecipient(String recipient,String mailName, Mail mail);

    Mail findBySender(String sender, String mailName, Mail mail);

    List<Mail> findAll();

    void deleteBySender(String sender);

    void deleteBtRecipient(String recipient);



    void deleteAll();
}
