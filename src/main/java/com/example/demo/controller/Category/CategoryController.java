package com.example.demo.controller.Category;

import com.example.demo.dto.Category.CategoryRequest;
import com.example.demo.dto.Category.CategoryResponse;
import com.example.demo.services.CategoryServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryServices categoryServices;

    @PostMapping
    public CategoryResponse createCategory(@RequestBody CategoryRequest request) {
        return categoryServices.createCategory(request);
    }

    @GetMapping("/All")
    public List<CategoryResponse> getAllCategories() {
        return categoryServices.getAllCategories();
    }
}