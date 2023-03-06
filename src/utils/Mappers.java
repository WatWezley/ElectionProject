package utils;

import data.models.User;
import dtos.request.CreateUserRequest;
import dtos.response.UserResponse;

public class Mappers {
    public static User map(CreateUserRequest userRequest){
        User user = new User();
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setUserName(userRequest.getUserName());
        user.setPassword(userRequest.getPassword());
        return user;
    }

    public static void map(User foundUser, UserResponse response) {
        response.setFirstName(foundUser.getFirstName());
        response.setLastName(foundUser.getLastName());
        response.setUserName(foundUser.getUserName());
    }
}
