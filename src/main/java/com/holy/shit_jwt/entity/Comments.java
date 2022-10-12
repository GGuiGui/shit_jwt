package com.holy.shit_jwt.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.holy.shit_jwt.common.Timestamped;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "comments")
@Entity
public class Comments extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String comment;

    @ManyToOne(optional = false)
    @JoinColumn(name="boarder_id")
    @JsonIgnore
    private Board boarder;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String author;

    public Comments(Board board, String comment, Member member){
        this.boarder = board;
        this.comment = comment;
        this.author = member.getEmail();
    }
}
