package com.holy.shit_jwt.repository;

import com.holy.shit_jwt.entity.Board;
import com.holy.shit_jwt.entity.Comments;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CommentsRpository extends JpaRepository<Comments, Long> {

    //특정게시물의 특정 댓글 조회
    Comments findAllByBoarderAndId(Board board, Long id);

    Comments findByAuthorAndId(String author, Long id);
}
