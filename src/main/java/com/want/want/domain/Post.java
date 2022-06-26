package com.want.want.domain;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Table(name = "post")
@Getter
@NoArgsConstructor
public class Post extends BaseTime{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

    @NotNull
    private String title;

    @NotNull
    private String content;

    @ColumnDefault("'0'")
    private int hit;

    @ColumnDefault("'0'")
    private int heart;

    @Builder
    public Post(Long memberId, Long boardId, String title, String content) {
        this.title = title;
        this.content = content;
    }
}
