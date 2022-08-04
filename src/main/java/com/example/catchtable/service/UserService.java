package com.example.catchtable.service;

import com.example.catchtable.dto.user.MyPageResponseDto;
import com.example.catchtable.dto.user.MyPageUpdateDto;
import com.example.catchtable.dto.user.SignUpRequestDto;
import com.example.catchtable.model.User;
import com.example.catchtable.repository.UserRepository;
import com.example.catchtable.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;
    public final BCryptPasswordEncoder passwordEncoder;

    /**
     * 마이 페이지
     */
    public MyPageResponseDto getMyPage(String userId) {

        // 사용자 확인
        User foundUer = userRepository.findById(userId).orElseThrow(
                () -> new NullPointerException("존재하지 않는 사용자입니다"));

        return new MyPageResponseDto(foundUer);
    }

    /**
     * 사용자 정보 수정
     */
    @Transactional
    public MyPageResponseDto updateMyPage(MyPageUpdateDto myPageUpdateDto, String userId) {

        // 사용자 확인
        User foundUer = userRepository.findById(userId).orElseThrow(
                () -> new NullPointerException("존재하지 않는 사용자입니다"));
        // 사용자 데이터 정보 업데이트
        foundUer.updateUser(myPageUpdateDto);

        return new MyPageResponseDto(myPageUpdateDto, foundUer);
    }

    // 회원가입
    @Transactional
    public void signup(SignUpRequestDto requestDto) {
        String id = requestDto.getId();
        String pw = passwordEncoder.encode(requestDto.getPw());
        String username = requestDto.getUsername();

        User user = new User(id, pw, username, "ROLE_USER");
        if (userRepository.findById(id).isPresent()){
            throw new IllegalArgumentException("이미 존재하는 아이디 입니다.");
        }
        userRepository.save(user);
    }

    // ID 중복확인
    public ResponseEntity<?> usersIdCheck(String checkDto) {
        if (userRepository.findById(checkDto).isPresent())
            return new ResponseEntity<>("중복된 ID입니다" , HttpStatus.BAD_REQUEST);
        else return new ResponseEntity<>("사용가능한 ID입니다", HttpStatus.OK);
    }



    // 회원 탈퇴
    @Transactional
    public ResponseEntity<?> deleteUser(UserDetailsImpl userDetails) {
        userRepository.deleteById(userDetails.getUser().getId());
        return new ResponseEntity<>("회원탈퇴",HttpStatus.OK );
    }




}
