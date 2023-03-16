package data.respositories;

import data.models.MailBox;
import data.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepoImpl implements UserRepo{

     private static List<User> users = new ArrayList<>();

    int count = 0;
    @Override
    public User save(User user) {
        boolean userHasNotBeenSaved = user.getId() == 0;
        if (userHasNotBeenSaved) {
            user.setId(generateUserId());
            users.add(user);
            count++;

        }return user;
    }

    public int generateUserId(){
       return count + 1;

    }

    @Override
    public User findById(int id) {
        for (User user: users){
            if(user.getId()==(id)){
                return user;
            }}

        return null;
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
        List<User> toRemove = new ArrayList<>();
        for (User user2 : users) {
            if (user2.getUserName().equalsIgnoreCase(userName)) {
                toRemove.add(user2);
                count--;
            }

        }users.removeAll(toRemove);

            }




    @Override
    public void deleteAll() {
        users.clear();
        count = 0;

    }
}
