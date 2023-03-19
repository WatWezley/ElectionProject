package services;

import data.models.User;
import dtos.request.CreateUserRequest;
import dtos.response.UserResponse;

import java.util.List;

public interface UserService {
    User register(CreateUserRequest userRequest);

    User isLoginCorrect(String userName, String password);

    UserResponse findByUserName(String userName);

    long count();

    List <UserResponse> findAll();


    String delete(String userName);

    String deleteAll();
}
