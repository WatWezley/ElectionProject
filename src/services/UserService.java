package services;

import data.models.User;
import dtos.request.CreateUserRequest;
import dtos.response.UserResponse;

import java.util.List;

public interface UserService {
    User register(CreateUserRequest userRequest);

    UserResponse findByUserName(String userName);


    List<UserResponse> delete(String userName);

    List<UserResponse> deleteAll();
}
