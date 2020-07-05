package com.demo.springsecurity.service;

import com.demo.springsecurity.domainobject.UserDO;
import com.demo.springsecurity.dto.CreateUserRequest;
import com.demo.springsecurity.dto.UserDetailsRequest;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    UserDO userDO = UserDO.builder().id("1234")
            .password("1234")
            .userCreatedOn(ZonedDateTime.now())
            .userEmail("Kronographtl@gmail.com")
            .userRole("ADMIN")
            .userStatus("ACTIVE").build();
    @Override
    public UserDO createUser(CreateUserRequest createUserRequest) {
        return userDO;
    }

    @Override
    public UserDO getUserById(String userId) {
        return userDO;
    }

    @Override
    public List<UserDO> getAllUsers() {
        List<UserDO> users = new ArrayList<UserDO>();
        users.add(userDO);
        return users;
    }

    @Override
    public UserDO softDeleteUser(String userId) {
        return userDO;
    }

    @Override
    public UserDO updateUserDetails(UserDetailsRequest userDetailsRequest) {
        return userDO;
    }
}
