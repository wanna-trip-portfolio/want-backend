package com.want.want.apiController.board;

import com.want.want.common.WantResBody;
import com.want.want.dto.board.BoardListDto;
import com.want.want.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @version 1.0
 */
@RestController
@RequestMapping("/boards")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("")
    public ResponseEntity<WantResBody> getBoardList() {
        List<BoardListDto> result = boardService.findBoardList();
        return ResponseEntity.ok(WantResBody.success(result));
    }

    /*@GetMapping("/{id}")
    public ResponseEntity<WantResBody> getPostsList(@PathVariable Long id) {
        List<PostListDto> result = boardService.findPostList(id);
        return ResponseEntity.ok(WantResBody.success(result));
    }*/

/*    @GetMapping("/category")
    public ResponseEntity<WantResBody> getCategoryList() {
        List<CategoryListDto> result = boardService.findCategoryList();
        return ResponseEntity.ok(WantResBody.success(result));
    }

    @GetMapping("/board")
    public ResponseEntity<WantResBody> getBoardList() {
        List<BoardListDto> result = boardService.findBoardList();
        return ResponseEntity.ok(WantResBody.success(result));
    }

    @GetMapping("/{boardId}")
    public ResponseEntity<WantResBody> getBoardPost(@PathVariable Long boardId) {
        BoardResDto result = boardService.findBoardPost(boardId);
        return ResponseEntity.ok(WantResBody.success(result));
    }

    @PostMapping("")
    public ResponseEntity<WantResBody> createPost(@RequestBody BoardReqDto reqDto,
                                                  @InfoMember MemberInfo memberInfo) {
        boardService.createPost(reqDto, memberInfo);
        return ResponseEntity.ok(WantResBody.success(DataStatusMessage.INSERT_SUCCESS));
    }*/

    /*@GetMapping("/{boardType}")
    public ResponseEntity<WantResBody> getBoardList(@PathVariable String boardType) {
        List<BoardListDto> result = boardService.findBoardList(boardType);
        return ResponseEntity.ok(WantResBody.success(result));
    }

    @GetMapping("/{boardType}/{boardId}")
    public ResponseEntity<WantResBody> getBoardDetail(@PathVariable String boardType,
                                                      @PathVariable Long boardId) {
        BoardResDto result = boardService.findBoardDetail(boardType, boardId);
        return ResponseEntity.ok(WantResBody.success(result));
    }

    @PostMapping("/{boardType}")
    public ResponseEntity<WantResBody> postBoardDetail(@PathVariable String boardType,
                                                       @ModelAttribute BoardReqDto reqDto) {
        boardService.createBoardDetail(boardType, reqDto);
        return ResponseEntity.ok(WantResBody.success(DataStatusMessage.INSERT_SUCCESS));
    }*/

}
