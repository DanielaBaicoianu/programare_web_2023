package com.lab6.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDetails {
    private Long id;
    private Long userId;
    private String cnp;
    private Integer age;
    private String otherInformation;

}
