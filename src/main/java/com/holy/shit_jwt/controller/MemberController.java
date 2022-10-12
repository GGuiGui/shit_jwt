package com.holy.shit_jwt.controller;

import com.holy.shit_jwt.common.CommonResponse;
import com.holy.shit_jwt.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/me")
    public CommonResponse getMyMemberInfo() {
        return new CommonResponse(memberService.getMyInfo());
    }

    @GetMapping("/{email}")
    public CommonResponse getMemberInfo(@PathVariable String email) {
        return new CommonResponse(memberService.getMemberInfo(email));
    }
}