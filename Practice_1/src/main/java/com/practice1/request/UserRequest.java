package com.practice1.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserRequest {
    private Integer id;
    private String userName;
    private String email;
    private String password;
    private String fullName;
    private Integer age;
}
