package com.want.want.dto.category;

import com.want.want.domain.Category;
import com.want.want.dto.board.BoardListDto;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class CategoryListDto {

    private Long categoryId;
    private String categoryName;
    private List<BoardListDto> board;

    public CategoryListDto(Category category) {
        this.categoryId = category.getId();
        this.categoryName = category.getCategoryName();
        this.board = category.getBoard().stream().map(BoardListDto::new).collect(Collectors.toList());
    }
}
