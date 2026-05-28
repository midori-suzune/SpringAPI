package com.practice1.entity;

import com.practice1.request.UserRequest;
import com.practice1.response.UserResponse;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 50)
    @Column(name = "username", length = 50)
    private String userName;

    @Size(max = 100)
    @Column(name = "email", length = 100)
    private String email;

    @Size(max = 255)
    @Column(name = "password")
    private String password;

    @Size(max = 100)
    @Column(name = "fullname", length = 100)
    private String fullName;

    @Column(name = "age")
    private Integer age;

    public static UserResponse toResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .userName(user.getUserName())
                .email(user.getEmail())
                .password(user.getPassword())
                .fullName(user.getFullName())
                .age(user.getAge())
                .build();
    }

    public static User toEntity(UserRequest userRequest) {
        return User.builder()
                .id(userRequest.getId())
                .userName(userRequest.getUserName())
                .email(userRequest.getEmail())
                .password(userRequest.getPassword())
                .fullName(userRequest.getFullName())
                .age(userRequest.getAge())
                .build();
    }
}