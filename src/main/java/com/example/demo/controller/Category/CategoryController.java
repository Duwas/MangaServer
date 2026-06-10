package com.example.demo.controller.Category;

import com.example.demo.dto.Category.CategoryRequest;
import com.example.demo.dto.Category.CategoryResponse;
import com.example.demo.services.CategoryServices;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryServices categoryServices;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public CategoryResponse createCategory(@RequestBody CategoryRequest request) {
        return categoryServices.createCategory(request);
    }

    @GetMapping("/All")
    public List<CategoryResponse> getAllCategories() {
        return categoryServices.getAllCategories();
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public CategoryResponse updateCategory(
            @PathVariable Long id,
            @RequestBody CategoryRequest request) {

        return categoryServices.updateCategory(id, request);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteCategory(@PathVariable Long id) {
        categoryServices.deleteCategory(id);
    }
}