package com.want.want.domain.board;

import com.want.want.constant.BoardType;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@Entity
@Table(name = "board")
@Data
@DynamicInsert
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long boardId;

    //private Member member;
    //private Nation nation;

    @Enumerated(EnumType.STRING)
    private BoardType boardType;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @ColumnDefault("'0'")
    private int hit;

    @ColumnDefault("'0'")
    private int heart;
}
