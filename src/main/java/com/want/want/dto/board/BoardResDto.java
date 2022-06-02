package com.want.want.dto.board;

import com.want.want.domain.board.Board;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BoardResDto {

    private Long boardId;
    private String boardType;
    private String title;
    private String content;
    private int hit;
    private int heart;

    public BoardResDto(Board board) {
        this.boardId = board.getBoardId();
        this.boardType = board.getBoardType();
        this.title = board.getBoardType();
        this.content = board.getContent();
        this.hit = board.getHit();
        this.heart = board.getHeart();
    }
}
