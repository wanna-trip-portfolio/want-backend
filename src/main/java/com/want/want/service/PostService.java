package com.want.want.service;

import com.want.want.common.MemberInfo;
import com.want.want.domain.Board;
import com.want.want.domain.Member;
import com.want.want.domain.Post;
import com.want.want.dto.board.PostResDto;
import com.want.want.dto.post.PostReqDto;
import com.want.want.repository.BoardRepository;
import com.want.want.repository.MemberRepository;
import com.want.want.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;

    public PostResDto findById(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 글이 존재하지 않습니다."));

        updateHit(id);

        return new PostResDto(post);
    }

    private int updateHit(Long id) {
        return postRepository.updateHit(id);
    }

    public void createPost(PostReqDto reqDto, MemberInfo memberInfo) {

        Board board = boardRepository.findById(reqDto.getBoardId())
                .orElseThrow(() -> new IllegalArgumentException("해당 게시판이 존재하지 않습니다."));

        Member member = memberRepository.findById(memberInfo.getMemberId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));

        postRepository.save(reqDto.toEntity(member, board));
    }

/*    @Transactional
    public void createPost(Long boardId, PostReqDto reqDto, MemberInfo memberInfo) {
        Board board = boardRepository.findById(boardId)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시판이 존재하지 않습니다."));

        PostReqDto req = PostReqDto.builder()
                .board(board)
                .title(reqDto.getTitle())
                .content(reqDto.getContent())
                .memberInfo(memberInfo)
                .build();

        postRepository.save(req.toEntity(board));
    }*/
}
