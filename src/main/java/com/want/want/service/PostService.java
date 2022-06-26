package com.want.want.service;

import com.want.want.common.MemberInfo;
import com.want.want.dto.post.PostReqDto;
import com.want.want.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

/*    public List<PostListDto> findPostList(Long boardId) {
        return postRepository.findByBoardId(boardId);
    }*/

    public void createPost(PostReqDto reqDto, MemberInfo memberInfo) {
        postRepository.save(reqDto.toEntity(memberInfo));
    }
}
