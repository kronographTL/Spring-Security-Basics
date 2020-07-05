package com.demo.springsecurity.service;

import com.demo.springsecurity.domainobject.UserDO;
import com.demo.springsecurity.dto.CreateUserRequest;
import com.demo.springsecurity.dto.UserDetailsRequest;

import java.util.List;

public interface UserService {
    UserDO createUser(CreateUserRequest createUserRequest);

    UserDO getUserById(String userId);

    List<UserDO> getAllUsers();

    UserDO softDeleteUser(String userId);

    UserDO updateUserDetails(UserDetailsRequest userDetailsRequest);
}

