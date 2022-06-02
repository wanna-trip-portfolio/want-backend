package com.want.want.dto.board;

import com.want.want.domain.board.Board;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BoardListDto {

    private Long boardId;
    private String boardType;
    private String title;
    private String content;

    public BoardListDto(Board board) {
        this.boardId = board.getBoardId();
        this.boardType = board.getBoardType();
        this.title = board.getTitle();
        this.content = board.getContent();
    }
}
