package data.respositories;

import data.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepoImpl implements UserRepo{

    List<User> users = new ArrayList<>();

    int count = 0;
    @Override
    public User save(User user) {
        users.add(user);
        count++;
        return user;
    }

    @Override
    public User findByUserName(String userName) {
        for (User user: users){
            if(user.getUserName().equalsIgnoreCase(userName)){
                return user;
            }}
        return null;
    }

    @Override
    public long count() {
        return count;
    }

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public void delete(String userName) {
        for (User user: users){
            if(user.getUserName().equalsIgnoreCase(userName)){
                users.remove(user);
                count--;
            }
            break;
        }

    }

    @Override
    public void deleteAll() {
        users.clear();
        count = 0;

    }
}
