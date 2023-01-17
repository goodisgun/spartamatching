package com.matching.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LogoutResponseDto {
    private String message;

    public LogoutResponseDto(String message) {
        this.message = message;
    }
}
