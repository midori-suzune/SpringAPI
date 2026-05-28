package com.practice1.service;


import com.practice1.common.enums.ErrorCodeType;
import com.practice1.entity.User;
import com.practice1.exception.AppException;
import com.practice1.repository.UserRepository;
import com.practice1.request.UserRequest;
import com.practice1.response.UserResponse;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {
     private final UserRepository userRepository;

     public List<UserResponse> getAllUsers() {
        return userRepository.findAll().stream()
                .map(user -> UserResponse.builder()
                        .id(user.getId())
                        .userName(user.getUserName())
                        .email(user.getEmail())
                        .password(user.getPassword())
                        .fullName(user.getFullName())
                        .age(user.getAge())
                        .build())
                .toList();
     }

     public void createUser(UserRequest userRequest) {
        userRepository.save(User.toEntity(userRequest));
     }

     public void updateUser(Integer userId, UserRequest userRequest)  {
        var user =  userRepository.findById(userId).orElseThrow(() -> new AppException(ErrorCodeType.USER_NOT_FOUND));
        user.setFullName(userRequest.getFullName());
        user.setAge(userRequest.getAge());
        user.setUserName(userRequest.getUserName());
        userRepository.save(user);
     }

    public void deleteUser(Integer id) {
         userRepository.deleteById(id);
    }
}
