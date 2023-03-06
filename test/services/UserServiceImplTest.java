package services;

import data.models.User;
import dtos.request.CreateUserRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest {

    private UserServiceImpl userService;

    private CreateUserRequest request;

    @BeforeEach
    void setUp(){
        userService = new UserServiceImpl();
        request = new CreateUserRequest();
        request.setFirstName("ugo");
        request.setLastName("karl");
        request.setUserName("ugokarl@regnos.com");
        request.setPassword("1111");


    }

    @Test
    public void findPassWordWhenUserSaved(){
        User saved1 = userService.register(request);
        assertEquals("1111",saved1.getPassword());
    }

    @Test
    public void findSavedUser(){
        User saved1 = userService.register(request);
        String result = """
                FirstName: ugo
                LastName: karl
                UserName: ugokarl@regnos.com
                Password: null
                """;
        assertEquals(result,userService.findByUserName("ugokarl@regnos.com").toString());
    }



    public void saveTwo_DeleteOne(){
        User saved1 = userService.register(request);
    }


}