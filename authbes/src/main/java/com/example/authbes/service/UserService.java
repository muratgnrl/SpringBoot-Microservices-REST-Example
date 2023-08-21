package com.example.authbes.service;

import com.example.authbes.dto.UserDto;
import com.example.authbes.entity.User;
import com.example.authbes.exception.AddFindUserException;
import com.example.authbes.exception.AddUserException;
import com.example.authbes.mapper.UserMapper;
import com.example.authbes.repository.UserRepository;
import com.example.authbes.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    public final UserMapper userMapper;
    public final UserRepository userRepository;
    public UserResponse login(UserDto userdto) throws AddUserException {

        User user=userRepository.findUserByMailAndPasswordAndUserName(userdto.mail,userdto.password ,userdto.userName);
        if (user==null){

            throw new AddUserException();
        }
        return generateUserResult(userMapper.toResource(user));


    }

    private UserResponse generateUserResult(UserDto toResource) {
        UserResponse userResponse=new UserResponse();
        userResponse.userDtoRespon=toResource;
        return userResponse;
    }

    public UserResponse register(UserDto userdto) {

        User user=userMapper.toEntity(userdto);
        user=userRepository.save(user);
        return generateUserResult(userMapper.toResource(user));
    }

    public UserDto find(int userId) throws AddFindUserException {
        User user=findUser(userId);
        if (user==null){

            throw new AddFindUserException();
        }
        UserDto userDto=userMapper.toResource(user);
        return userDto;
    }

    private User findUser(int userId) {
        User user=userRepository.findUserByUserId(userId);
        return user;
    }


    public List<UserDto> getAllUser() {
        return userMapper.toResource(getUserList());
    }

    private List<User> getUserList() {
        return userRepository.findAll();
    }

    public boolean deleteUser(int userId) {

    try{

        userRepository.deleteById(userId);
        return true;

    }
    catch (Exception e){
        return false;}
    }
}
