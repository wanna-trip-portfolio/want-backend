package com.want.want.dto.board;

import com.want.want.domain.Post;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostResDto {

    private Long id;
    private String title;
    private String content;
    private String nickName;
    private int hit;
    private LocalDateTime createDate;

    public PostResDto(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        //this.nickName = post.getNickName();
        this.hit = post.getHit();
        this.createDate = post.getCreateDate();
    }
}
