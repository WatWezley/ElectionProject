package services;

import data.models.User;
import data.respositories.UserRepo;
import data.respositories.UserRepoImpl;
import dtos.request.CreateUserRequest;
import dtos.response.UserResponse;
import utils.Mappers;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {

    private static final UserRepo userRepo = new UserRepoImpl();


    @Override
    public User register(CreateUserRequest userRequest) {
        if (userExist(userRequest.getUserName())) throw new IllegalArgumentException(userRequest.getUserName() + "already exist");
        return userRepo.save(Mappers.map(userRequest));
    }

    @Override
    public User isLoginCorrect(String userName, String password) {
        User user = userRepo.findByUserName(userName);
        System.out.println(user.getPassword());
        if(user.getPassword() == password) {return user;}
        throw new IllegalArgumentException("Invalid Credentials");

    }


    public Boolean loginValidation(String userName, String password) {
        User user = userRepo.findByUserName(userName);
        if(user.getPassword().equals(password)) {
            return true;
        }return false;
    }


    private boolean userExist(String userName) {
        User found = userRepo.findByUserName(userName);
        return found != null;
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
    public List<UserResponse> findAll() {
        List<UserResponse> responseUser = new ArrayList<>();
        List<User> allUser = userRepo.findAll();
        for (User foundUser : allUser) {
            UserResponse response = new UserResponse();
            Mappers.map(foundUser, response);
            responseUser.add(response);
        }return responseUser;
    }

    public long count(){
        return  userRepo.count();
    }


    @Override
    public String delete(String userName) {
        userRepo.delete(userName);
        return "Successfully Deleted";
    }

    @Override
    public String deleteAll() {
        userRepo.deleteAll();
        return "User Records Empty";
    }
}
