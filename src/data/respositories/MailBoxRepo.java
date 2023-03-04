package data.respositories;

import data.models.MailBox;
import data.models.User;

import java.util.List;

public interface MailBoxRepo {
    MailBox save(MailBox mailBox);

    MailBox findByMailName(String mailName);

    long count();

    List<MailBox> findAll();

    void delete(String mailName);

    void deleteAll();
}
