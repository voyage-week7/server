package com.example.catchtable.controller;

import com.example.catchtable.dto.user.MyPageResponseDto;
import com.example.catchtable.dto.user.MyPageUpdateDto;
import com.example.catchtable.security.UserDetailsImpl;
import com.example.catchtable.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class MyPageController {

    private final UserService userService;

    // 마이페이지  --> OK
    @GetMapping("/api/users")
    public MyPageResponseDto getMyPage(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        String userId = userDetails.getUser().getId();
        return userService.getMyPage(userId);
    }

    // 유저정보 수정 --> OK --> validation 설정해야함
    @PatchMapping("/api/users")
    public MyPageResponseDto updateMyPage(@RequestBody MyPageUpdateDto myPageUpdateDto,
                                          @AuthenticationPrincipal UserDetailsImpl userDetails) {
        String userId = userDetails.getUser().getId();
        return userService.updateMyPage(myPageUpdateDto, userId);
    }


//    @PostMapping("api/images")
//    public ResponseEntity<?> uploadImage(@RequestPart(value = "file", required = false) List<MultipartFile> files) throws IOException {
//        List<String> imgUrls = s3Service.upload(files);
//        return new ResponseEntity<>(imgUrls, HttpStatus.valueOf(201));
//    }
//
//    @DeleteMapping("api/images")
//    public ResponseEntity<?> deleteImage(@RequestBody Map<String, String> imgUrlMap){
//        String imgUrl = imgUrlMap.get("imgUrl");
//        System.out.println(imgUrl);
//        s3Service.delete(imgUrl);
//        return new ResponseEntity<>(HttpStatus.valueOf(204));
//    }
}
