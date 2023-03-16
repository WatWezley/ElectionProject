package services;

import data.models.User;
import dtos.request.CreateUserRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest {

    private UserService userService;

    private CreateUserRequest request;


    @BeforeEach
    void setUp() {
        userService = new UserServiceImpl();
        request = new CreateUserRequest();
        request.setFirstName("ugo");
        request.setLastName("karl");
        request.setUserName("ugokarl@regnos.com");
        request.setPassword("1111");


    }

    @Test
    public void findPassWordWhenUserSaved() {
        User saved1 = userService.register(request);
        assertEquals("1111", saved1.getPassword());
    }

    @Test
    public void findSavedUser() {
        User saved1 = userService.register(request);
        String result = """
                Id : 1
                FirstName: ugo
                LastName: karl
                UserName: ugokarl@regnos.com
                """;
        assertEquals(result, userService.findByUserName("ugokarl@regnos.com").toString());
    }

    @Test
    public void throwsExceptionWhenUserNotFound() {
        User saved1 = userService.register(request);
        assertThrows(NullPointerException.class, () -> userService.findByUserName("barachi@regnos.com"));

    }

    @Test
    public void throwsExceptionWhenUsernameExist() {
        userService.register(request);
        request = new CreateUserRequest();
        request.setFirstName("ugo2");
        request.setLastName("karl2");
        request.setUserName("ugokarl@regnos.com");
        request.setPassword("0000");
        assertThrows(IllegalArgumentException.class, () -> userService.register(request));

    }

    @Test
    public void throwsExceptionWhenLoginDetailsIsWrong() {
        User saved1 = userService.register(request);
        assertThrows(IllegalArgumentException.class, () -> userService.isLoginCorrect("ugokarl@regnos.com", "4444"));
    }


    @Test
    public void saveTwo_DeleteOne() {
        User saved1 = userService.register(request);
        request = new CreateUserRequest();
        request.setFirstName("ugo2");
        request.setLastName("karl2");
        request.setUserName("favchi@regnos.com");
        request.setPassword("0000");
        User saved2 = userService.register(request);
        assertEquals(2, userService.count());
        String result = "Successfully Deleted";
        assertEquals(result, userService.delete("favchi@regnos.com"));
        assertEquals(1, userService.count());
    }


    @Test
    public void createTwoUsers_DeleteAll() {
        User saved1 = userService.register(request);
        request = new CreateUserRequest();
        request.setFirstName("ugo2");
        request.setLastName("karl2");
        request.setUserName("favchi@regnos.com");
        request.setPassword("0000");
        User saved2 = userService.register(request);
        assertEquals(2, userService.count());
        String result = "User Records Empty";
        assertEquals(result, userService.deleteAll());
        assertEquals(0, userService.count());
    }
}
