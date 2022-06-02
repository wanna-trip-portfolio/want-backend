package com.want.want.repository.board;

import com.want.want.domain.board.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {

    Board findByBoardTypeAndBoardId(String boardType, Long boardId);

    List<Board> findAllByBoardType(String boardType);
}
