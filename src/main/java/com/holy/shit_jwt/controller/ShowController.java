package com.holy.shit_jwt.controller;


import com.holy.shit_jwt.common.CommonResponse;
import com.holy.shit_jwt.service.ShowService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/show")
@RequiredArgsConstructor
public class ShowController {
    private final ShowService showService;

    @GetMapping("/board")
    public CommonResponse getPosts() {
        return new CommonResponse(showService.getPosts());
    }

    @GetMapping("/board/{id}")
    public CommonResponse getPost(@PathVariable Long id) {
        return new CommonResponse(showService.getPost(id));
    }

    @GetMapping("/comments")
    public CommonResponse getComments(){
        return new CommonResponse(showService.getComments());
    }
}
