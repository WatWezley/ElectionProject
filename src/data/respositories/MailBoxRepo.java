package data.respositories;

import data.models.MailBox;


import java.util.List;

public interface MailBoxRepo {
    MailBox save(MailBox mailBox);

    MailBox findById(int id);

    MailBox findByMailName(String userName);

    long count();

    List<MailBox> findAll();

    void delete(int id);

    void deleteAll();
}
