package services;

import data.models.User;
import data.respositories.UserRepo;
import data.respositories.UserRepoImpl;
import dtos.request.CreateUserRequest;
import dtos.response.UserResponse;
import utils.Mappers;

import java.util.List;

public class UserServiceImpl implements UserService {

    private static UserRepo userRepo = new UserRepoImpl();


    @Override
    public User register(CreateUserRequest userRequest) {
        if (userExist(userRequest.getUserName())) throw new IllegalArgumentException(userRequest.getUserName() + "already exist");
        return userRepo.save(Mappers.map(userRequest));
    }


    private boolean userExist(String userName) {
        User found = userRepo.findByUserName(userName);
        if (found != null) return true;
        return false;
        }


    @Override
    public UserResponse findByUserName(String userName) {
        User foundUser = userRepo.findByUserName(userName);
        if (foundUser == null ) throw new NullPointerException("User does not exist");
        UserResponse response = new UserResponse();
        Mappers.map(foundUser, response);
        return response;

    }


    @Override
    public List<UserResponse> delete(String userName) {
        userRepo.delete(userName);
        return null;
    }

    @Override
    public List<UserResponse> deleteAll() {
        return null;
    }
}
