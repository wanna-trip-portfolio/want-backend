package com.want.want.repository;

import com.want.want.domain.Post;
import com.want.want.dto.board.PostListDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<PostListDto> findAllById(Long boardId);

    List<PostListDto> findByBoardId(Long boardId);
}
