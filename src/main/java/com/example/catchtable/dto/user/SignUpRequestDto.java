package com.example.catchtable.dto.user;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter @Setter
public class SignUpRequestDto {

    private String id;

    @NotBlank
    @Pattern(regexp = "(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,16}",
             message = "비밀번호는 영문 대,소문자와 특수기호가 적어도 1개 이상씩 포함된 8자 ~ 20자의 비밀번호여야 합니다.")
    @Size(min = 8, message = "아이디를 8~16자로 입력해주세요")
    private String pw;

    // 실패의 흔적
//    (?=.*\\W) - 특수문자 적어도 하나
//    (?=.*[0-9]) - 숫자 적어도 하나
//    (?=.*[a-zA-Z]) -영문 대,소문자중 적어도 하나

    @NotBlank(message = "이름을 작성해주세요.")
    private String username;
}
