package com.example.authbes.repository;

import com.example.authbes.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {


    User findUserByMailAndPasswordAndUserName(String mail, String password, String userName);

    User findUserByUserId(int userId);
}
