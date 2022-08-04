package com.example.catchtable.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
// 마이페이지 정보 수정 요청 Dto
public class MyPageUpdateDto {

    private String username;         // 사용자 이름
    private String profileUrl;       // 프로필 이미지
    private String description;      // 자기소개
    private String region;           // 활동지역;
    private Integer phone;           // 01012345678
    private String gender;           // ’F’ | ‘M’,
    private Date birth;              // 2003-02-23,
    private Integer priceMin;        // 최소 가격
    private Integer priceMax;        // 최대 가격

}
