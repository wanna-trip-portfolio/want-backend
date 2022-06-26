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
    public ResponseEntity<WantResBody> getPosts(@PathVariable Long id) {
        BoardListDto result = boardService.findPosts(id);
        return ResponseEntity.ok(WantResBody.success(result));
    }*/

}
