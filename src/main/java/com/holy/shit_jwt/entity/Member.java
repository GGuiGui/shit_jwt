package com.holy.shit_jwt.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.holy.shit_jwt.common.Timemake;
import com.holy.shit_jwt.controller.dto.MemberRequestDto;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor
@Table(name = "member")
@Entity
public class Member extends Timemake{

    @Id
    @Column(name = "member_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    @JsonIgnore
    private String password;

    @Enumerated(EnumType.STRING)
    private Authority authority;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "member")
    private List<Board> boards;

    @Builder
    public Member(String email, String password, Authority authority) {
        this.email = email;
        this.password = password;
        this.authority = authority;
    }

    public Member(MemberRequestDto memberRequestDto){
        this.email = memberRequestDto.getEmail();
        this.password = memberRequestDto.getPassword();
        this.authority = memberRequestDto.getAuthority();
    }
}