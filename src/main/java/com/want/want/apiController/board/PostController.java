package com.want.want.apiController.board;

import com.want.want.common.DataStatusMessage;
import com.want.want.common.InfoMember;
import com.want.want.common.MemberInfo;
import com.want.want.common.WantResBody;
import com.want.want.dto.post.PostReqDto;
import com.want.want.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    /*@GetMapping("/{boardId}/list")
    public ResponseEntity<WantResBody> getPostList(@PathVariable Long boardId) {
        List<PostListDto> result = postService.findPostList(boardId);
        return ResponseEntity.ok(WantResBody.success(result));
    }*/

    @PostMapping("/{boardId}")
    public ResponseEntity<WantResBody> createPost(@PathVariable Long boardId,
                                                  @RequestBody PostReqDto reqDto,
                                                  @InfoMember MemberInfo memberInfo) {
        postService.createPost(boardId, reqDto, memberInfo);
        return ResponseEntity.ok(WantResBody.success(DataStatusMessage.INSERT_SUCCESS));
    }
}