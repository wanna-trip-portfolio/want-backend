package com.want.want.service.board;

import com.want.want.domain.board.Board;
import com.want.want.dto.board.BoardListDto;
import com.want.want.dto.board.BoardReqDto;
import com.want.want.dto.board.BoardResDto;
import com.want.want.repository.board.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public List<BoardListDto> findBoardList(String boardType) {
        return boardRepository.findAllByBoardType(boardType).stream()
                .map(BoardListDto::new)
                .collect(Collectors.toList());
    }

    public BoardResDto findBoardDetail(String boardType, Long boardId) {
        Board board = boardRepository.findByBoardTypeAndBoardId(boardType, boardId);
        return new BoardResDto(board);
    }

    public void createBoardDetail(String boardType, BoardReqDto reqDto) {
        Board board = new Board(boardType, reqDto);
        boardRepository.save(board);
    }
}
