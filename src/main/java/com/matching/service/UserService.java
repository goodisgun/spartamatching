package com.matching.service;

import com.matching.dto.*;
import com.matching.entity.Admin;
import com.matching.entity.Client;
import com.matching.jwt.JwtUtil;
import com.matching.repository.AdminRepository;
import com.matching.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final AdminRepository adminRepository;
    private final ClientRepository clientRepository;
    private final JwtUtil jwtUtil;
    private static final String ADMIN_TOKEN = "AAABnvxRVklrnYxKZ0aHgTBcXukeZygoC";

    @Transactional
    public SignupResponseDto signup(SignupRequestDto signupRequestDto) {
        String username = signupRequestDto.getUsername();

        Optional<Client> foundClient = clientRepository.findByUsername(username);
        Optional<Admin> foundAdmin = adminRepository.findByUsername(username);

        if(foundClient.isPresent() || foundAdmin.isPresent()) {
            return new SignupResponseDto("중복된 사용자가 존재합니다");
        }

        if (signupRequestDto.isAdmin()) {
            if(!signupRequestDto.getAdminToken().equals(ADMIN_TOKEN)) {
                return new SignupResponseDto("관리자 암호가 틀려서 등록이 불가능합니다.");
            }
            Admin admin = new Admin(signupRequestDto);
            adminRepository.save(admin);
            return new SignupResponseDto("관리자 회원가입에 성공했습니다.");
        }

        Client client = new Client(signupRequestDto);
        clientRepository.save(client);
        return new SignupResponseDto("회원가입에 성공했습니다.")
    }

    @Transactional(readOnly = true)
    public LoginResponseDto clientLogin(LoginRequestDto loginRequestDto, HttpServletResponse response) {
        if(foundAdmin.isPresent()) {
            return adminLogin(loginRequestDto, response);
        }

        String username = loginRequestDto.getUsername();
        String password = loginRequestDto.getPassword();

        Optional<Admin> foundAdmin = adminRepository.findByUsername(username);

        Client client = clientRepository.findByUsername(username).orElseThrow(
                () -> new NullPointerException("회원을 찾을 수 없습니다.")
        );

        if(!client.getPassword().equals(password)) {
            return new LoginResponseDto("비밀번호가 일치하지 않습니다.");
        }
        response.addHeader(JwtUtil.AUTHORIZATION_HEADER, jwtUtil.createToken(client.getUsername()));

        return new LoginResponseDto("로그인성공!");
    }

    @Transactional(readOnly = true)
    public LoginResponseDto adminLogin(LoginRequestDto loginRequestDto,HttpServletResponse response) {
        String username = loginRequestDto.getUsername();
        String password = loginRequestDto.getPassword();

        Admin admin = clientRepository.findByUsername(username).orElseThrow(
                () -> new NullPointerException("회원을 찾을 수 없습니다.")
        );

        if(!admin.getPassword().equals(password)) {
            return new LoginResponseDto("비밀번호가 일치하지 않습니다.");
        }
        response.addHeader(JwtUtil.AUTHORIZATION_HEADER, jwtUtil.createToken(admin.getUsername()));

        return new LoginResponseDto("로그인성공!");
    }

    @Transactional
    public LogoutResponseDto logout(HttpServletResponse response) {
        //response. 추후에 수정
        return new LogoutResponseDto("로그아웃성공!");
    }
}
