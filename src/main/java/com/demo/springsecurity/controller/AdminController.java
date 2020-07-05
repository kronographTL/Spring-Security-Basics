package com.demo.springsecurity.controller;

import com.demo.springsecurity.dto.UserDTO;
import com.demo.springsecurity.dto.CreateUserRequest;
import com.demo.springsecurity.dto.UserDetailsRequest;
import com.demo.springsecurity.mapper.UserMapper;
import com.demo.springsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @PostMapping
    ResponseEntity<UserDTO> createUser(CreateUserRequest createUserRequest){
        return new ResponseEntity<>(UserMapper.convertToUserDTO(userService.createUser(createUserRequest)), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    ResponseEntity<UserDTO> getUserById(String userId){
        return new ResponseEntity<>(UserMapper.convertToUserDTO(userService.getUserById(userId)),HttpStatus.OK);
    }
    @GetMapping
    ResponseEntity<List<UserDTO>> getAllAvailableUsers(){
        return new ResponseEntity<>(UserMapper.convertToUserDTOs(userService.getAllUsers()),HttpStatus.OK);
    }
    @PutMapping
    ResponseEntity<UserDTO> updateUserDetails(UserDetailsRequest userDetailsRequest){
        return new ResponseEntity<>(UserMapper.convertToUserDTO(userService.updateUserDetails(userDetailsRequest)),HttpStatus.OK);
    }
    @DeleteMapping
    ResponseEntity<UserDTO> deleteUser(String userId){
        return new ResponseEntity<>(UserMapper.convertToUserDTO(userService.softDeleteUser(userId)),HttpStatus.OK);
    }
}
