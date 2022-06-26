package com.want.want.dto.board;

import lombok.Builder;
import lombok.Getter;

@Getter
public class PostListDto {

    private Long id;
    private String title;
    private String createDate;

    private String nickName;

    @Builder
    public PostListDto(Long id, String title, String createDate, String nickName) {
        this.id = id;
        this.title = title;
        this.createDate = createDate;
        this.nickName = nickName;
    }
}
