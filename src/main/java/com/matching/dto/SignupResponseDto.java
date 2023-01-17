package com.matching.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupResponseDto {
    private String message;

    public SignupResponseDto(String message) {
        this.message = message;
    }
}
