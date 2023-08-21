package com.example.authbes.controller;

import com.example.authbes.dto.UserDto;
import com.example.authbes.exception.AddFindUserException;
import com.example.authbes.exception.AddUserException;
import com.example.authbes.response.Meta;
import com.example.authbes.response.UserListResponse;
import com.example.authbes.response.UserResponse;
import com.example.authbes.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("user")
@Controller
public class UserControl {

    public final UserService userService;

    @PostMapping("login")
    public UserResponse login(@RequestBody UserDto userdto) throws AddUserException {


        return userService.login(userdto);
    }

    @PostMapping("register")
    public UserResponse register(@RequestBody UserDto userdto) {

        return userService.register(userdto);
    }

    @GetMapping("/find/{userId}")
    public UserDto find(@PathVariable (value = "userId") int userId) throws AddFindUserException {



        return userService.find(userId);
    }

    @GetMapping("/getAll/User")
    public UserListResponse UserGetAll(){

        Meta meta=new Meta();
        UserResponse userResponse=new UserResponse();
        UserListResponse userListResponse=new UserListResponse();

        List<UserDto> userDtoList=userService.getAllUser();

        if(userListResponse!=null){

            meta.errorCode=2010;
            meta.errorDescription="tüm kullanıcılar(user) bulundu";
            userListResponse.userDtoList=userDtoList;
        }else {

            meta.errorCode=4046;
            meta.errorDescription="(User)Kullanıcılar bulunamadı";
        }
        userResponse.meta=meta;
        return userListResponse;
    }
    @DeleteMapping("/delete/{userId}")
    public UserResponse deleteUser(@PathVariable(value = "userId") int userId){

        UserResponse userResponse=new UserResponse();
        Meta meta=new Meta();

        boolean deleted = userService.deleteUser(userId);

        if (deleted) {
            meta.errorCode = 2001;
            meta.errorDescription = "Kullanıcı silindi(userId)";
        } else {
            meta.errorCode = 4081;
            meta.errorDescription = "Kullanıcı bulunamadı(userId)";}

        userResponse.meta=meta;
        return userResponse;
    }

}
