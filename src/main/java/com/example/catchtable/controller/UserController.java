package com.example.catchtable.controller;

import com.example.catchtable.dto.review.ReviewRequestDto;
import com.example.catchtable.dto.user.SignUpRequestDto;
import com.example.catchtable.model.User;
import com.example.catchtable.repository.UserRepository;
import com.example.catchtable.security.UserDetailsImpl;
import com.example.catchtable.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;

    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }


    // 회원가입
    @PostMapping("/api/signup")
    public ResponseEntity<?> signup(@RequestBody @Valid SignUpRequestDto requestDto) {
        userService.signup(requestDto);
        return new ResponseEntity<>("회원가입 성공", HttpStatus.valueOf(201));
    }


    // 회원가입 - ID 중복체크
    @GetMapping("/api/users/{id}")
    public ResponseEntity<?>usersIdCheck(@PathVariable String id) {
        return userService.usersIdCheck(id);
    }


    // 로그인(Security 이용) = ("/api/signin")



    // 회원 탈퇴
    @DeleteMapping("/api/users")
    public ResponseEntity<?> deleteUser(@AuthenticationPrincipal UserDetailsImpl userDetails) {
       userService.deleteUser(userDetails);
       return new ResponseEntity<>("회원 탈퇴", HttpStatus.valueOf(201));
    }



}
