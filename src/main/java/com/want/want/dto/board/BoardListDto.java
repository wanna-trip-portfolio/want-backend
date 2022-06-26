package com.want.want.dto.board;

import com.want.want.domain.Board;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BoardListDto {

    private Long id;
    private String boardName;

    public BoardListDto(Board board) {
        this.id = board.getId();
        this.boardName = board.getBoardName();
    }

}
