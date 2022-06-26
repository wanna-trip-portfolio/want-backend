package com.want.want.dto.post;

import com.want.want.common.MemberInfo;
import com.want.want.domain.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostReqDto {

    private Long boardId;
    private Long memberId;
    private String title;
    private String content;

    @Builder
    public PostReqDto(Long boardId, MemberInfo memberInfo, String title, String content) {
        this.boardId = boardId;
        this.memberId = memberInfo.getMemberId();
        this.title = title;
        this.content = content;
    }

    public Post toEntity(MemberInfo memberInfo) {
        return Post.builder()
                .memberId(memberInfo.getMemberId())
                .boardId(boardId)
                .title(title)
                .content(content)
                .build();
    }

}
