package com.example.authbes.exception;

import com.example.authbes.response.Meta;
import com.example.authbes.response.UserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<Object> addUserException(AddUserException exception, WebRequest webRequest) {

        Meta meta = new Meta();
        UserResponse userResponse = new UserResponse();

        meta.errorCode = 4004;
        meta.errorDescription = "Giriş hatalı Kullanıcı Adı Mail veya Password hatalıdır Kontrol edin";
        userResponse.meta = meta;
        ResponseEntity<Object> entity = new ResponseEntity<>(userResponse, HttpStatus.NOT_FOUND);
        return entity;
    }
    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<Object> AddFindUserException(AddFindUserException exception, WebRequest webRequest) {

        Meta meta = new Meta();
        UserResponse userResponse = new UserResponse();

        meta.errorCode = 4441;
        meta.errorDescription = "aranan User(Kullanıcı) bulunamadı lütfen girdiğiniz kimlik numarası (Id) kontrol ediniz";
        userResponse.meta = meta;
        ResponseEntity<Object> entity = new ResponseEntity<>(userResponse, HttpStatus.NOT_FOUND);
        return entity;
    }
}
