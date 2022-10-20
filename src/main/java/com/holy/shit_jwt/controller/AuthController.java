package com.holy.shit_jwt.controller;

import com.holy.shit_jwt.common.CommonResponse;
import com.holy.shit_jwt.controller.dto.*;
import com.holy.shit_jwt.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/signup")
    public CommonResponse signup(@RequestBody ReMemberRequestDto reMemberRequestDto) {
        return new CommonResponse(authService.signup(reMemberRequestDto));
    }

    @PostMapping("/login")
    public CommonResponse login(@RequestBody MemberRequestDto memberRequestDto) {
        return  new CommonResponse(authService.login(memberRequestDto));
    }

//    @PostMapping("/login")
//    //responseform의 헤드 세팅하는 방법
//    public CommonResponse login(@RequestBody MemberRequestDto memberRequestDto, HttpServletResponse response){
//        TokenDto tokenDto = authService.login(memberRequestDto);
//        CommonResponse commonResponse = new CommonResponse(tokenDto);
//        response.setHeader("AT", tokenDto.getAccessToken());
//        response.setHeader("RT", tokenDto.getRefreshToken());
//        return  commonResponse;
//    }

    @PostMapping("/reissue")
    public CommonResponse reissue(@RequestBody TokenRequestDto tokenRequestDto) {
        return new CommonResponse(authService.reissue(tokenRequestDto));
    }
}