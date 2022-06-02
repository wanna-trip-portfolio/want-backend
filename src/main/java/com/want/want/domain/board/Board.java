package com.want.want.domain.board;

import com.want.want.domain.member.Member;
import com.want.want.dto.board.BoardReqDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@Entity
@Table(name = "board")
@Getter @Setter
@NoArgsConstructor
@DynamicInsert
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long boardId;

    @ManyToOne
    @JoinColumn(name = "memberId")
    private Member member;

    //private Nation nation;

    private String boardType;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @ColumnDefault("'0'")
    private int hit;

    @ColumnDefault("'0'")
    private int heart;

    public Board(String boardType, BoardReqDto reqDto) {
        this.boardType = boardType;
        this.title = reqDto.getTitle();
        this.content = reqDto.getContent();
    }
}
