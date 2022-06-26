package com.want.want.service;

import com.want.want.dto.category.CategoryListDto;
import com.want.want.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<CategoryListDto> findCategoryList() {
        return categoryRepository.findAll().stream()
                .map(CategoryListDto::new)
                .collect(Collectors.toList());
    }
}
