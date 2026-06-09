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

        if (categoryRepository.existsByName(request.getName())) {
            throw new RuntimeException("Thể loại đã tồn tại");
        }

        Category category = new Category();
        category.setName(request.getName());

        Category saved = categoryRepository.save(category);

        return toResponse(saved);
    }

    public List<CategoryResponse> getAllCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public CategoryResponse updateCategory(Long id, CategoryRequest request) {

        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy thể loại"));

        category.setName(request.getName());

        Category saved = categoryRepository.save(category);

        return toResponse(saved);
    }

    public void deleteCategory(Long id) {

        if (!categoryRepository.existsById(id)) {
            throw new RuntimeException("Không tìm thấy thể loại");
        }

        categoryRepository.deleteById(id);
    }

    private CategoryResponse toResponse(Category category) {

        CategoryResponse response = new CategoryResponse();

        response.setId(category.getId());
        response.setName(category.getName());

        return response;
    }
}