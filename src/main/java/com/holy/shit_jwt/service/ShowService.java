package com.holy.shit_jwt.service;

import com.holy.shit_jwt.entity.Board;
import com.holy.shit_jwt.entity.Comments;
import com.holy.shit_jwt.repository.BoardRepository;
import com.holy.shit_jwt.repository.CommentsRpository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShowService {
    private final CommentsRpository commentsRpository;
    private final BoardRepository boardRepository;

    @Transactional(readOnly = true)
    public List<Board> getPosts(){
        return boardRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Board> getPost(Long id){
        return boardRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public List<Comments> getComments(){
        return commentsRpository.findAll();
    }
}
