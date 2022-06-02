package com.want.want.apiController.board;

import com.want.want.common.DataStatusMessage;
import com.want.want.common.WantResBody;
import com.want.want.dto.board.BoardListDto;
import com.want.want.dto.board.BoardReqDto;
import com.want.want.dto.board.BoardResDto;
import com.want.want.service.board.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @version 1.0
 */
@RestController
@RequestMapping("/boards")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;


    @GetMapping("/{boardType}")
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
    }

}
