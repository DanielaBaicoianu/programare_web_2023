package com.example.laborator4.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class UserOrderDTO {
    private String username;
    private String email;
    private String productName;
    private Integer quantity;
    private Float price;
}
