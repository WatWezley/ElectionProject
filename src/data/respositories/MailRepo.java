package data.respositories;

import data.models.Mail;

import java.util.ArrayList;
import java.util.List;

public interface MailRepo {

    Mail save(Mail mail);

    Mail findByRecipient(String MailName,String recipient, Mail mail);


    List<Mail> findBySender(String mailName, String sender, Mail mail);

    ArrayList<ArrayList<Object>> findAll(String mailName);

    void deleteBySender(String mailName, String sender);

    void deleteBtRecipient(String mailName, String recipient);



    void deleteAll(String mailName);
}
