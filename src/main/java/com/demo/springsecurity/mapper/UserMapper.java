package com.demo.springsecurity.mapper;

import com.demo.springsecurity.domainobject.UserDO;
import com.demo.springsecurity.dto.UserDTO;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {

    public static UserDTO convertToUserDTO(UserDO user) {
        return UserDTO.builder().userName(user.getUserName())
                .userEmail(user.getUserEmail())
                .userCreatedOn(user.getUserCreatedOn())
                .userRole(user.getUserRole())
                .build();
    }

    public static List<UserDTO> convertToUserDTOs(List<UserDO> allUsers) {
        return allUsers.stream().map(UserMapper::convertToUserDTO).collect(Collectors.toList());
    }
}
