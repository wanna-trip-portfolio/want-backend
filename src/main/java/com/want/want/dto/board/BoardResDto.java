package com.want.want.dto.board;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BoardResDto {

    private Long boardId;
    private Long typeId;
    private String title;
    private String content;
    private int hit;
    private int heart;

}
