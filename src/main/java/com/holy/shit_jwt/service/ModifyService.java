package com.holy.shit_jwt.service;

import com.holy.shit_jwt.controller.dto.BoardDto;
import com.holy.shit_jwt.controller.dto.CommentDto;
import com.holy.shit_jwt.entity.Board;
import com.holy.shit_jwt.entity.Comments;
import com.holy.shit_jwt.entity.Member;
import com.holy.shit_jwt.repository.BoardRepository;
import com.holy.shit_jwt.repository.CommentsRpository;
import com.holy.shit_jwt.repository.MemberRepository;
import com.holy.shit_jwt.util.SecurityUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class ModifyService {
    private final MemberRepository memberRepository;
    private final BoardRepository boardRepository;
    private final CommentsRpository commentsRpository;

    @Transactional
    public Board addBoard(BoardDto boardDto) {
        Member member = memberRepository.findById(
                SecurityUtil.getCurrentMemberId())
                .orElseThrow(() -> new RuntimeException("해당 아이디가 없습니다.")
                );
        Board board = new Board(member, boardDto);
        boardRepository.save(board);
        return board;
    }

    // 현재 SecurityContext 에 있는 유저 정보 가져오기
    @Transactional
    public Board modifyBoard(Long board_id, BoardDto boardDto) {
        Member member = memberRepository.findById(
                        SecurityUtil.getCurrentMemberId())
                .orElseThrow(() -> new RuntimeException("해당 아이디가 없습니다.")
                );
        Board board = boardRepository.findByMemberAndId(member, board_id);
        if(board.getTitle().isEmpty())  new RuntimeException("해당 게시글을 없거나 수정할 수 없습니다.");

        board.setTitle(boardDto.getTitle());
        board.setContent(boardDto.getContent());
        boardRepository.save(board);
        return board;
    }

    @Transactional
    public Board deleteBoard(Long board_id){
        Member member = memberRepository.findById(
                        SecurityUtil.getCurrentMemberId())
                .orElseThrow(() -> new RuntimeException("해당 아이디가 없습니다.")
                );
        Board board = boardRepository.findByMemberAndId(member, board_id);
        if(board.getTitle().isEmpty())  new RuntimeException("해당 게시글을 없거나 삭제가 불가능 합니다.");

        boardRepository.delete(board);
        return board;
    }

    @Transactional
    public Comments addComment(CommentDto commentDto){
        Member member = memberRepository.findById(
                        SecurityUtil.getCurrentMemberId())
                .orElseThrow(() -> new RuntimeException("해당 아이디가 없습니다.")
                );
        Board board = boardRepository.findById(commentDto.getPostid())
                .orElseThrow(() -> new RuntimeException("해당 포스트가 없습니다.")
                );

        Comments comments = new Comments(board,
                commentDto.getContent(),
                member);

        commentsRpository.save(comments);
        return comments;
    }

    @Transactional
    public Comments modifyComment(Long comment_id, CommentDto commentDto){
        Member member = memberRepository.findById(
                        SecurityUtil.getCurrentMemberId())
                .orElseThrow(() -> new RuntimeException("해당 아이디가 없습니다.")
                );
        Board board = boardRepository.findById(commentDto.getPostid())
                .orElseThrow(() -> new RuntimeException("해당 포스트가 없습니다.")
                );

        Comments comment = commentsRpository.findAllByBoarderAndId(board, comment_id);

        if(comment.getAuthor().isEmpty())   throw new RuntimeException("해당 댓글이 없습니다.");
        else if(!comment.getAuthor().equals(member.getEmail()))  throw new RuntimeException("해당 댓글을 수정할 수 없습니다.");

        comment.setComment(commentDto.getContent());
        commentsRpository.save(comment);
        return comment;
    }

    @Transactional
    public Comments deleteComment(Long comment_id){
        Member member = memberRepository.findById(
                        SecurityUtil.getCurrentMemberId())
                .orElseThrow(() -> new RuntimeException("해당 아이디가 없습니다.")
                );
        Comments comment = commentsRpository.findByAuthorAndId(member.getEmail(), comment_id);
        commentsRpository.delete(comment);
        return comment;
    }
}
