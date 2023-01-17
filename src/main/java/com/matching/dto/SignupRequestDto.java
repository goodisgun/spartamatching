package com.matching.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupRequestDto {
    private String username;
    private String password;
    private String nickname;
    private String image;
    private boolean isAdmin;
    private String adminToken;
}
