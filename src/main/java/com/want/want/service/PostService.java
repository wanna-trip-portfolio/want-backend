package com.want.want.service;

import com.want.want.common.MemberInfo;
import com.want.want.domain.Board;
import com.want.want.dto.post.PostReqDto;
import com.want.want.exception.BoardNotFoundException;
import com.want.want.repository.BoardRepository;
import com.want.want.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final BoardRepository boardRepository;

/*    public List<PostListDto> findPostList(Long boardId) {
        return postRepository.findByBoardId(boardId);
    }*/

    @Transactional
    public void createPost(Long boardId, PostReqDto reqDto, MemberInfo memberInfo) {
        Board board = boardRepository.findById(boardId)
                .orElseThrow(BoardNotFoundException::new);

        PostReqDto req = PostReqDto.builder()
                .board(board)
                .title(reqDto.getTitle())
                .content(reqDto.getContent())
                .memberInfo(memberInfo)
                .build();

        postRepository.save(req.toEntity(board));
    }
}
