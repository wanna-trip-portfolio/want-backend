package com.want.want.service;

import com.want.want.dto.board.BoardListDto;
import com.want.want.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public List<BoardListDto> findBoardList() {
        return boardRepository.findAll().stream()
                .map(BoardListDto::new)
                .collect(Collectors.toList());
    }

}
