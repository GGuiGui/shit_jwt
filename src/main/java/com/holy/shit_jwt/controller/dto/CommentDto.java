package com.holy.shit_jwt.controller.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CommentDto {
    Long postid;
    String content;
}
