package com.lab6.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {

    private String username;
    private String fullName;
    private String userType;
    private Long userId;
    private String cnp;
    private Integer age;
    private String otherInformation;
}
