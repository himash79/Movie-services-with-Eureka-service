package com.wmp.dto;

import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomerDto {

    private String firstName;
    private String lastName;
    private String email;
    private String contactNumber;
    private String username;
    private String password;
    private String status;

}
