package com.want.want.dto.board;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BoardReqDto {

    private Long typeId;
    private Long memberId;
    private String title;
    private String content;

}
