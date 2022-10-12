package com.holy.shit_jwt.controller;

import com.holy.shit_jwt.common.CommonResponse;
import com.holy.shit_jwt.controller.dto.BoardDto;
import com.holy.shit_jwt.controller.dto.CommentDto;
import com.holy.shit_jwt.service.ModifyService;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpHeaders;

@RestController
@RequestMapping("/modify")
@RequiredArgsConstructor
public class ModifyController {
    private final ModifyService modifyService;

    @PostMapping("/board")
    public CommonResponse addBoard(Authentication authentication, @RequestBody BoardDto boardDto) {//게시글 추가
        return new CommonResponse(modifyService.addBoard(boardDto));
    }

    @PutMapping("/board/{id}")//게시글 수정
    public CommonResponse modifyBoard(@PathVariable Long id, @RequestBody BoardDto boardDto) {
        System.out.println(id);
        return new CommonResponse(modifyService.modifyBoard(id, boardDto));
    }

    @DeleteMapping("/board/{id}")//게시글 삭제
    public CommonResponse deleteBoard(@PathVariable Long id) {
        return new CommonResponse(modifyService.deleteBoard(id));
    }

    @PostMapping("/comment")
    public CommonResponse addComment(@RequestBody CommentDto commentDto) {
        return new CommonResponse(modifyService.addComment(commentDto));
    }

    @PutMapping("/comment/{id}")
    public CommonResponse modifyComment(@PathVariable Long id, @RequestBody CommentDto commentDto) {
        return new CommonResponse(modifyService.modifyComment(id, commentDto));
    }

    @DeleteMapping("/comment/{id}")
    public CommonResponse deleteComment(@PathVariable Long id) {
        return new CommonResponse(modifyService.deleteComment(id));
    }
}
