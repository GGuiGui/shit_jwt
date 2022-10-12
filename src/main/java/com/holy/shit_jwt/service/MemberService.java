package com.holy.shit_jwt.service;

import com.holy.shit_jwt.entity.Member;
import com.holy.shit_jwt.repository.MemberRepository;
import com.holy.shit_jwt.util.SecurityUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional(readOnly = true)
    public Member getMemberInfo(String email) {
        return memberRepository.findByEmail(email).orElseThrow(
                () -> new RuntimeException("유저 정보가 없습니다.")
        );
    }

    // 현재 SecurityContext 에 있는 유저 정보 가져오기
    @Transactional(readOnly = true)
    public Member getMyInfo() {
        return memberRepository.findById(
                SecurityUtil.getCurrentMemberId())
                .orElseThrow(() -> new RuntimeException("로그인 유저 정보가 없습니다.")
        );
    }
}