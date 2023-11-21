package com.lab6.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {

    private Long id;
    private String username;
    private String fullName;
    private String userType;
    private UserDetails userDetails;

}
