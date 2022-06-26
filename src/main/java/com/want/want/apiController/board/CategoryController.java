package com.want.want.apiController.board;

import com.want.want.common.WantResBody;
import com.want.want.dto.category.CategoryListDto;
import com.want.want.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("")
    public ResponseEntity<WantResBody> getCategoryList() {
        List<CategoryListDto> result = categoryService.findCategoryList();
        return ResponseEntity.ok(WantResBody.success(result));
    }
}
