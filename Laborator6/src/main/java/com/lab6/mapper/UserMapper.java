package com.lab6.mapper;

import org.springframework.stereotype.Component;

import com.lab6.dto.UserDto;
import com.lab6.entity.User;
import com.lab6.entity.UserDetails;

@Component
public class UserMapper {

    public static UserDto convertToDto(User user){

        return UserDto.builder()
                .userId(user.getId())
                .username(user.getUsername())
                .fullName(user.getFullName())
                .userType(user.getUserType())
                .cnp(user.getUserDetails()!=null ? user.getUserDetails().getCnp() : null)
                .age(user.getUserDetails()!=null ? user.getUserDetails().getAge() : null)
                .otherInformation(user.getUserDetails()!=null ? user.getUserDetails().getOtherInformation() : null)
                .build();

    }

    public static User convertToUser(UserDto userDto){
        return User.builder()
                .username(userDto.getUsername())
                .fullName(userDto.getFullName())
                .userType(userDto.getUserType())
                .userDetails(UserDetails.builder()
                        .age(userDto.getAge())
                        .cnp(userDto.getCnp())
                        .userId(userDto.getUserId())
                        .otherInformation(userDto.getOtherInformation())
                        .build())
                .build();

    }

}
