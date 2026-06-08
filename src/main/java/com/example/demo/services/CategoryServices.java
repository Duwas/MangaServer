package com.example.demo.services;

import com.example.demo.dto.Category.CategoryRequest;
import com.example.demo.dto.Category.CategoryResponse;
import com.example.demo.models.Manga.Category;
import com.example.demo.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServices {

    private final CategoryRepository categoryRepository;

    public CategoryResponse createCategory(CategoryRequest request) {
        Category category = new Category();
        category.setName(request.getName());

        Category saved = categoryRepository.save(category);

        CategoryResponse response = new CategoryResponse();
        response.setId(saved.getId());
        response.setName(saved.getName());

        return response;
    }

    public List<CategoryResponse> getAllCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(category -> {
                    CategoryResponse response = new CategoryResponse();
                    response.setId(category.getId());
                    response.setName(category.getName());
                    return response;
                })
                .toList();
    }
}