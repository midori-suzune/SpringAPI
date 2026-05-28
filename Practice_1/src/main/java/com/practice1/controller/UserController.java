package com.practice1.controller;


import com.practice1.exception.AppException;
import com.practice1.request.UserRequest;
import com.practice1.response.UserResponse;
import com.practice1.service.UserService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    // What is ResponseEntity ?
    // ResponseEntity is a class in Spring Framework that represents an HTTP response,
    // including the status code, headers, and body. It allows you to control the entire HTTP response, making it easier to customize the response based on the application's needs.
    // In this case, we are using ResponseEntity to return a list of UserResponse objects with an HTTP status of 200 OK.
    @GetMapping("/getAll")
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        List<UserResponse> users = userService.getAllUsers();
        // ResponseEntity.ok() : to create a ResponseEntity with a status of 200 OK and the provided body (in this case, the list of users).
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    // ResponseEntity.status(HttpStatus.CREATED).build() :
    // to create a ResponseEntity with a status of 201 Created and has no_body.
    // This is typically used to indicate that a new resource has been successfully created.
    @PostMapping("/create")
    public ResponseEntity<Void> createUser(@RequestBody UserRequest userRequest) {
        userService.createUser(userRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateUser(@PathVariable Integer id, @RequestBody UserRequest userRequest) {
            userService.updateUser(id, userRequest);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @PatchMapping("/{id}")
    public ResponseEntity<Void> patchUser( @PathVariable Integer id, @RequestBody UserRequest  userRequest) {{
        try {
            userService.updateUser(id, userRequest);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    }
    // HttpsStatus.No_CONTENT( 204 )  : to indicate that the request was successful
    // but there is no content to return in the response body.
    // This is often used for delete operations where the resource has been successfully deleted and
    // there is no additional information to provide.
    // so is it same like HttpsStatus.OK ?

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
        try {
            userService.deleteUser(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


}