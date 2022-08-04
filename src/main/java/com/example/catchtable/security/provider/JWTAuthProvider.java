package com.example.catchtable.security.provider;

//import com.team2.cafein.config.auth.UserDetailsImpl;
//import com.team2.cafein.config.jwt.JwtDecoder;
//import com.team2.cafein.config.jwt.JwtPreProcessingToken;
//import com.team2.cafein.model.User;
//import com.team2.cafein.repository.UserRepository;
import com.example.catchtable.model.User;
import com.example.catchtable.repository.UserRepository;
import com.example.catchtable.security.UserDetailsImpl;
import com.example.catchtable.security.jwt.JwtDecoder;
import com.example.catchtable.security.jwt.JwtPreProcessingToken;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JWTAuthProvider implements AuthenticationProvider {

    private final JwtDecoder jwtDecoder;

    private final UserRepository userRepository;

    @Override
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {
        String token = (String) authentication.getPrincipal();
        String username = jwtDecoder.decodeUsername(token);

        // TODO: API 사용시마다 매번 User DB 조회 필요
        //  -> 해결을 위해서는 UserDetailsImpl 에 User 객체를 저장하지 않도록 수정
        //  ex) UserDetailsImpl 에 userId, username, role 만 저장
        //    -> JWT 에 userId, username, role 정보를 암호화/복호화하여 사용
//        User user = userRepository.findByLoginId(username);
        User user = userRepository.findById(username).orElseThrow(
                () -> new NullPointerException("없는 회원입니다."));
        UserDetailsImpl userDetails = new UserDetailsImpl(user);
        return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return JwtPreProcessingToken.class.isAssignableFrom(authentication);
    }
}
