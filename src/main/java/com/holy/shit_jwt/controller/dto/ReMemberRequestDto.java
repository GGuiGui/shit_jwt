package com.holy.shit_jwt.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.regex.Pattern;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReMemberRequestDto extends MemberRequestDto{
    private String repassword;

    public String checkAll(){
        String id = super.getEmail();
        String pw = super.getPassword();
        if(!pw.equals(this.repassword)) return "비밀번호 다름";
        if(!(pw.length() > 3 && pw.length() < 33))  return "비밀번호 길이 확인";
        if(!(id.length() > 3 && id.length() < 13))   return "아이디 길이 확인";
        if(!Pattern.matches("^[a-zA-Z0-9]*$", id))   return "id 형식 다시 확인";
        if(!Pattern.matches("^[a-zA-Z0-9]*$", pw))   return "password 형식 다시 확인";
        return "";
    }
}
