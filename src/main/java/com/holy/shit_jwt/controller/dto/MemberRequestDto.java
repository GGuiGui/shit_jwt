package com.holy.shit_jwt.controller.dto;

import com.holy.shit_jwt.entity.Authority;
import lombok.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MemberRequestDto {

    private String email;
    private String password;
    private Authority authority;

    public MemberRequestDto(ReMemberRequestDto reMemberRequestDto, PasswordEncoder passwordEncoder){
        this.email = reMemberRequestDto.getEmail();
        this.password = passwordEncoder.encode(reMemberRequestDto.getRepassword());
        this.authority = Authority.ROLE_USER;
    }


    //토큰을 만드는 함수
    public UsernamePasswordAuthenticationToken toAuthentication() {
        return new UsernamePasswordAuthenticationToken(email, password);
    }
}