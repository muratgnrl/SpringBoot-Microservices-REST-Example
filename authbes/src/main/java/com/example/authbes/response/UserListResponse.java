package com.example.authbes.response;

import com.example.authbes.dto.UserDto;

import java.io.Serializable;
import java.util.List;

public class UserListResponse extends BaseResponse implements Serializable {

  public  List<UserDto> userDtoList;
}
