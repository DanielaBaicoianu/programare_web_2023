package com.example.lab7.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {

    private String username;
    private String fullName;
    private String userType;

}
