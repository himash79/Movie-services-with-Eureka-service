package com.wmp.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdminDto {

    private String firstName;
    private String lastName;
    private String email;
    private String contactNumber;
    private String status;
    private String username;
    private String password;

}
