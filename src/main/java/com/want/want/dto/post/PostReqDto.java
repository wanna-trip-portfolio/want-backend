package com.want.want.dto.post;

import com.want.want.domain.Board;
import com.want.want.domain.Member;
import com.want.want.domain.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostReqDto {

    private Long boardId;
    private String title;
    private String content;
    private String nickName;

/*    @Builder
    public PostReqDto(Board board, MemberInfo memberInfo, String title, String content) {
        this.boardId = board.getId();
        this.memberId = memberInfo.getMemberId();
        this.title = title;
        this.content = content;
        this.nickName = memberInfo.getNickName();
    }

    public Post toEntity(Board board) {
        return Post.builder()
                .board(board)
                .title(title)
                .content(content)
                .nickName(nickName)
                .memberId(memberId)
                .build();
    }*/

/*    @Builder
    public PostReqDto(Long boardId, MemberInfo memberInfo, String title, String content) {
        this.boardId = boardId;
        this.title = title;
        this.content = content;
        this.nickName = memberInfo.getNickName();
    }*/

    public Post toEntity(Member member, Board board) {
        return Post.builder()
                .member(member)
                .board(board)
                .title(title)
                .content(content)
                .nickName(member.getNickName())
                .build();
    }

}
