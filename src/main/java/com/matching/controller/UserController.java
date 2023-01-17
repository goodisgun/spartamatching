package com.matching.controller;

import com.matching.dto.*;
import com.matching.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @PostMapping("/signup")
    public SignupResponseDto signup(@RequestBody SignupRequestDto signupRequestDto) {
        return userService.signup(signupRequestDto);
    }

    @PostMapping("/clientlogin")
    public LoginResponseDto clientLogin(@RequestBody LoginRequestDto loginRequestDto, HttpServletResponse response) {
        return userService.clientLogin(loginRequestDto,response);
    }

    @PostMapping("/adminlogin")
    public LoginResponseDto adminLogin(@RequestBody LoginRequestDto loginRequestDto, HttpServletResponse response) {
        return userService.adminLogin(loginRequestDto,response);
    }

    @PostMapping("/logout")
    public LogoutResponseDto logout(HttpServletResponse response) {
        return userService.logout(response);
    }
}
