package data.respositories;

import data.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserRepoImplTest {

    private UserRepoImpl userRepoImpl;

    private User user;

    @BeforeEach
    public  void setUp() {
        user = new User();
        user.setFirstName("ugo");
        user.setLastName("karl");
        user.setUserName("ugokarl@regnos.com");
        user.setPassword("0000");
        userRepoImpl = new UserRepoImpl();
    }

    @Test
    public void saveAfterCreation(){
        userRepoImpl.save(user);
        assertEquals(1,userRepoImpl.count());
    }

    @Test
    public void saveOneUser_idOfUserIsOneTest(){
        User savedUser =  userRepoImpl.save(user);
        assertEquals("ugokarl@regnos.com", savedUser.getUserName());
    }

    @Test
    public void saveTwoUsersWithSameId_countIsOneTest(){
        User savedUser =  userRepoImpl.save(user);
        assertEquals(1, userRepoImpl.count());
        user = new User();
        user.setFirstName("wez");
        user.setLastName("wat");
        user.setUserName("watwez@regnos.com");
        user.setPassword("1111");
        userRepoImpl.save(user);
        assertEquals(2, userRepoImpl.count());
    }

    @Test
    public void saveOneUser_findByUserNameTest(){
        User savedUser =  userRepoImpl.save(user);
        assertEquals("ugokarl@regnos.com", savedUser.getUserName());
        User foundUser = userRepoImpl.findByUserName("ugokarl@regnos.com");
        assertEquals(savedUser,foundUser);

    }

    @Test
    public void saveTwoUser_deleteOneUser_byUser(){
        User savedUser =  userRepoImpl.save(user);
        assertEquals(1, userRepoImpl.count());
        user = new User();
        user.setFirstName("favour");
        user.setLastName("chimezie");
        user.setUserName("favchi@regnos.com");
        user.setPassword("2222");
        User savedUser2 =  userRepoImpl.save(user);
        assertEquals(2, userRepoImpl.count());
        userRepoImpl.delete("ugokarl@regnos.com");
        assertEquals(1, userRepoImpl.count());
    }
    @Test
    public void saveTwoUser_findAllUser(){
        User savedUser =  userRepoImpl.save(user);
        user = new User();
        user.setFirstName("favour");
        user.setLastName("chimezie");
        user.setUserName("favchi@regnos.com");
        user.setPassword("2222");
        User savedUser2 =  userRepoImpl.save(user);
        assertEquals("favchi@regnos.com", savedUser2.getUserName());
        List<User> users2 = List.of(new User[]{savedUser, savedUser2});
        assertEquals(users2,userRepoImpl.findAll());;
        assertEquals(2, userRepoImpl.count());}

    @Test
    public void saveTwoUser_deleteAllUser_CountIsZeroTest(){
        User savedUser =  userRepoImpl.save(user);
        assertEquals(1, userRepoImpl.count());
        user = new User();
        user.setFirstName("bara");
        user.setLastName("jeth");
        user.setUserName("barajeth@regnos.com");
        user.setPassword("3333");
        User savedUser2 =  userRepoImpl.save(user);
        assertEquals("barajeth@regnos.com", savedUser2.getUserName());
        User foundUser2 = userRepoImpl.findByUserName("barajeth@regnos.com");
        assertEquals(foundUser2, savedUser2);
        assertEquals(2, userRepoImpl.count());
        userRepoImpl.deleteAll();
        assertEquals(0, userRepoImpl.count());
    }


}