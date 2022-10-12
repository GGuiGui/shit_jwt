package com.holy.shit_jwt.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.holy.shit_jwt.common.Timestamped;
import com.holy.shit_jwt.controller.dto.BoardDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "boarder")
public class Board extends Timestamped {

    @Id
    @Column(name = "boarder_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy="boarder")
    private List<Comments> comment;

    @ManyToOne(targetEntity = Member.class, fetch = FetchType.LAZY)
    @JoinColumn(name="member_id")
    @JsonIgnore
    private Member member;

    public Board(Member member, BoardDto boardDto){
        this.member = member;
        this.title = boardDto.getTitle();
        this.content = boardDto.getContent();
    }
}
