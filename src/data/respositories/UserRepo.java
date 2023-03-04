package data.respositories;

import data.models.User;

import java.util.List;

public interface UserRepo {

    User save(User user);

    User findByUserName(String userName);

    long count();

    List<User> findAll();

    void delete(String userName);

    void deleteAll();


}
