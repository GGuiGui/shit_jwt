package com.holy.shit_jwt.repository;

import com.holy.shit_jwt.entity.Board;
import com.holy.shit_jwt.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
    //해당 멤버의 게시글 수정에서 값을 가져와서 바꾸어야 되기때문에 필요
    Board findByMemberAndId(Member member, Long id);
}
